package org.example.demo.climb.webapp.action;

import java.util.List;
import javax.inject.Inject;

import com.opensymphony.xwork2.ActionSupport;

import org.example.demo.climb.business.contract.manager.MemberManager;
import org.example.demo.climb.model.bean.Spot;
import org.example.demo.climb.model.bean.member.Member;
import org.example.demo.climb.model.exception.NotFoundException;


/**
 * Action de démo pour les appels AJAX
 */
public class DemoAjaxAction extends ActionSupport {

    // ==================== Attributs ====================
    @Inject
    private MemberManager memberManager;



    // ----- Eléments en entree
    private Member member;

    // ----- Eléments en sortie
    private List<Member> listMember;
    private List<Spot> spotList;

    // ==================== Getters/Setters ====================

    public List<Spot> getSpotList() {
        return spotList;
    }
    public List<Member> getListMember() {
        return listMember;
    }
    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }


    // ==================== Méthodes ====================
    public String execute() {
        listMember = memberManager.getListMember();
        return ActionSupport.SUCCESS;
    }


    /**
     * Action "AJAX" renvoyant la liste des projets
     * @return success
     */
    public String doAjaxGetListMember() {
        System.out.println("trying to get member lists");
        listMember = memberManager.getListMember();
        System.out.println("got the members list");
        System.out.println("Liste: "+member.getSpotList());
        return ActionSupport.SUCCESS;
    }
    /**
     * Action "AJAX" renvoyant la liste des versions d'un projet
     * @return success / error
     */
    public String doAjaxGetListSpot() throws NotFoundException {
        System.out.println("Liste de spots: "+spotList);
        if (member == null) {
            addActionError("Le membre doit être précisé !");
        } else {
            spotList = memberManager.getMember().getSpotList();
        }

        return hasErrors() ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }

}