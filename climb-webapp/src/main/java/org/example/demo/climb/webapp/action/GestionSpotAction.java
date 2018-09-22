package org.example.demo.climb.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.example.demo.climb.business.contract.manager.MemberManager;
import org.example.demo.climb.business.contract.manager.SpotManager;
import org.example.demo.climb.model.bean.Spot;
import org.example.demo.climb.model.exception.NotFoundException;

import javax.inject.Inject;
import java.util.List;

public class GestionSpotAction extends ActionSupport {

    private Spot spot;
    private List<Spot> listSpot;

    private int id;

    @Inject
    private SpotManager spotManager;
    @Inject
    private MemberManager memberManager;

    // Getters & Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Spot getSpot() {
        return spot;
    }

    public void setSpot(Spot spot) {
        this.spot = spot;
    }

    public List<Spot> getListSpot() {
        return listSpot;
    }

    public void setListSpot(List<Spot> listSpot) {
        this.listSpot = listSpot;
    }


    public String doCreate() throws NotFoundException {
        String vResult = ActionSupport.INPUT;

        if (this.spot != null) {
            spot.setCreator(memberManager.getMember(1));
            spotManager.addSpot(spot);
            vResult = ActionSupport.SUCCESS;
            System.out.println("Action: " + spot);
        }
        if (this.hasErrors()) {
            vResult = ActionSupport.ERROR;
        }
        return vResult;
    }

    public String doDetail() throws NotFoundException {
        String vResult = ActionSupport.SUCCESS;
        System.out.println("Spot mgmt: " + spot);
        System.out.println("Id: " + id);

        spot = spotManager.getSpot(id);
        System.out.println("Member from doDetail: " + spot);

        if (this.hasErrors()) {
            vResult = ActionSupport.ERROR;
        }
        return vResult;
    }

    public String doEdit() {
        String vResult = ActionSupport.SUCCESS;
        try {
            spot = spotManager.getSpot(id);
            System.out.println("doedit: " + id);
        } catch (NotFoundException e) {
            this.addActionError(e.toString());
        }
        if (this.hasErrors()) {
            vResult = ActionSupport.ERROR;
        }
        return vResult;
    }

    public String doList() {
        System.out.println("spot");
        listSpot = spotManager.getListSpot();
        System.out.println("size: " + listSpot.size());
        return ActionSupport.SUCCESS;
    }

    public String doUpdate() {
        String vResult = ActionSupport.INPUT;

        if (this.spot != null) {
            spotManager.updateSpot(spot);
            vResult = ActionSupport.SUCCESS;
            System.out.println("Spot: " + spot);

        }
        if (this.hasErrors()) {
            System.out.println("Spot is null");
            vResult = ActionSupport.ERROR;
        }
        return vResult;
    }

    public String doDelete() {
        String vResult = ActionSupport.SUCCESS;
        System.out.println("delete id: " + id);


        spotManager.deleteSpot(id);

        if (this.hasErrors()) {
            vResult = ActionSupport.ERROR;
        }
        return vResult;

    }

}
