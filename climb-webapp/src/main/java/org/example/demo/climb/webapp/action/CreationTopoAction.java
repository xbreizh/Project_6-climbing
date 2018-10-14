package org.example.demo.climb.webapp.action;


import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.example.demo.climb.business.contract.CountryManager;
import org.example.demo.climb.business.contract.SpotManager;
import org.example.demo.climb.business.contract.TopoManager;
import org.example.demo.climb.model.bean.Country;
import org.example.demo.climb.model.bean.Route;
import org.example.demo.climb.model.bean.Spot;
import org.example.demo.climb.model.bean.Topo;
import org.example.demo.climb.model.exception.NotFoundException;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class CreationTopoAction extends LoginAction implements SessionAware {


    private Topo topo;
    private List<Topo> topoList;



    @Inject
    private TopoManager topoManager;

    // Methodes

   /* public String doListContinent() throws NotFoundException {
        String vResult= ActionSupport.SUCCESS;

        continentList=countryManager.getListContinent();
        return vResult;
    }
    public String doListCountry() throws NotFoundException {
        String vResult= ActionSupport.SUCCESS;
        System.out.println("checking country");
        System.out.println("id: "+id);
        if(id!=0){
            continent = countryManager.getCountry(id).getContinent();
        }
        System.out.println("continent: "+continent);
        countryList = countryManager.getListCountryByContinent(continent);
        return vResult;
    }
    public String doListCity() throws NotFoundException {
        String vResult= ActionSupport.SUCCESS;
        if(id!=0) {
            System.out.println("c is null!");
            c=countryManager.getCountry(id);
        }else {
            c = countryManager.getCountry(country);
            System.out.println("setting up c: " + c.getName());
        }
        cityList = spotManager.getListCityByCountry(c);
        return vResult;
    }
    public String doList() throws  NotFoundException{
        spotList = spotManager.getListSpot();
        return ActionSupport.SUCCESS;
    }*/
    public String doCreateTopo() throws NotFoundException {
        System.out.println("trying to create a topo");
        String vResult= ActionSupport.INPUT;
        /*c = countryManager.getCountry(id);
        System.out.println("city is here: "+city);*/
        if(topo!=null){
            topoManager.addTopo(topo);
            vResult = ActionSupport.SUCCESS;
        }
        return vResult;
    }

    public String doList() {
        topoList=topoManager.getListTopo();
        System.out.println("trying to get topoList");
        System.out.println("size: " + topoList.size());
        return ActionSupport.SUCCESS;
    }
   /* public String doDetail() throws NotFoundException {
        String vResult = ActionSupport.SUCCESS;
        System.out.println("tentative de recuperation de l'id: "+id);
        spot = spotManager.getSpotById(id);
        *//*System.out.println(spot);*//*
        routeList = spot.getRouteList();
        System.out.println("size routeList: "+routeList.size());
        if (this.hasErrors()) {
            vResult = ActionSupport.ERROR;
        }
        System.out.println("vresult: "+vResult.toString());
        return vResult;
    }

    public String doTest(){
        System.out.println("test ok");
        return ActionSupport.SUCCESS;
    }

    public String doEdit() {
        String vResult = ActionSupport.SUCCESS;
        System.out.println("tentative de recuperation de l'id from doEdit: "+id);
        try {
            spot = spotManager.getSpotById(id);
            System.out.println("doedit: " + id);
        } catch (NotFoundException e) {
            this.addActionError(e.toString());
        }
        if (this.hasErrors()) {
            vResult = ActionSupport.ERROR;
        }
        return vResult;
    }
    public String doUpdate() {
        String vResult = ActionSupport.INPUT;

        if (spot != null) {
            System.out.println("id de spot: "+spot.getId());
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
        System.out.println("ici");
        String vResult = ActionSupport.SUCCESS;
        System.out.println(this.hasActionErrors());
        System.out.println("delete id: " + id);

        System.out.println("trying des trucs");
        spotManager.deleteSpot(id);

        if (this.hasErrors()) {
            vResult = ActionSupport.ERROR;
        }
        return vResult;

    }*/
    // Getters and Setters

    public Topo getTopo() {
        return topo;
    }

    public void setTopo(Topo topo) {
        this.topo = topo;
    }
    public List<Topo> getTopoList() {
        return topoList;
    }

    public void setTopoList(List<Topo> topoList) {
        this.topoList = topoList;
    }
}
