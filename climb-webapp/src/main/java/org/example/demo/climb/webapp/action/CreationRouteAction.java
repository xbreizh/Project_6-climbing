package org.example.demo.climb.webapp.action;


import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.example.demo.climb.business.contract.manager.CountryManager;
import org.example.demo.climb.business.contract.manager.RouteManager;
import org.example.demo.climb.business.contract.manager.SpotManager;
import org.example.demo.climb.model.bean.Country;
import org.example.demo.climb.model.bean.Route;
import org.example.demo.climb.model.bean.Spot;
import org.example.demo.climb.model.exception.NotFoundException;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CreationRouteAction extends LoginAction implements SessionAware {

    private Route route;
    private int id;

    private String country;
    private List<Integer> heighList=new ArrayList<>();
    private List<String> gradeList=new ArrayList<>();
    private List<String> typeList=new ArrayList<>();
    private List<Route> routeList=new ArrayList<>();


    private Spot spot;

    @Inject
    private SpotManager spotManager;
    @Inject
    private RouteManager routeManager;

    // Methodes


    public String doList() throws  NotFoundException{
        spot = spotManager.getSpotById(id);
        routeList = spot.getRouteList();
        System.out.println("tried to get the route liste");
        return ActionSupport.SUCCESS;
    }
    public String doCreateRoute() throws NotFoundException {
        String vResult= ActionSupport.INPUT;
        System.out.println("je suis suppose etre la");

        if(route!=null){
            route.setName(route.getName().toUpperCase());
            routeManager.addRoute(route);
            this.addActionMessage("Route "+route.getName()+" successfully created");
            vResult = ActionSupport.SUCCESS;
        }else{
            spot = spotManager.getSpotById(id);
            gradeList = routeManager.getListGrade();
            typeList = routeManager.getListClimbingType();
            heighList= IntStream.range(1, 50).boxed().collect(Collectors.toList());
        }
        return vResult;
    }


    public String doDetail() throws NotFoundException {
        String vResult = ActionSupport.SUCCESS;
        try {
            route = routeManager.getRouteById(id);
            System.out.println("getting route: " + route.getName());
        }catch(NotFoundException e){
            System.err.println("Route not found: "+e.getMessage());
        }
        if (this.hasErrors()) {
            vResult = ActionSupport.ERROR;
        }
        return vResult;
    }

    public String doEdit() {
        String vResult = ActionSupport.SUCCESS;

        if (this.hasErrors()) {
            vResult = ActionSupport.ERROR;
        }
        return vResult;
    }
    public String doUpdate() {
        String vResult = ActionSupport.INPUT;


        if (this.hasErrors()) {
            System.out.println("Spot is null");
            vResult = ActionSupport.ERROR;
        }
        return vResult;
    }

    public String doDelete() throws  NotFoundException{

        return ActionSupport.SUCCESS;
    }


    // Getters and Setters

    public List<Route> getRouteList() {
        return routeList;
    }

    public void setRouteList(List<Route> routeList) {
        this.routeList = routeList;
    }
    public Spot getSpot() {
        return spot;
    }

    public void setSpot(Spot spot) {
        this.spot = spot;
    }
    public List<Integer> getHeighList() {
        return heighList;
    }

    public void setHeighList(List<Integer> heighList) {
        this.heighList = heighList;
    }

    public List<String> getGradeList() {
        return gradeList;
    }

    public void setGradeList(List<String> gradeList) {
        this.gradeList = gradeList;
    }

    public List<String> getTypeList() {
        return typeList;
    }

    public void setTypeList(List<String> typeList) {
        this.typeList = typeList;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
