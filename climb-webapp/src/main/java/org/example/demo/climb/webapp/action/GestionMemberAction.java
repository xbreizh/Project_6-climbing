package org.example.demo.climb.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.example.demo.climb.business.contract.manager.MemberManager;
import org.example.demo.climb.model.bean.Member;

import javax.inject.Inject;
import java.util.List;

public class GestionMemberAction extends ActionSupport {


    private Member member;
    private List<Member> listMember;
    @Inject
    private MemberManager memberManager;
    private String login;
    private int id;
    private String password;
    private String description;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
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
    /*Getters / Setters*/

    public List<Member> getListMember() {
        return listMember;
    }
    /*public Integer getId() {
        return id;
    }*/

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    /*public void setId(Integer id) {
        this.id = id;
    }*/

    /*Méthodes*/

    public String doList(){
        listMember = memberManager.getListMember();
        return ActionSupport.SUCCESS;
    }

    public String doUpdate() {
        String vResult = ActionSupport.INPUT;
        System.out.println("Member: " + member);
        if (this.member != null) {
            memberManager.updateMember(member);
            vResult = ActionSupport.SUCCESS;

        }
        if (this.hasErrors()) {
            vResult = ActionSupport.ERROR;
        }
        return vResult;
    }

    public String doCreate() {
        String vResult = ActionSupport.INPUT;

        if (this.member != null) {
            memberManager.updateMember(member);
            vResult = ActionSupport.SUCCESS;

        }
        if (this.hasErrors()) {
            vResult = ActionSupport.ERROR;
        }
        return vResult;
    }

    // ==================== Méthodes ====================


    public String doDetail() {
        return ActionSupport.SUCCESS;
    }


    /*public String doDetail() {
        if (id == null) {
            this.addActionError(getText("error.user.missing.id"));
        } else {
            try {
                member = managerFactory.getManager().getMember(id);
            } catch (NotFoundException pE) {
                this.addActionError(getText("error.user.notfound", Collections.singletonList(id)) );
            }
        }

        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;

    }*/
}
