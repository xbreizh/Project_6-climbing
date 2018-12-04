package org.example.demo.climb.webapp.action;


import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.EnumUtils;
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
    private int spotId;
    private String country;
   /* private List<Integer> heightList=new ArrayList<>();*/
    private List<Route> routeList=new ArrayList<>();
    private HashMap<Integer, String> gradeList= new HashMap<>();
    private HashMap<Integer, Integer> heightList= new HashMap<>();
    private Spot spot;
    private boolean submit =false;

    @Inject
    private SpotManager spotManager;
    @Inject
    private RouteManager routeManager;

    // METHODS

    public  void initGradeList() {
        int index=0;
        //adding default condition
        gradeList.put(index, "0");
        for(Grade g: Grade.values()){
            index++;
            gradeList.put(index,g.getValue());
        }

    }

    private void initHeightList(){
        int index=0;
        //adding default condition
        /*heightList.put(index, "0");*/
        for(int i=0; i <50; i++){
            i++;
            heightList.put(i, i);
        }
        System.out.println("size heightlist: "+heightList.size());
    }

    /*EDIT*/
    public String doUpdate() {
        String vResult = ActionSupport.INPUT;
        initGradeList();
        System.out.println("grade list init: "+gradeList.size());
        initHeightList();
        System.out.println("height list init: "+heightList.size());
        if(submit) {
            if (this.route != null) {
                if(checkRouteForm(route)) {
                    System.out.println(route.getId());
                    routeManager.updateRoute(route);
                    System.out.println("Route: " + route);
                    vResult = ActionSupport.SUCCESS;
                }
            }
            /*if (this.hasErrors()) {
                vResult = ActionSupport.ERROR;
            }*/
        }
        return vResult;
    }

    private boolean checkRouteForm(Route route) {
        int error = 0;
       if(route.getName().length() < 1 || route.getName().length() > 50){
           this.addFieldError("route.name", "name should have between 3 and 50 characters");
           System.out.println("name should have between 3 and 50 characters");
           error++;
       }
        if(route.getHeight() < 1 || route.getHeight() > 50){
            this.addFieldError("route.height", "height should be between 1 and 50, please select from the list");
            System.out.println("height should be between 1 and 50, please select from the list");
            error++;
        }
        System.out.println("grade: "+route.getGrade());
        if(route.getGrade() < 1 || route.getGrade() > Grade.values().length){
        this.addFieldError("route.grade", "grade should be between "+Grade.G1.getValue()+" and "+Grade.G32.getValue()
                +", please select from the list");
            System.out.println("grade should be between 1 and "+Grade.values().length
                    +", please select from the list");
            error++;
        }
        if(route.getDescription().length() < 3 || route.getDescription().length() > 250){
            this.addFieldError("route.description", "description should be between 3 and 250 characters");
            System.out.println("description should be between 3 and 250 characters");
            error++;
        }
        if(route.getMemberRoute() == null){
            this.addFieldError("route.memberRoute", "there a problem with your session. Please relog then try again");
            System.out.println("there a problem with your session. Please relog then try again");
            error++;
        }
        if(route.getSpot() == null){
            this.addFieldError("route.spot", "there's no spot selected, please get back to the spot detail and try re-adding the route");
            System.out.println("there's no spot selected, please get back to the spot detail and try re-adding the route");
            error++;
        }
        if(error != 0){
            System.out.println("errors found: "+error);
            return false;
        }
return true;
    }

    /*CREATE*/
    public String doCreateRoute() throws NotFoundException {
        String vResult= ActionSupport.INPUT;
        initGradeList();
        System.out.println("init grade list");
        initHeightList();
        System.out.println("init height list");
        if(route!=null){
            id=route.getSpot().getId();
          /*  if(submit) {*/
            System.out.println("route received: "+route);
                if (checkRouteForm(route)) {
                    System.out.println("trying to add route: "+route);
                    routeManager.addRoute(route);
                    return ActionSupport.SUCCESS;
                /*}*/
            }/*;
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
                *//*return ActionSupport.ERROR;*//*
            }
        }else{
            spot = spotManager.getSpotById(id);
            *//*gradeList = routeManager.getListGrade();*//*
            *//*typeList = routeManager.getListClimbingType();*//*
            *//*heightList= IntStream.range(1, 50).boxed().collect(Collectors.toList());*//*
            initHeightList();*/
        }else{
            System.out.println("route is null");
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

   /* *//*EDIT*//*
    public String doEdit() {
        System.out.println("id: "+id);
        try {
           *//* gradeList = routeManager.getListGrade();*//*
            *//*typeList = routeManager.getListClimbingType();*//*
            initHeightList();
            route = routeManager.getRouteById(id);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("doedit id: "+route.getId());
        return ActionSupport.SUCCESS;
    }*/



    /*DELETE*/
    public String doDelete() throws  NotFoundException{
        if(route!=null) {
            routeManager.deleteRoute(route);
        }else{
            System.out.println("no route received");
        }
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

    public HashMap<Integer, Integer> getHeightList() {
        return heightList;
    }

    public void setHeightList(HashMap<Integer, Integer> heightList) {
        this.heightList = heightList;
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

    public boolean isSubmit() {
        return submit;
    }

    public void setSubmit(boolean submit) {
        this.submit = submit;
    }

    public int getSpotId() {
        return spotId;
    }

    public void setSpotId(int spotId) {
        this.spotId = spotId;
    }
}
