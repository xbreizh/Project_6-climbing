package org.example.demo.climb.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.example.demo.climb.business.contract.MemberManager;
import org.example.demo.climb.model.bean.Member;
import org.example.demo.climb.model.exception.NotFoundException;

import javax.inject.Inject;
import java.util.List;

public class GestionMemberAction extends LoginAction {
    private Member member;
    private int id;
    private String login;
    private String email;
    private String emailCheck;
    private String password;
    private String passwordCheck;
    private List<Member> listMember;
    private String description;
    private boolean active;

    @Inject
    private MemberManager memberManager;

    public Member getMember() {
        return member;
    }

    public String getDescription() {
        return description;
    }
    public boolean isActive() {
        return active;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailCheck() {
        return emailCheck;
    }

    public void setEmailCheck(String emailCheck) {
        this.emailCheck = emailCheck;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordCheck() {
        return passwordCheck;
    }

    public void setPasswordCheck(String passwordCheck) {
        this.passwordCheck = passwordCheck;
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

    public List<Member> getListMember() throws NotFoundException {
        System.out.println(memberManager.getMemberById(1));
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
        if(login !=null || password!=null || passwordCheck !=null) {
            if (login.equals("")) {
                this.addFieldError("login", "you must provide a login");
                return vResult;
            } else if (this.password.length() < 3 || this.password.length() > 8) {
                this.addFieldError("password", "must be between 3 and 8 characters");
                return vResult;
            } else if (!this.password.equals(passwordCheck)) {
                this.addFieldError("password", "password mismatch");
                return vResult;
            }
            if (memberManager.updatePassword(login, email, password)) {
                return vResult = ActionSupport.SUCCESS;
            } else {
                this.addFieldError("login", "Login or Email incorrect");
            }
        }
        return vResult;
    }
    private String validDoCreate(String vResult) {

        // checking if existing member with the proposed login
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
            else if(!this.member.getPassword().equals(passwordCheck)){
                this.addFieldError("member.password", "password mismatch");
            }
            else if(!this.member.getEmail().equals(emailCheck)){
                this.addFieldError("member.email", "email mismatch");
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
        member = memberManager.getMemberById(id);

        if (this.hasErrors()) {
            vResult = ActionSupport.ERROR;
        }
        return vResult;
    }

    public String doEdit() {
        System.out.println("id: "+id);
        try {
            member = memberManager.getMemberById(id);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("doedit id: "+member);
        System.out.println("active: "+member.isActive());
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
