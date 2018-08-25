package org.example.demo.climb.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.example.demo.climb.business.contract.ManagerFactory;
import org.example.demo.climb.model.bean.Member;
import org.example.demo.climb.webapp.WebappHelper;

import javax.inject.Inject;
import java.util.List;

public class GestionMemberAction extends ActionSupport {

    private Integer id;
    private Member member;
    private List<Member> listMember;
    @Inject
    private ManagerFactory managerFactory;


    /*Getters / Setters*/

    public List<Member> getListMember() {
        return listMember;
    }
    public Integer getId() {
        return id;
    }

    public Member getUtilisateur() {
        return member;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /*Méthodes*/

    public String doList(){
        listMember = WebappHelper.getManagerFactory().getMemberManager().getListMember();
        return ActionSupport.SUCCESS;
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
