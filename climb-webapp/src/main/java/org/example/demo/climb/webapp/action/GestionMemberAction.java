package org.example.demo.climb.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.example.demo.climb.business.contract.manager.MemberManager;
import org.example.demo.climb.model.bean.member.Member;
import org.example.demo.climb.model.exception.NotFoundException;

import javax.inject.Inject;
import java.util.List;

public class GestionMemberAction extends ActionSupport {

    private Member member;
    private List<Member> listMember;
    private int id;
    @Inject
    private MemberManager memberManager;

    // Getters - Setters
    /* private String login;*/

   /* private String password;
    private String description;

    // Getters and Setters
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }*/
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
    }/*

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
    *//*Getters / Setters*/

    /*public Integer getId() {
        return id;
    }*/

    public String doDetail() throws NotFoundException {
        String vResult = ActionSupport.SUCCESS;
        System.out.println("Member mgmt: " + member);
        System.out.println("Id: " + id);

        member = memberManager.getMember(id);
        System.out.println("Member from doDetail: " + member);

        if (this.hasErrors()) {
            vResult = ActionSupport.ERROR;
        }
        return vResult;
    }
    public String doEdit() {
        String vResult = ActionSupport.SUCCESS;
        try {
            member = memberManager.getMember(id);
        } catch (NotFoundException e) {
            this.addActionError(e.toString());
        }
        if (this.hasErrors()) {
            vResult = ActionSupport.ERROR;
        }
        return vResult;
    }


    /*public void setId(Integer id) {
        this.id = id;
    }*/

    /* Méthodes */

    public String doCreate() {
        String vResult = ActionSupport.INPUT;

        if (this.member != null) {
            memberManager.addMember(member);
            vResult = ActionSupport.SUCCESS;

        }
        if (this.hasErrors()) {
            vResult = ActionSupport.ERROR;
        }
        return vResult;
    }

    public String doList(){
        listMember = memberManager.getListMember();
        return ActionSupport.SUCCESS;
    }


    public String doUpdate() {
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

    public String doDelete() {
        String vResult = ActionSupport.SUCCESS;
        System.out.println("delete id: " + id);


        memberManager.deleteMember(id);

        if (this.hasErrors()) {
            vResult = ActionSupport.ERROR;
        }
        return vResult;

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
