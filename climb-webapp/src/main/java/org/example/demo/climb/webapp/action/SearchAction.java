package org.example.demo.climb.webapp.action;


import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.example.demo.climb.business.contract.*;
import org.example.demo.climb.model.bean.*;
import org.example.demo.climb.model.exception.NotFoundException;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class SearchAction extends LoginAction implements SessionAware {

    private int id;
    private List<Spot> spotList=new ArrayList<>();
    private List<Topo> topoList=new ArrayList<>();
    private Spot spot;
    private Topo topo;
    private String str;
    private String climbingType;
    private String hasTopo;

    @Inject
    private CommentManager commentManager;
    @Inject
    private RouteManager routeManager;
    @Inject
    private SpotManager spotManager;
    @Inject
    private SearchManager searchManager;
    @Inject
    private TopoManager topoManager;


    // Methodes


    public String doSearchByKeyword() throws  NotFoundException {
        String vResult = ActionSupport.INPUT;
        if (str != null) {
            if (str.equals("")) {
                this.addActionError("you must enter a keyword");
            } else {
                System.out.println("keyword valid: "+str);
                spotList=searchManager.findSpotByString(str);
                topoList=searchManager.findTopoByString(str);
                return ActionSupport.SUCCESS;
            }
        }
        return vResult;
    }
    public String doListTopo() throws  NotFoundException{
        String vResult= ActionSupport.SUCCESS;
        System.out.println("trying to get a list with keyword: "+str);
        System.out.println("climbing type passed: "+climbingType);
        System.out.println("has topo passed: "+hasTopo);
        spotList=searchManager.findSpotByString(str);
        topoList=searchManager.findTopoByString(str);
        System.out.println("size spot: "+spotList.size());
        System.out.println("size topo: "+topoList.size());
       /* if(str.equals("")){
            return vResult;
        }else{
            spotList=searchManager.findSpotByString(str);
        }*/
        return ActionSupport.SUCCESS;
    }
   /* public String doListCommentSpot() throws  NotFoundException{
        *//* commentList = commentManager.getListComment();*//*
        spot = spotManager.getSpotById(id);
        if(spot!=null){
            System.out.println("tried to get the comment liste");
            commentListSpot = commentManager.getListCommentFromSpot(spot.getId());
            System.out.println(spot.getName());
        }
        if(commentListSpot.size() > 0) {
            System.out.println("text from comment: " + commentListSpot.get(0).getText());
        }
        return ActionSupport.SUCCESS;
    }
    public String doCreateCommentRoute() throws NotFoundException {
        String vResult= ActionSupport.INPUT;
        System.out.println("je suis suppose etre la");

        if(comment!=null){
            System.out.println("comment text: "+comment.getText());
            System.out.println("comment member: "+comment.getMemberComment().getLogin());
            System.out.println("comment route: "+comment.getRoute().getName());
            commentManager.addComment(comment);
            vResult = ActionSupport.SUCCESS;
        }else{
        }
        return vResult;
    }

    public String doCreateCommentSpot() throws NotFoundException {
        String vResult= ActionSupport.INPUT;
        System.out.println("je suis suppose etre la");

        if(comment!=null){
            System.out.println("comment text: "+comment.getText());
            System.out.println("comment member: "+comment.getMemberComment().getLogin());
            System.out.println("comment route: "+comment.getSpot().getName());
            commentManager.addComment(comment);
            vResult = ActionSupport.SUCCESS;
        }else{
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
    }*/


    // Getters and Setters
    public List<Topo> getTopoList() {
        return topoList;
    }

    public void setTopoList(List<Topo> topoList) {
        this.topoList = topoList;
    }
    public Topo getTopo() {
        return topo;
    }

    public void setTopo(Topo topo) {
        this.topo = topo;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Spot> getSpotList() {
        return spotList;
    }

    public void setSpotList(List<Spot> spotList) {
        this.spotList = spotList;
    }

    public Spot getSpot() {
        return spot;
    }

    public void setSpot(Spot spot) {
        this.spot = spot;
    }
    public String getClimbingType() {
        return climbingType;
    }

    public void setClimbingType(String climbingType) {
        this.climbingType = climbingType;
    }

    public String getHasTopo() {
        return hasTopo;
    }

    public void setHasTopo(String hasTopo) {
        this.hasTopo = hasTopo;
    }
}
