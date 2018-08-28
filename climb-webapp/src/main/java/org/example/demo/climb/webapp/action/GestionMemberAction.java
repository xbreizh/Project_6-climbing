package org.example.demo.climb.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.example.demo.climb.business.contract.manager.MemberManager;
import org.example.demo.climb.model.bean.Member;

import javax.inject.Inject;
import java.util.List;

public class GestionMemberAction extends ActionSupport {

    private Integer id;
    private Member member;
    private List<Member> listMember;
    @Inject
    private MemberManager memberManager;


    /*Getters / Setters*/

    public List<Member> getListMember() {
        return listMember;
    }
    public Integer getId() {
        return id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /*Méthodes*/

    public String doList(){
        listMember = memberManager.getListMember();
        return ActionSupport.SUCCESS;
    }

    public String doCreate() {
        String vResult = ActionSupport.INPUT;

        if (this.member != null) {
            member.setId(59);
            memberManager.addMember(member);
            vResult = ActionSupport.SUCCESS;

        }
        if (this.hasErrors()) {
            vResult = ActionSupport.ERROR;
        }
        return vResult;
    }

    // ==================== Méthodes ====================
    /**
     * Action affichant les détails d'un {@link Member}
     * @return success / error
     */
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
