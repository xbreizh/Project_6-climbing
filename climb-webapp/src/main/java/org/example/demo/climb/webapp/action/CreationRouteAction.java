package org.example.demo.climb.webapp.action;


import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;
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

public class CreationRouteAction extends LoginAction implements SessionAware {
    private Logger logger = Logger.getLogger(this.getClass().getName());
    private Route route;
    private int id;
    private int spotId;
    private String country;
    private List<Route> routeList = new ArrayList<>();
    private HashMap<Integer, String> gradeList = new HashMap<>();
    private HashMap<Integer, Integer> heightList = new HashMap<>();
    private Spot spot;
    private boolean submit = false;

    @Inject
    private SpotManager spotManager;
    @Inject
    private RouteManager routeManager;

    // METHODS

    public void initGradeList() {
        int index = 0;
        //adding default condition
        gradeList.put(index, "0");
        for (Grade g : Grade.values()) {
            index++;
            gradeList.put(index, g.getValue());
        }

    }

    private void initHeightList() {
        int index = 0;
        //adding default condition
        for (int i = 0; i < 50; i++) {
            i++;
            heightList.put(i, i);
        }
        logger.info("size heightlist: " + heightList.size());
    }

    /*EDIT*/
    public String doUpdate() {
        String vResult = ActionSupport.INPUT;
        initGradeList();
        logger.info("grade list init: " + gradeList.size());
        initHeightList();
        logger.info("height list init: " + heightList.size());
        if (submit) {
            if (this.route != null) {
                if (checkRouteForm(route)) {
                    logger.info(route.getId());
                    routeManager.updateRoute(route);
                    logger.info("Route: " + route);
                    vResult = ActionSupport.SUCCESS;
                }
            }
        }
        return vResult;
    }

    private boolean checkRouteForm(Route route) {
        logger.info("checking route");
        int error = 0;
        if (route.getName().length() < 3 || route.getName().length() > 50) {
            this.addFieldError("route.name", "name should have between 3 and 50 characters");
            logger.info("name should have between 3 and 50 characters");
            error++;
        }
        if (route.getHeight() < 1 || route.getHeight() > 50) {
            this.addFieldError("route.height", "height should be between 1 and 50, please select from the list");
            logger.info("height should be between 1 and 50, please select from the list");
            error++;
        }
        logger.info("grade: " + route.getGrade());
        if (route.getGrade() < 1 || route.getGrade() > Grade.values().length) {
            this.addFieldError("route.grade", "grade should be between " + Grade.G1.getValue() + " and " + Grade.G32.getValue()
                    + ", please select from the list");
            logger.info("grade should be between 1 and " + Grade.values().length
                    + ", please select from the list");
            error++;
        }
        if (route.getDescription().length() < 3 || route.getDescription().length() > 250) {
            this.addFieldError("route.description", "description should be between 3 and 250 characters");
            logger.info("description should be between 3 and 250 characters");
            error++;
        }
        if (route.getMemberRoute() == null) {
            this.addFieldError("route.memberRoute", "there a problem with your session. Please relog then try again");
            logger.info("there a problem with your session. Please relog then try again");
            error++;
        }
        if (route.getSpot() == null) {
            this.addFieldError("route.spot", "there's no spot selected, please get back to the spot detail and try re-adding the route");
            logger.info("there's no spot selected, please get back to the spot detail and try re-adding the route");
            error++;
        }
        if (error > 0) {
            logger.info("errors found: " + error);
            return false;
        }
        return true;
    }

    /*CREATE*/
    public String doCreateRoute() throws NotFoundException {
        String vResult = ActionSupport.INPUT;
        if (spot != null) {
            logger.info("spot received");
        }

        initGradeList();
        logger.info("init grade list");
        initHeightList();
        logger.info("init height list");
        if (route != null) {
            spot = spotManager.getSpotById(route.getSpot().getId());
            id = route.getSpot().getId();
            logger.info("route received: " + route);
            if (checkRouteForm(route)!=false) {
                logger.info("trying to add route: " + route);
                routeManager.addRoute(route);
                return ActionSupport.SUCCESS;
            }
        } else {
            logger.info("route is null");
            spot = spotManager.getSpotById(id);
        }
        return vResult;
    }

    /*READ ALL*/
    public String doList() throws NotFoundException {
        routeList = routeManager.getListRoute();
        logger.info("tried to get the route liste");
        return ActionSupport.SUCCESS;
    }


    /*READ ONE*/
    public String doDetail() throws NotFoundException {
        String vResult = ActionSupport.SUCCESS;
        try {
            route = routeManager.getRouteById(id);
            logger.info(route);
            logger.info("Number of comments: "+route.getCommentList().size());
        } catch (NotFoundException e) {
            logger.error("Route not found: " + e.getMessage());
        }
        if (this.hasErrors()) {
            vResult = ActionSupport.ERROR;
        }
        return vResult;
    }


    /*DELETE*/
    public String doDelete() throws NotFoundException {
        if (route != null) {
            routeManager.deleteRoute(route);
        } else {
            logger.info("no route received");
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
