package org.example.demo.climb.webapp.action;


import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.example.demo.climb.business.contract.RouteManager;
import org.example.demo.climb.business.contract.SpotManager;
import org.example.demo.climb.model.Grade;
import org.example.demo.climb.model.bean.Route;
import org.example.demo.climb.model.bean.Spot;
import org.example.demo.climb.model.exception.NotFoundException;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CreationRouteAction extends LoginAction implements SessionAware {

    private Route route;
    private int id;
    private String country;
    private List<Integer> heighList=new ArrayList<>();
    private List<Route> routeList=new ArrayList<>();
    private HashMap<Integer, String> gradeList= new HashMap<>();
    private Spot spot;

    @Inject
    private SpotManager spotManager;
    @Inject
    private RouteManager routeManager;

    // METHODS

    private void initLevelList() {
        int index=0;
        //adding default condition
        gradeList.put(index, "0");
        for(Grade g: Grade.values()){
            index++;
            gradeList.put(index,g.getValue());
        }

    }
    /*CREATE*/
    public String doCreateRoute() throws NotFoundException {
        String vResult= ActionSupport.INPUT;
        System.out.println("je suis suppose etre la");
        initLevelList();
        if(route!=null){
            /*gradeList = routeManager.getListGrade();*/
            /*typeList = routeManager.getListClimbingType();*/
            heighList= IntStream.range(1, 50).boxed().collect(Collectors.toList());
            if(routeManager.getRouteByName(route.getName().toUpperCase())==null){
                route.setName(route.getName().toUpperCase());
                routeManager.addRoute(route);
                this.addActionMessage("Route "+route.getName()+" successfully created");
                vResult = ActionSupport.SUCCESS;
            }else{
                System.out.println("id from route: "+route.getSpot().getId());
                spot = spotManager.getSpotById(route.getSpot().getId());
                System.out.println("id found: "+spot.getId());

                System.out.println("error found");

                this.addActionError("That route already exists, " +
                        "if you wish to add some new information, please add a comment ");
                /*return ActionSupport.ERROR;*/
            }
        }else{
            spot = spotManager.getSpotById(id);
            /*gradeList = routeManager.getListGrade();*/
            /*typeList = routeManager.getListClimbingType();*/
            heighList= IntStream.range(1, 50).boxed().collect(Collectors.toList());
        }
        return vResult;
    }

    /*READ ALL*/
    public String doList() throws  NotFoundException{
        spot = spotManager.getSpotById(id);
        routeList = spot.getRouteList();
        System.out.println("tried to get the route liste");
        return ActionSupport.SUCCESS;
    }


    /*READ ONE*/
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

    /*EDIT*/
    public String doEdit() {
        System.out.println("id: "+id);
        try {
           /* gradeList = routeManager.getListGrade();*/
            /*typeList = routeManager.getListClimbingType();*/
            heighList= IntStream.range(1, 50).boxed().collect(Collectors.toList());
            route = routeManager.getRouteById(id);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("doedit id: "+route.getId());
        return ActionSupport.SUCCESS;
    }

    /*EDIT*/
    public String doUpdate() {
        String vResult = ActionSupport.INPUT;

        if (this.route != null) {
            System.out.println(route.getId());
            routeManager.updateRoute(route);
            System.out.println("Route: "+route);
            vResult = ActionSupport.SUCCESS;
        }
        if (this.hasErrors()) {
            vResult = ActionSupport.ERROR;
        }
        return vResult;
    }

    /*DELETE*/
    public String doDelete() throws  NotFoundException{
        routeManager.deleteRoute(id);
        return ActionSupport.SUCCESS;
    }


    /***********************************************************************/
    /************************ GETTERS - SETTERS ***************************/
    /***********************************************************************/

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

    public HashMap<Integer, String> getGradeList() {
        return gradeList;
    }

    public void setGradeList(HashMap<Integer, String> gradeList) {
        this.gradeList = gradeList;
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
