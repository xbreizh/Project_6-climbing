package org.example.demo.climb.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.example.demo.climb.consumer.contract.manager.MemberManager;
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


        memberManager.deleteMember(id);

        if (this.hasErrors()) {
            vResult = ActionSupport.ERROR;
        }
        return vResult;

    }




}
