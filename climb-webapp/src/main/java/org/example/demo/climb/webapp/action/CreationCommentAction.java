package org.example.demo.climb.webapp.action;


import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.example.demo.climb.business.contract.manager.CommentManager;
import org.example.demo.climb.business.contract.manager.RouteManager;
import org.example.demo.climb.business.contract.manager.SpotManager;
import org.example.demo.climb.model.bean.Comment;
import org.example.demo.climb.model.bean.Route;
import org.example.demo.climb.model.bean.Spot;
import org.example.demo.climb.model.exception.NotFoundException;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CreationCommentAction extends LoginAction implements SessionAware {

    private Comment comment;
    private int id;

    /*private String country;
    private List<Integer> heighList=new ArrayList<>();
    private List<String> gradeList=new ArrayList<>();
    private List<String> typeList=new ArrayList<>();*/
    private List<Comment> commentList=new ArrayList<>();


    private Route route;

    @Inject
    private CommentManager commentManager;
    @Inject
    private RouteManager routeManager;

    // Methodes


    public String doList() throws  NotFoundException{
       /* commentList = commentManager.getListComment();*/
        route = routeManager.getRouteById(id);
        if(route!=null){
            System.out.println("tried to get the comment liste");
            commentList = commentManager.getListCommentFromRoute(route.getId());
            System.out.println(route.getName());
        }
        if(commentList.size() > 0) {
            System.out.println("text from comment: " + commentList.get(0).getText());
        }
        return ActionSupport.SUCCESS;
    }
    public String doCreateComment() throws NotFoundException {
        String vResult= ActionSupport.INPUT;
        System.out.println("je suis suppose etre la");

        if(comment!=null){
            System.out.println("comment text: "+comment.getText());
            System.out.println("comment member: "+comment.getMemberComment().getLogin());
            System.out.println("comment route: "+comment.getRoute().getName());
            commentManager.addComment(comment);
            vResult = ActionSupport.SUCCESS;
        }else{
            /*comment = commentManager.getSpotById(id);
            gradeList = routeManager.getListGrade();
            typeList = routeManager.getListClimbingType();
            heighList= IntStream.range(1, 50).boxed().collect(Collectors.toList());*/
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


    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }
}
