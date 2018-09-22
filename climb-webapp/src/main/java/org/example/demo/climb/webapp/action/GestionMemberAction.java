package org.example.demo.climb.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.example.demo.climb.business.contract.manager.MemberManager;
import org.example.demo.climb.model.bean.member.Member;
import org.example.demo.climb.model.exception.NotFoundException;

import javax.inject.Inject;
import java.util.List;

public class GestionMemberAction extends ActionSupport {
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    private Member member;
    private List<Member> listMember;
    private int id;
    private String login;
    private String password;

    public String getPassword_check() {
        return password_check;
    }

    public void setPassword_check(String password_check) {
        this.password_check = password_check;
    }

    private String password_check;

/*    public String getDescription() {
        return description;
    }

    private String description;*/

    @Inject
    private MemberManager memberManager;

    public Member getMember() {
       return member;
   }

    public void setMember(Member member) {
        this.member = member;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Member> getListMember() {
        return listMember;
    }

    /* Méthodes */

    public String doCreate() {
        String vResult = ActionSupport.INPUT;

        vResult = validDoCreate(vResult);
        if (this.hasErrors()) {
            vResult = ActionSupport.INPUT;
        }
        return vResult;
    }

    public String doReset(){
        String vResult = ActionSupport.INPUT;
        if(login !=null || password!=null || password_check !=null) {
            if (login.equals("")) {
                this.addFieldError("login", "you must provide a login");
                return vResult;
            } else if (this.password.length() < 3 || this.password.length() > 8) {
                this.addFieldError("password", "must be between 3 and 8 characters");
                return vResult;
            } else if (!this.password.equals(password_check)) {
                this.addFieldError("password", "password mismatch");
                return vResult;
            }
            if (memberManager.updatePassword(login, password)) {
                return vResult = ActionSupport.SUCCESS;
            } else {
                this.addFieldError("login", "this login doesn't exist");
            }
        }
        return vResult;
    }
    private String validDoCreate(String vResult) {


        if (this.member != null) {
            boolean exist= memberManager.exists(this.member.getLogin());
            if (this.member.getLogin().equals("")) {
                this.addFieldError("member.login", "is empty");
            }
            if(exist){
                System.out.println("Login1: "+member.getLogin()+ "exists: "+exist);
                this.addFieldError("member.login", "Login already exists! Pick another one!");
            }
            else if (this.member.getPassword().length() < 3 || this.member.getPassword().length() > 8) {
                this.addFieldError("member.password", "must be between 3 and 8 characters");
            }
            else if(!this.member.getPassword().equals(password_check)){
                this.addFieldError("member.password", "password mismatch");
            }else {
                try {
                    memberManager.addMember(member);
                    vResult = ActionSupport.SUCCESS;
                    this.addActionMessage("Member added!");
                } catch (NullPointerException e) {
                    this.addActionError(e.getMessage());
                }
            }
        }else{
            this.addActionError("No member found");
            vResult = ActionSupport.INPUT;
        }
        return vResult;
    }

    public String doDetail() throws NotFoundException {
        String vResult = ActionSupport.SUCCESS;
        member = memberManager.getMember(id);

        if (this.hasErrors()) {
            vResult = ActionSupport.ERROR;
        }
        return vResult;
    }

    public String doEdit() {

        return ActionSupport.SUCCESS;
    }


    public String doList(){
        listMember = memberManager.getListMember();
        return ActionSupport.SUCCESS;
    }


    public String doUpdate() {
        String vResult = ActionSupport.INPUT;

        if (this.member != null) {
            memberManager.updateMember(member);
            System.out.println("Member: "+member);
            vResult = ActionSupport.SUCCESS;

        }
        if (this.hasErrors()) {
            vResult = ActionSupport.ERROR;
        }
        return vResult;
    }

    public String doDelete() {
        String vResult = ActionSupport.SUCCESS;


        memberManager.deleteMember(id);

        if (this.hasErrors()) {
            vResult = ActionSupport.ERROR;
        }
        return vResult;

    }


}
