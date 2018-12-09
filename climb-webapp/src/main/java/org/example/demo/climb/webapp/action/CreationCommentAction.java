package org.example.demo.climb.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;
import org.example.demo.climb.business.contract.CommentManager;
import org.example.demo.climb.business.contract.RouteManager;
import org.example.demo.climb.business.contract.SpotManager;
import org.example.demo.climb.model.bean.Comment;
import org.example.demo.climb.model.bean.Route;
import org.example.demo.climb.model.bean.Spot;
import org.example.demo.climb.model.exception.NotFoundException;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CreationCommentAction extends LoginAction implements SessionAware {
    private Logger logger = Logger.getLogger(this.getClass().getName());
    private Comment comment;
    private int id;
    private List<Comment> commentListRoute=new ArrayList<>();
    private List<Comment> commentListSpot=new ArrayList<>();
    private Route route;
    private Spot spot;


    @Inject
    private CommentManager commentManager;
    @Inject
    private RouteManager routeManager;
    @Inject
    private SpotManager spotManager;

    // METHODS

    //CREATE COMMENT ROUTE
    public String doCreateCommentRoute() throws NotFoundException {
        String vResult= ActionSupport.INPUT;
        logger.debug("je suis suppose etre la");

        if(comment!=null){
            logger.debug("comment received: "+comment.getText());
            if(comment.getText().length() > 0 && comment.getText().length() <100) {
                comment.setDate(new Date());
                commentManager.addComment(comment);
                vResult = ActionSupport.SUCCESS;
            }else{
                this.addFieldError("text", "You must type something");
            }
        }
        return vResult;
    }

    /*CREATE COMMENT SPOT*/
    public String doCreateCommentSpot() throws NotFoundException {
        String vResult= ActionSupport.INPUT;
        if(comment!=null){
            if(comment.getText().length()!=0) {
                if(comment.getSpot() != null || comment.getRoute() != null) {
                    if(comment.getMemberComment()!=null) {
                        comment.setDate(new Date());
                        commentManager.addComment(comment);
                        return ActionSupport.SUCCESS;
                    }else{
                        this.addActionError("you must login to comment");
                    }
                }else{
                    this.addActionError("there is no reference for this message");
                }
            }else{
                this.addFieldError("text","you must type something");
            }
        }
        logger.debug("result from comment: "+vResult);
        /*vResult = ActionSupport.SUCCESS;*/

        return vResult;
    }

    /*READ ALL COMMENTS FROM ROUTE*/
    public String doListCommentRoute() throws  NotFoundException{
        route = routeManager.getRouteById(id);
        if(route!=null){
            logger.debug("tried to get the comment liste");
            commentListRoute = commentManager.getListCommentFromRoute(route.getId());
            logger.debug(route.getName());
        }
        if(commentListRoute.size() > 0) {
            logger.debug("text from comment: " + commentListRoute.get(0).getText());
        }
        return ActionSupport.SUCCESS;
    }
    /*READ ALL COMMENTS FROM SPOT*/
    public String doListCommentSpot() throws  NotFoundException{
        spot = spotManager.getSpotById(id);
        if(spot!=null){
            logger.debug("tried to get the comment liste");
            commentListSpot = commentManager.getListCommentFromSpot(spot.getId());
            logger.debug(spot.getName());
        }
        if(commentListSpot.size() > 0) {
            logger.debug("text from comment: " + commentListSpot.get(0).getText());
        }
        return ActionSupport.SUCCESS;
    }
    public String doListComments() throws Exception {
        commentListSpot = commentManager.getListCommentsSpot();
        logger.debug("trying to get comment spots: "+commentListSpot.size());
        commentListRoute = commentManager.getListCommentsRoute();
        logger.debug("trying to get comment routes: "+commentListRoute.size());
        return "success";
    }

    /*READ ONE*/
    public String doDetail() throws NotFoundException {
        String vResult = ActionSupport.SUCCESS;
        try {
            route = routeManager.getRouteById(id);
            logger.debug("getting route: " + route.getName());
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
        String vResult = ActionSupport.SUCCESS;

        if (this.hasErrors()) {
            vResult = ActionSupport.ERROR;
        }
        return vResult;
    }

    /*UPDATE*/
    public String doUpdate() {
        String vResult = ActionSupport.INPUT;
        if (this.hasErrors()) {
            logger.debug("Spot is null");
            vResult = ActionSupport.ERROR;
        }
        return vResult;
    }

    /*DELETE*/
    public String doDelete() throws  NotFoundException{
        logger.debug("id received in action: "+id);
        comment = commentManager.getComment(id);
        commentManager.deleteComment(comment);
        return ActionSupport.SUCCESS;
    }

    public String doContactAdmin(){
        String vResult = ActionSupport.INPUT;
        if(1==1){
            vResult = ActionSupport.SUCCESS;
        }
        return vResult;
    }


    /***********************************************************************/
    /************************ GETTERS - SETTERS ***************************/
    /***********************************************************************/

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

    public List<Comment> getCommentListRoute() {
        return commentListRoute;
    }

    public void setCommentListRoute(List<Comment> commentList) {
        this.commentListRoute = commentListRoute;
    }

    public List<Comment> getCommentListSpot() {
        return commentListSpot;
    }

    public void setCommentListSpot(List<Comment> commentListSpot) {
        this.commentListSpot = commentListSpot;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }
    public Spot getSpot() {
        return spot;
    }

    public void setSpot(Spot spot) {
        this.spot = spot;
    }



}
