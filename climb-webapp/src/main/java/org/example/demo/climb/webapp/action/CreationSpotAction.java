package org.example.demo.climb.webapp.action;


import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.example.demo.climb.business.contract.CountryManager;
import org.example.demo.climb.business.contract.SpotManager;
import org.example.demo.climb.model.bean.Country;
import org.example.demo.climb.model.bean.Route;
import org.example.demo.climb.model.bean.Spot;
import org.example.demo.climb.model.exception.NotFoundException;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class CreationSpotAction extends LoginAction implements SessionAware {

    private List<String> continentList=new ArrayList<>();
    private List<String> countryList=new ArrayList<>();
    private List<String> cityList=new ArrayList<>();
    private List<Spot> spotList = new ArrayList<>();
    private List<Route> routeList = new ArrayList<>();
    private String continent="";
    private String country="";
    private String city="";
    private Spot spot;
    private Country c;
    private int id;
    private final String token= "AlcwuVaVbdcepPJ0gbZ0Nd5prdkYHYS1LEEFEbUm2l0CfEe4XLUeDArvlkrXHcg2";



    private Spot[] spotArray ;

    @Inject
    private CountryManager countryManager;
    @Inject
    private SpotManager spotManager;

    // Methodes

    public String doIndex() throws NotFoundException {
        String vResult= ActionSupport.SUCCESS;

        /*continentList=countryManager.getListContinent();*/
        spotList = spotManager.getListSpot();
        System.out.println("size spotList: "+spotList.size());
        return vResult;
    }

    public String doListContinent() throws NotFoundException {
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
            /*System.out.println("setting up c: " + c.getName());*/
        }
        cityList = spotManager.getListCityByCountry(c);
        return vResult;
    }
    public String doList() throws  NotFoundException{

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
                spotList = spotManager.getListSpot(c.getContinent(), c.getName(), city);
            }

        }
        // Init list of countries for the selected continent
        countryList = countryManager.getListCountryByContinent(continent);

        return ActionSupport.SUCCESS;
    }
    public String doCreateSpot() throws NotFoundException {
        String vResult= ActionSupport.INPUT;
        c = countryManager.getCountry(id);
        System.out.println("city is here: "+city);
        if(spot!=null){
            spotManager.addSpot(spot);
            vResult = ActionSupport.SUCCESS;
        }
        return vResult;
    }

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

    }

    public String doTestHtml(){
        String vResult = ActionSupport.SUCCESS;
        /*String name="Roger";*/
        return vResult;
    }
    // Getters and Setters
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
    public List<String> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<String> countryList) {
        this.countryList = countryList;
    }

    public List<String> getCityList() {
        return cityList;
    }

    public void setCityList(List<String> cityList) {
        this.cityList = cityList;
    }

    public List<String> getContinentList() {
        return continentList;
    }

    public void setContinentList(List<String> continentList) {
        this.continentList = continentList;
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

    public Spot[] getSpotArray() {
        return spotArray;
    }

    public void setSpotArray(Spot[] spotArray) {
        this.spotArray = spotArray;
    }
}
