package org.example.demo.climb.webapp.action;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;
import org.example.demo.climb.business.contract.CommentManager;
import org.example.demo.climb.business.contract.CountryManager;
import org.example.demo.climb.business.contract.SpotManager;
import org.example.demo.climb.model.ClimbingType;
import org.example.demo.climb.model.Grade;
import org.example.demo.climb.model.bean.Country;
import org.example.demo.climb.model.bean.Route;
import org.example.demo.climb.model.bean.Spot;
import org.example.demo.climb.model.bean.Topo;
import org.example.demo.climb.model.exception.NotFoundException;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CreationSpotAction extends LoginAction implements SessionAware {

    private final String token = "AlcwuVaVbdcepPJ0gbZ0Nd5prdkYHYS1LEEFEbUm2l0CfEe4XLUeDArvlkrXHcg2 ";
    public List<String> climbingList = new ArrayList<>();
    private Logger logger = Logger.getLogger(this.getClass().getName());
    private List<String> cityList = new ArrayList<>();
    private List<Spot> spotList = new ArrayList<>();
    private List<Topo> topoList = new ArrayList<>();
    private List<Route> routeList = new ArrayList<>();
    private String continent = "";
    private String country = "";
    private String city = "";
    private Spot spot;
    private Country c;
    private int id;
    private String str = "";
    private String climbingType = "";
    private List<String> typeList = new ArrayList<>();
    private String hasTopo;
    private double latitude;
    private double longitude;
    private JsonArray listo = new JsonArray();
    private String[][] spotArray;
    private HashMap<Integer, String> levelList = new HashMap<>();
    private HashMap<Integer, String> countryList = new HashMap<>();
    private String levelMin="";
    private String levelMax="";
    private boolean submit = false;
    private HashMap<Integer, String> gradeList = new HashMap<>();
    @Inject
    private CountryManager countryManager;
    @Inject
    private SpotManager spotManager;
    @Inject
    private CommentManager commentManager;

    public JsonArray getListo() {
        return listo;
    }

    public void setListo(JsonArray listo) {
        this.listo = listo;
    }

    // METHODS

    public String doIndex() throws NotFoundException {
        initClimbingTypeList();
        int index = 0;
        //adding default condition
        gradeList.put(index, "0");
        for (Grade g : Grade.values()) {
            index++;
            gradeList.put(index, g.getValue());
        }

        String vResult = ActionSupport.SUCCESS;
        logger.info("climbing list: " + climbingList);
        if (climbingType.equals("")) {
            climbingType = "ALL";
        }

        if(levelMin.equals("") && !levelMax.equals("")) {
            if (Grade.valueOf(levelMin).ordinal() > Grade.valueOf(levelMax).ordinal()) {
                this.addFieldError("levelMin", "Min Level should be lower than Max");
            }
        }
        if (str == null && climbingType == null && hasTopo == null && !this.hasActionErrors()) {
            spotList = spotManager.getListSpot();
        } else {
            logger.info("trying to get a list with keyword: " + str);
            logger.info("climbing type passed: " + climbingType);
            logger.info("has topo passed: " + hasTopo);
            spotList = spotManager.getListSpot(str, climbingType, hasTopo, levelMin, levelMax);
        }

        logger.info("level min: " + levelMin);
        logger.info("level max: " + levelMax);
        generateRouteListFromSpotList(spotList);
        generateTopoListFromSpotList(spotList);
        int i = 0;
        if (spotList != null) {
            for (Spot s : spotList
            ) {
                logger.info("logList contains: "+spotList.size()+" items");
                logger.info("first item list received: "+spotList.get(0));
                String lat = Double.toString(spotList.get(i).getLatitude());
                String lon = Double.toString(spotList.get(i).getLongitude());
                String name = spotList.get(i).getName();
                String desc = spotList.get(i).getCountry().getName();
                String type = spotList.get(i).getType();
                String city = spotList.get(i).getCity();
                int ref = spotList.get(i).getId();
                JsonObject obj = new JsonObject();
                obj.addProperty("ref", ref);
                obj.addProperty("lat", lat);
                obj.addProperty("lon", lon);
                obj.addProperty("title", name);
                obj.addProperty("description", desc);
                obj.addProperty("cType", type);
                obj.addProperty("city", city);
                logger.info("object created: "+obj);
                listo.add(obj);
                i++;
            }
            if (listo == null) {
                vResult = ActionSupport.ERROR;
            }
        }
        return vResult;
    }

    // generates routeList for map result table
    private void generateRouteListFromSpotList(List<Spot> spotList) {
        logger.info("generating routeList");
        routeList.clear();
        if(spotList!=null) {
            if (spotList.size() > 0) {
                for (Spot s : spotList) {
                    if (s.getRouteList().size() > 0) {
                        for (Route r : s.getRouteList()) {
                            routeList.add(r);
                        }
                    }
                }
            } else {
                logger.info("spotList empty");
            }
        }
    }

    // generates topoList for map result table
    private void generateTopoListFromSpotList(List<Spot> spotList) {
        logger.info("generating topoList");
        topoList.clear();
        if(spotList!=null) {
            if (spotList.size() > 0) {
                for (Spot s : spotList) {
                    if (s.getTopos().size() > 0) {
                        for (Topo t : s.getTopos()) {
                            topoList.add(t);
                        }
                    }
                }
            } else {
                logger.info("spotList empty");
            }
        }
    }


    /*CREATE*/
    public String doCreateSpot() throws NotFoundException {
        String vResult = ActionSupport.INPUT;
        initCountryList();
        initClimbingTypeList();
        logger.info("spot country id: " + spot);

        if (spot != null) {
            if (checkSpotForm(spot)) {
                spotManager.addSpot(spot);
                vResult = ActionSupport.SUCCESS;
            }
        }
        return vResult;
    }

    //Initiates the climbingType List
    private void initClimbingTypeList() {
        // adding condition for All
        climbingList.add("ALL");
        for (ClimbingType ct : ClimbingType.values()) {
            climbingList.add(ct.getName());
        }
    }


    //Check submitted form
    public boolean checkSpotForm(Spot spot) {
        int i = 0;
        // check Country
        if (countryManager.getCountry(spot.getCountry().getId()) == null) {
            this.addFieldError("spot.country.id", "invalid country passed");
            i++;
        }
        // check ClimbingType
        int found = 0;
        logger.info("climbing list: " + climbingList);
        for (String type : climbingList
        ) {
            if (type.equals(spot.getType())) {
                found = 1;
            }
        }
        if (found != 1) {
            this.addFieldError("spot.type", "Incorrect type");
            i++;
        }

        // Checks that coordinates aren't 0 / 0
        if (spot.getLatitude() == 0 && spot.getLongitude() == 0) {
            this.addFieldError("spot.latitude", "Underwater spot really?!!;)");
            this.addFieldError("spot.longitude", "You may want to recheck ");
            i++;
        }

        // Check Latitude
        try {
            Double.valueOf(spot.getLatitude());
        } catch (Exception e
        ) {
            this.addFieldError("spot.latitude", "Latitude must be a number");
            i++;
        }
        if (spot.getLatitude() < -90 || spot.getLatitude() > 90) {
            this.addFieldError("spot.latitude", "Latitude should be between -90 and 90");
            i++;
        }

        // Check Longitude
        try {
            Double.valueOf(spot.getLongitude());
        } catch (Exception e
        ) {
            this.addFieldError("spot.longitude", "Longitude must be a number");
            i++;
        }
        if (spot.getLongitude() < -180 || spot.getLongitude() > 180) {
            this.addFieldError("spot.longitude", "Longitude should be between -180 and 180");
            i++;
        }

        // check City
        if (spot.getCity() == null || spot.getCity().length() < 3 || spot.getCity().length() > 50) {
            this.addFieldError("spot.city", "City should have 3-50 characters ("
                    + spot.getCity().length() + ")");
            i++;
        }
        // check Name
        if (spot.getName() == null || spot.getName().length() < 3 || spot.getName().length() > 50) {
            this.addFieldError("spot.name", "Name should have 3-50 characters ("
                    + spot.getName().length() + ")");
            i++;
        }
        // check description
        if (spot.getDescription() == null || spot.getDescription().length() < 3 || spot.getDescription().length() > 250) {
            this.addFieldError("spot.description", "Description should have 3-250 characters ("
                    + spot.getDescription().length() + ")");
            i++;
        }
        if (i == 0) {
            return true;
        } else {
            return false;
        }
    }


    public String doList() {
        spotList = spotManager.getListSpot();
        logger.info("trying to get topoList");
        logger.info("size: " + spotList.size());
        return ActionSupport.SUCCESS;
    }

    private void initCountryList() {
        for (Country c : countryManager.getListCountry()
        ) {
            countryList.put(c.getId(), c.getName());
        }
    }


    /*READ ONE*/
    public String doDetail() throws NotFoundException {
        String vResult = ActionSupport.SUCCESS;
        logger.info("tentative de recuperation de l'id: " + id);
        spot = spotManager.getSpotById(id);
        logger.info(spot);
        routeList = spot.getRouteList();
        logger.info("size routeList: " + routeList.size());
        logger.info("size commentList: " + spot.getCommentList().size());
        if (this.hasErrors()) {
            vResult = ActionSupport.ERROR;
        }
        logger.info("vresult: " + vResult.toString());
        return vResult;
    }


    /*EDIT*/
    public String doEdit() {
        String vResult = ActionSupport.SUCCESS;
        logger.info("tentative de recuperation de l'id from doEdit: " + id);
        try {
            spot = spotManager.getSpotById(id);
            logger.info("doedit: " + id);
        } catch (NotFoundException e) {
            this.addActionError(e.toString());
        }
        if (this.hasErrors()) {
            vResult = ActionSupport.ERROR;
        }
        return vResult;
    }

    /*UPDATE*/
    public String doUpdate() {
        String vResult = ActionSupport.INPUT;
        initCountryList();
        for (ClimbingType ct : ClimbingType.values()) {
            climbingList.add(ct.getName());
        }
        logger.info("from action spot");
        if (submit) {
            if (spot != null) {
                if (checkSpotForm(spot)) {
                    spotManager.updateSpot(spot);
                    vResult = ActionSupport.SUCCESS;
                }

            } else {
                logger.info("spot is null");
            }
        }
        return vResult;

    }

    /*DELETE*/
    public String doDelete() {
        String vResult = ActionSupport.SUCCESS;
        logger.info("received: " + spot);

        if (spot != null) {
            logger.info("received: " + spot);
            spotManager.deleteSpot(spot);
        } else {
            this.addActionError("Issue while trying to delete, no Id found");
        }
        return vResult;

    }


    /***********************************************************************/
    /************************ GETTERS - SETTERS ***************************/
    public String getLevelMin() {
        return levelMin;
    }

    public void setLevelMin(String levelMin) {
        this.levelMin = levelMin;
    }

    public String getLevelMax() {
        return levelMax;
    }

    public void setLevelMax(String levelMax) {
        this.levelMax = levelMax;
    }

    /***********************************************************************/



    public List<String> getTypeList() {
        return typeList;
    }

    public void setTypeList(List<String> typeList) {
        this.typeList = typeList;
    }

    public HashMap<Integer, String> getLevelList() {
        return levelList;
    }

    public void setLevelList(HashMap<Integer, String> levelList) {
        this.levelList = levelList;
    }

    public List<Route> getRouteList() {
        return routeList;
    }

    public void setRouteList(List<Route> routeList) {
        this.routeList = routeList;
    }

    public List<Spot> getSpotList() {
        return spotList;
    }

    public void setSpotList(List<Spot> spotList) {
        this.spotList = spotList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Country getC() {
        return c;
    }

    public void setC(Country c) {
        this.c = c;
    }

    public Spot getSpot() {
        return spot;
    }

    public void setSpot(Spot spot) {
        this.spot = spot;
    }

    public HashMap<Integer, String> getGradeList() {
        return gradeList;
    }

    public List<String> getCityList() {
        return cityList;
    }

    public void setCityList(List<String> cityList) {
        this.cityList = cityList;
    }

    public HashMap<Integer, String> getCountryList() {
        return countryList;
    }

    public void setCountryList(HashMap<Integer, String> countryList) {
        this.countryList = countryList;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getToken() {
        return token;
    }

    public String[][] getSpotArray() {
        return spotArray;
    }

    public void setSpotArray(String[][] spotArray) {
        this.spotArray = spotArray;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
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

    public List<String> getClimbingList() {
        return climbingList;
    }

    public void setClimbingList(List<String> climbingList) {
        this.climbingList = climbingList;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public boolean isSubmit() {
        return submit;
    }

    public void setSubmit(boolean submit) {
        this.submit = submit;
    }

    public List<Topo> getTopoList() {
        return topoList;
    }

    public void setTopoList(List<Topo> topoList) {
        this.topoList = topoList;
    }
}
