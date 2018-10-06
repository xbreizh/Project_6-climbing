package org.example.demo.climb.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.example.demo.climb.business.contract.manager.MemberManager;
import org.example.demo.climb.business.contract.manager.SpotManager;
import org.example.demo.climb.model.bean.Spot;
import org.example.demo.climb.model.bean.Zone;
import org.example.demo.climb.model.bean.Member;
import org.example.demo.climb.model.exception.NotFoundException;

import javax.inject.Inject;
import java.util.List;


/**
 * Action de démo pour les appels AJAX
 */
public class DemoAjaxActionBackup extends LoginAction {

    // ==================== Attributs ====================
    @Inject
    private MemberManager memberManager;
    @Inject
    private SpotManager spotManager;



    // ----- Eléments en entree
    private Member member;
    private Spot spot;
    private Zone zone;

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public List<Zone> getZoneList() {
        return zoneList;
    }

    public void setZoneList(List<Zone> zoneList) {
        this.zoneList = zoneList;
    }

    public Spot getSpot() {
        return spot;
    }

    public void setSpot(Spot spot) {
        this.spot = spot;
    }

    // ----- Eléments en sortie
    private List<Member> listMember;
    private List<Spot> spotList;
    private List<Zone> zoneList;

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
        /*System.out.println("Liste: "+member.getSpotList());*/
        if(member==null) {
            member = listMember.get(0);
        }
        return ActionSupport.SUCCESS;

    }
    /**
     * Action "AJAX" renvoyant la liste des versions d'un projet
     * @return success / error
     */
    public String doAjaxGetListSpot() throws NotFoundException {
        System.out.println("display member: "+member.getLogin());
        System.out.println("list for that member: " +spotList);
        System.out.println("trying to get spot: ");
        if (member == null) {
            addActionError("Le membre doit être précisé !");
        } else {
            System.out.println("Member is: "+member);
            /*spotList = member.getSpotList();*/
            System.out.println("Liste de spots: "+spotList);
        }
        /*spotList=memberManager.getMember(4).getSpotList();*/
        /*spotList = spotManager.getListSpot();*/
        return hasErrors() ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }

}