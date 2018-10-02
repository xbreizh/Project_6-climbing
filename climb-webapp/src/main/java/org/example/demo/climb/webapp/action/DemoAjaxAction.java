package org.example.demo.climb.webapp.action;

import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.ServletActionContext;
import org.example.demo.climb.business.contract.manager.MemberManager;
import org.example.demo.climb.business.contract.manager.ZoneManager;
import org.example.demo.climb.model.bean.Spot;
import org.example.demo.climb.model.bean.zone.Zone;
import org.example.demo.climb.model.bean.member.Member;


/**
 * Action de démo pour les appels AJAX
 */
public class DemoAjaxAction extends ActionSupport{

    private List<String> fruits;
    @Inject
    private MemberManager memberManager;
    @Inject
    private ZoneManager zoneManager;

    private List<Member> listMember;

    private List<Spot> spotList;
    private List<Zone> zoneList;
    private List<String> continentList;

    private List<String> countryList;

    private List<String> regionList;

    private Zone zone;
    private String continent;
    private String country;
    private String region;
    private Member member;
    private Spot spot;
    private String yourFruits;
    private String yourMonth;
    public List<String> getContinentList() {
        return continentList;
    }

    public void setCountryList(List<String> countryList) {
        this.countryList = countryList;
    }

    public List<String> getCountryList() {
        return countryList;
    }

    public List<String> getRegionList() {
        return regionList;
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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public List<Zone> getZoneList() {
        return zoneList;
    }

    public void setZoneList(List<Zone> zoneList) {
        this.zoneList = zoneList;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }



    public void setListMember(List<Member> listMember) {
        this.listMember = listMember;
    }

    public List<Member> getListMember() {
        return listMember;
    }
    public List<Spot> getSpotList() {
        return spotList;
    }

    public Member getMember() {
        return member;
    }

    public Spot getSpot() {
        return spot;
    }

    public void setSpot(Spot spot) {
        this.spot = spot;
    }
    public void setMember(Member member) {
        this.member = member;
    }

    public String getYourMonth() {
        return yourMonth;
    }

    public void setYourMonth(String yourMonth) {
        this.yourMonth = yourMonth;
    }

    public List<String> getFruits() {
        return fruits;
    }

    public void setFruits(List<String> fruits) {
        this.fruits = fruits;
    }

    public String getYourFruits() {
        return yourFruits;
    }

    public void setYourFruits(String yourFruits) {
        this.yourFruits = yourFruits;
    }

    public DemoAjaxAction(){

       /* fruits = new ArrayList<String>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Watermelon");*/
       /*listMember=memberManager.getListMember();*/

        System.out.println("bam l'action!");
    }

    public void setContinentList(List<String> continentList) {
        this.continentList = continentList;
    }

    public String execute() {
        /*System.out.println("trying to get zone lists");
        continentList=zoneManager.getListContinent();*/
        continentList=zoneManager.getListContinent();
        countryList=zoneManager.getListCountry("Europe");/*
        System.out.println("got the zone list");
        *//*System.out.println("Liste: "+member.getSpotList());*//*
       *//* if(zone==null) {
            zone = zoneList.get(0);
        }*//*
        *//*spotList = member.getSpotList();*//*
        System.out.println("liste of continents: "+zoneManager.getListContinent());
        HttpServletRequest request = (HttpServletRequest)(ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST));
        continent = request.getParameter("continent");
        System.out.println("Continent selected: "+continent);
        System.out.println("liste de pays d'Afrique: "+zoneManager.getListCountry("Africa"));
        System.out.println("liste de region en France: "+zoneManager.getListRegion( "France"));*/
        return SUCCESS;
    }


    public String DoAjaxGetListCountry(){
        countryList=zoneManager.getListCountry("Europe");
        return ActionSupport.SUCCESS;
    }
    public String display() {

        /*System.out.println("je display un truc");*/
        return NONE;
    }

    public String DoAjaxGetListContinent() throws Exception {
        continentList=zoneManager.getListContinent();
        return ActionSupport.SUCCESS;
    }
}
