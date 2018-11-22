package org.example.demo.climb.webapp.action;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.example.demo.climb.business.contract.CommentManager;
import org.example.demo.climb.business.contract.CountryManager;
import org.example.demo.climb.business.contract.SpotManager;
import org.example.demo.climb.model.ClimbingType;
import org.example.demo.climb.model.Grade;
import org.example.demo.climb.model.bean.Country;
import org.example.demo.climb.model.bean.Route;
import org.example.demo.climb.model.bean.Spot;
import org.example.demo.climb.model.exception.NotFoundException;
import org.hibernate.annotations.Check;

import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CreationSpotAction extends LoginAction implements SessionAware {

    /*private List<String> continentList=new ArrayList<>();*/
   /* private List<String> countryList=new ArrayList<>();*/
    private List<String> cityList=new ArrayList<>();
    private List<Spot> spotList = new ArrayList<>();
    private List<Route> routeList = new ArrayList<>();
    private String continent="";
    private String country="";
    private String city="";
    private Spot spot;
    private Country c;
    private int id;
    private String str="";
    private String climbingType="";
    private List<String> typeList=new ArrayList<>();
    private String hasTopo;
    public List<String> climbingList = new ArrayList<>();
    private double latitude;
    private double longitude;
    private final String token= "AlcwuVaVbdcepPJ0gbZ0Nd5prdkYHYS1LEEFEbUm2l0CfEe4XLUeDArvlkrXHcg2";
    public JsonArray getListo() {
        return listo;
    }
    public void setListo(JsonArray listo) {
        this.listo = listo;
    }
    private JsonArray listo = new JsonArray();
    private String[][] spotArray ;
    private HashMap<Integer, String> levelList= new HashMap<>();
    private HashMap<Integer, String> countryList= new HashMap<>();
    private int levelMin;
    private int levelMax;

    @Inject
    private CountryManager countryManager;
    @Inject
    private SpotManager spotManager;
    @Inject
    private CommentManager commentManager;

    // METHODS

    public String doIndex() throws NotFoundException {
        initClimbingTypeList();
       /* try {
            System.out.println(System.getProperty("user.dir"));
            Icon green = new ImageIcon(ImageIO.read( CreationSpotAction.class.getResourceAsStream( "climb-webapp/src/main/webapp/img/green_pin.jpg" ) ) );
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }*/


        initLevelList();

        String vResult= ActionSupport.SUCCESS;
        System.out.println("climbing list: "+climbingList);
        if(climbingType.equals("")){climbingType="ALL";}
        if(levelMin > levelMax){
            this.addFieldError("levelMin", "Min Level should be lower than Max");
        }
        if(str==null && climbingType==null && hasTopo == null && !this.hasActionErrors()) {
            spotList = spotManager.getListSpot();
        }else{
            System.out.println("trying to get a list with keyword: "+str);
            System.out.println("climbing type passed: "+climbingType);
            System.out.println("has topo passed: "+hasTopo);
            spotList = spotManager.getListSpot(str, climbingType, hasTopo, levelMin, levelMax);
        }
        System.out.println("level min: "+levelMin);
        System.out.println("level max: "+levelMax);
        /*System.out.println("spotList size: "+spotList.size());*/
        int i=0;
        if(spotList!=null) {
            for (Spot s : spotList
            ) {
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
                listo.add(obj);
                i++;
            }
            if (listo == null) {
                vResult = ActionSupport.ERROR;
            }
        }
        return vResult;
    }

    private void initClimbingTypeList() {
        climbingList.add("ALL");
        for(ClimbingType ct: ClimbingType.values()){
            climbingList.add(ct.getName());
        }
        // adding condition for All
    }

    private void initLevelList() {
        int index=0;
        //adding default condition
        levelList.put(index, "0");
        for(Grade g: Grade.values()){
            index++;
            levelList.put(index,g.getValue());
        }

    }


    /*CREATE*/
    public String doCreateSpot() throws NotFoundException {
        String vResult= ActionSupport.INPUT;
        initCountryList();
        System.out.println("spot country id: "+spot);
        for(ClimbingType ct: ClimbingType.values()){
            climbingList.add(ct.getName());
        }
        /*c = countryManager.getCountry(id);
        System.out.println("city is here: "+city);*/
        if(spot!=null) {
            if (checkSpotForm(spot)){
                spotManager.addSpot(spot);
                vResult = ActionSupport.SUCCESS;
            }else{
                System.out.println("spot not validated! ");
            }
        }
        return vResult;
    }

    //Check submitted form
    public boolean checkSpotForm(Spot spot){
        int i=0;
        // check Country
        if(countryManager.getCountry(spot.getCountry().getId())==null){
            this.addFieldError("spot.country.id", "invalid country passed");
            i++;
        }
        // check ClimbingType
        int found=0;
        for (ClimbingType ct:ClimbingType.values()
             ) {
            if(ct.getName().equals(spot.getType())){
                found=1;
            }
        }
        if(found!=1){
            this.addFieldError("spot.type", "Incorrect type");
            i++;
        }

        // Checks that coordinates aren't 0 / 0
        if(spot.getLatitude()==0 && spot.getLongitude()==0){
            this.addFieldError("spot.latitude", "Underwater spot really?!!;)");
            this.addFieldError("spot.longitude", "You may want to recheck ");
            i++;
        }

        // Check Latitude
        try{Double.valueOf(spot.getLatitude());}catch(Exception e
        ){
            this.addFieldError("spot.latitude", "Latitude must be a number");
            i++;
        }
        if(spot.getLongitude() < -90 || spot.getLatitude() > 90){
            this.addFieldError("spot.latitude", "Latitude should be between -90 and 90");
            i++;
        }

        // Check Longitude
        try{Double.valueOf(spot.getLongitude());}catch(Exception e
        ){
            this.addFieldError("spot.longitude", "Longitude must be a number");
            i++;
        }
        if(spot.getLongitude() < -90 || spot.getLongitude() > 90){
            this.addFieldError("spot.longitude", "Longitude should be between -90 and 90");
            i++;
        }



        // check City
        if (spot.getCity() == null || spot.getCity().length() < 3 || spot.getCity().length() > 50) {
            this.addFieldError("spot.city", "City should have 3-50 characters");
            i++;
        }
        // check Name
        if (spot.getName() == null || spot.getName().length() < 3 || spot.getName().length() > 50) {
            this.addFieldError("spot.name", "Name should have 3-50 characters");
            i++;
        }
        // check description
        if (spot.getDescription()== null || spot.getDescription().length() < 5 || spot.getDescription().length() > 250) {
            this.addFieldError("spot.description", "Description should have 3-50 characters");
            i++;
        }
        if(i==0){return true;}else{
            return false;
        }
    }

    /*READ ALL SPOTS*/
/*    public String doList() throws  NotFoundException{

        if(country.equals("")){
            // Getting list of spots for that continent
            spotList = spotManager.getListSpotByContinent(continent);
        }else{
            c = countryManager.getCountry(country);
            // Init cityList
            cityList = spotManager.getListCityByCountry(c);
            if(city.equals("")){
                // Getting list of spots for that country
                spotList = spotManager.getListSpotByCountry(c);
            }else{
               *//* spotList = spotManager.getListSpot(c.getContinent(), c.getName(), city);*//*
            }

        }
        // Init list of countries for the selected continent
        initCountryList();
        *//*countryList = countryManager.getListCountry();*//*

        return ActionSupport.SUCCESS;
    }*/

    public String doList() {
        spotList=spotManager.getListSpot();
        System.out.println("trying to get topoList");
        System.out.println("size: " + spotList.size());
        return ActionSupport.SUCCESS;
    }

    private void initCountryList() {
        for (Country c: countryManager.getListCountry()
             ) {
            countryList.put(c.getId(), c.getName());
        }
    }



    /*READ ALL CONTINENTS*/
    /*public String doListContinent() throws NotFoundException {
        String vResult= ActionSupport.SUCCESS;

        continentList=countryManager.getListContinent();
        return vResult;
    }*/

    /*READ ALL COUNTRIES*/
   /* public String doListCountry() throws NotFoundException {
        String vResult= ActionSupport.SUCCESS;
        System.out.println("checking country");
        System.out.println("id: "+id);
        if(id!=0){
            continent = countryManager.getCountry(id).getContinent();
        }
        System.out.println("continent: "+continent);
        countryList = countryManager.getListCountry();
        return vResult;
    }*/

    /*READ ALL CITIES*/
    /*public String doListCity() throws NotFoundException {
        String vResult= ActionSupport.SUCCESS;
        if(id!=0) {
            System.out.println("c is null!");
            c=countryManager.getCountry(id);
        }else {
            c = countryManager.getCountry(country);
            *//*System.out.println("setting up c: " + c.getName());*//*
        }
        cityList = spotManager.getListCityByCountry(c);
        return vResult;
    }*/

    /*READ ONE*/
    public String doDetail() throws NotFoundException {
        String vResult = ActionSupport.SUCCESS;
        System.out.println("tentative de recuperation de l'id: "+id);
        spot = spotManager.getSpotById(id);
        /*System.out.println(spot);*/
        routeList = spot.getRouteList();
        System.out.println("size routeList: "+routeList.size());
        if (this.hasErrors()) {
            vResult = ActionSupport.ERROR;
        }
        System.out.println("vresult: "+vResult.toString());
        return vResult;
    }

   /* public String doTest(){
        System.out.println("test ok");
        return ActionSupport.SUCCESS;
    }
*/
    /*EDIT*/
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
    /*UPDATE*/
    public String doUpdate() {
        String vResult = ActionSupport.INPUT;

        if (spot != null) {
            System.out.println("id de spot: "+spot.getId());
            System.out.println("latitude: "+spot.getLatitude());
            System.out.println("latitude: "+spot.getLongitude());
            spotManager.updateSpot(spot);
            vResult = ActionSupport.SUCCESS;
            System.out.println("Spot: " + spot);

        }else{
            System.out.println("spot is null");
        }
        if (this.hasErrors()) {
            System.out.println("Spot is null");
            vResult = ActionSupport.ERROR;
        }
        return vResult;
    }

    /*DELETE*/
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

    }

   /* public String doTestHtml(){
        String vResult = ActionSupport.SUCCESS;
        *//*String name="Roger";*//*
        return vResult;
    }*/
    // Getters and Setters

    public int getLevelMin() {
        return levelMin;
    }

    public void setLevelMin(int levelMin) {
        this.levelMin = levelMin;
    }

    public int getLevelMax() {
        return levelMax;
    }

    public void setLevelMax(int levelMax) {
        this.levelMax = levelMax;
    }
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
}
