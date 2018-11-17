package org.example.demo.climb.webapp.action.__todelete;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.example.demo.climb.business.contract.CountryManager;
import org.example.demo.climb.business.contract.MemberManager;
import org.example.demo.climb.business.contract.SpotManager;
import org.example.demo.climb.model.bean.Country;
import org.example.demo.climb.model.bean.Spot;
import org.example.demo.climb.model.bean.Member;
import org.example.demo.climb.model.exception.NotFoundException;
import org.example.demo.climb.webapp.action.LoginAction;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class GestionSpotAction extends LoginAction implements SessionAware {
/*
    private Spot spot;
    private List<Spot> listSpot=new ArrayList<>();
    private List<String> continentList=new ArrayList<>();
    private List<String> countryList=new ArrayList<>();
    private List<String> cityList=new ArrayList<>();

    private Country c;
    private int id;
    private int memberId;
    private int countryId;
    private String continent="";
    private String country="";
    private String city="";
    private Member member;
    private boolean showNew=false;
    private String gpsCoordinates;



    public boolean isShowNew() {
        return showNew;
    }

    public void setShowNew(boolean showNew) {
        this.showNew = showNew;
    }

    @Inject
    private SpotManager spotManager;
    @Inject
    private MemberManager memberManager;
    @Inject
    private CountryManager countryManager;

    //Methods

    public String doCreate() throws NotFoundException {
        String vResult=ActionSupport.INPUT;
       *//* if (checkSession()) return ActionSupport.ERROR;
        if(c!=null) {
            System.out.println("country name from action: " + c.getName());
            cityList = spotManager.getListCityByCountry(c);
        }else{
            System.out.println("looks like c is null");
        }
        if(spot!=null) {
            if (checkSpotCreatorNotLegit()) return ActionSupport.ERROR;
            System.out.println(spot.getCountry().getId());
            spotManager.addSpot(spot);
            vResult=ActionSupport.SUCCESS;
        }
        if (this.hasErrors()) {
            vResult = ActionSupport.ERROR;
        }*//*
        return vResult;
    }

    private boolean checkSpotCreatorNotLegit() {
        *//*member = (Member) ServletActionContext.getRequest().getSession().getAttribute("user");
        System.out.println("Member id: "+member.getId());
        if(member.getId() != spot.getMemberSpot().getId()){
            System.out.println("member from spot: "+spot.getMemberSpot().getId());
            this.addActionError("Authentication issue, please log out, then try again. Member found: "+member.getId());
            return false;
        }*//*
        return true;
    }

    private boolean checkSession() {
        *//*if(getSession().isEmpty()) {
            System.err.println("Vous devez vous connecter pour cette action!");
            return true;
        }*//*
        return false;
    }


    public String doDetail() throws NotFoundException {
        String vResult = ActionSupport.SUCCESS;
        *//*System.out.println("Spot mgmt: " + spot);
        System.out.println("Id: " + id);*//*

       *//* spot = spotManager.getSpotById(9);
       *//**//* System.out.println("Spot from doDetail: " + spot);*//**//*

        if (this.hasErrors()) {
            vResult = ActionSupport.ERROR;
        }*//*
        return vResult;
    }

    public String doEdit() {
        String vResult = ActionSupport.SUCCESS;
       *//* try {
            spot = spotManager.getSpotById(id);
            System.out.println("doedit: " + id);
        } catch (NotFoundException e) {
            this.addActionError(e.toString());
        }
        if (this.hasErrors()) {
            vResult = ActionSupport.ERROR;
        }*//*
        return vResult;
    }

    public String doList() {
        System.out.println("test");
    *//*    *//**//*continentList=countryManager.getListContinent();*//**//*
        *//**//*System.out.println("continentList: "+continentList);*//**//*
        System.out.println("continent: continent");
        countryList=countryManager.getListCountryByContinent(continent);
        System.out.println("countryList: "+countryList);
        cityList = spotManager.getListCityByCountry(c);
        System.out.println("citylist: "+cityList);
        if(continent.equals("")){
            city=country="";
            countryList=countryManager.getListCountryStrings();
        }else {
            countryList = countryManager.getListCountryByContinent(continent);
           if(!country.equals("")){
               c=countryManager.getCountry(country);
               System.out.println("Country name: "+c.getName());
               getSession().put("country", c);
           }
        }
        listSpot = spotManager.getListSpot(continent, country, city);
        System.out.println("size: " + listSpot.size());
        return ActionSupport.SUCCESS;
    }

    public String selectSpotList(){
        continentList=countryManager.getListContinent();
        countryList=countryManager.getListCountryByContinent(continent);
        *//**//*cityList=countryManager.getListCityByCountry(country);*//*
        return ActionSupport.SUCCESS;
    }
*//*    public String doList() {
        countryList=countryManager.getListCountry();
        System.out.println("spot");
        listSpot = spotManager.getListSpotByCity("ssss");
        System.out.println("size: " + listSpot.size());
        return ActionSupport.SUCCESS;
    }*//*


*//*    public String doUpdate() {
        String vResult = ActionSupport.INPUT;

        if (this.spot != null) {
            spotManager.updateSpot(spot);
            vResult = ActionSupport.SUCCESS;
            System.out.println("Spot: " + spot);

        }
        if (this.hasErrors()) {
            System.out.println("Spot is null");
            vResult = ActionSupport.ERROR;
        }
        return vResult;
    }*//*

    *//*public String doDelete() {
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

    }*//*

    // Getters & Setters
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Country getC() {
        return c;
    }

    public void setC(Country c) {
        this.c = c;
    }
    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }
    public String getGpsCoordinates() {
        return gpsCoordinates;
    }

    public void setGpsCoordinates(String gpsCoordinates) {
        this.gpsCoordinates = gpsCoordinates;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<String> getContinentList() {
        return continentList;
    }

    public void setContinentList(List<String> continentList) {
        this.continentList = continentList;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        System.out.println("trying to get id");
        this.id = id;
    }

    public Spot getSpot() {
        return spot;
    }

    public void setSpot(Spot spot) {
        System.out.println("trying to modify spot");
        this.spot = spot;
    }

    public List<Spot> getListSpot() {
        return listSpot;
    }

    public void setListSpot(List<Spot> listSpot) {
        this.listSpot = listSpot;
    }*/

}
