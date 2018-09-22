package org.example.demo.climb.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.example.demo.climb.business.contract.manager.ZoneManager;
import org.example.demo.climb.model.bean.Zone;
import org.example.demo.climb.model.exception.NotFoundException;

import javax.inject.Inject;
import java.util.List;

public class GestionZoneAction extends ActionSupport {

    private Zone zone;
    private List<Zone> listZone;

    private int id;

    @Inject
    private ZoneManager zoneManager;

    // Getters & Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public List<Zone> getListZone() {
        return listZone;
    }

    public void setListZone(List<Zone> listZone) {
        this.listZone = listZone;
    }


    public String doCreate() {
        String vResult = ActionSupport.INPUT;

        if (this.zone != null) {
            zoneManager.addZone(zone);
            vResult = ActionSupport.SUCCESS;
            System.out.println("Action: " + zone);
        }
        if (this.hasErrors()) {
            vResult = ActionSupport.ERROR;
        }
        return vResult;
    }

    public String doDetail() throws NotFoundException {
        String vResult = ActionSupport.SUCCESS;
        System.out.println("Zone mgmt: " + zone);
        System.out.println("Id: " + id);

        zone = zoneManager.getZone(id);
        System.out.println("Zone from doDetail: " + zone);
       /* System.out.println("Creator: "+zone.getCreatorZone().getLogin());*/
        if (this.hasErrors()) {
            vResult = ActionSupport.ERROR;
        }
        return vResult;
    }

    public String doEdit() {
        String vResult = ActionSupport.SUCCESS;
        try {
            zone = zoneManager.getZone(id);
        } catch (NotFoundException e) {
            this.addActionError(e.toString());
        }
        if (this.hasErrors()) {
            vResult = ActionSupport.ERROR;
        }
        return vResult;
    }

    public String doList() {
        System.out.println("zone");
        listZone = zoneManager.getListZone();
        System.out.println("size: " + listZone.size());
        System.out.println("listZone: "+listZone);
        return ActionSupport.SUCCESS;
    }

    public String doUpdate() {
        String vResult = ActionSupport.INPUT;

        if (this.zone != null) {
            zoneManager.updateZone(zone);
            vResult = ActionSupport.SUCCESS;
            System.out.println("Zone: " + zone);

        }
        if (this.hasErrors()) {
            System.out.println("Zone is null");
            vResult = ActionSupport.ERROR;
        }
        return vResult;
    }

    public String doDelete() {
        String vResult = ActionSupport.SUCCESS;
        System.out.println("delete id: " + id);


        zoneManager.deleteZone(id);

        if (this.hasErrors()) {
            vResult = ActionSupport.ERROR;
        }
        return vResult;

    }


}
