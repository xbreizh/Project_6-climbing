package org.example.demo.climb.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.example.demo.climb.business.contract.manager.CountryManager;
import org.example.demo.climb.business.contract.manager.MemberManager;
import org.example.demo.climb.business.contract.manager.SpotManager;
import org.example.demo.climb.model.bean.Spot;
import org.example.demo.climb.model.bean.Member;
import org.example.demo.climb.model.exception.NotFoundException;

import javax.inject.Inject;
import java.util.List;

public class GestionSpotAction extends LoginAction {

    private Spot spot;
    private List<Spot> listSpot;
    private List<String> continentList;
    private List<String> countryList;
    private List<String> regionList;
    /*private Zone zone;*/

    private String continent="";
    private String country="";
    private String region="";
    private String name="";
    /*private int nb_ways;*/


    private int id;
    private Member member;

    @Inject
    private SpotManager spotManager;
    @Inject
    private MemberManager memberManager;
    /*@Inject
    private ZoneManager zoneManager;*/
    @Inject
    private CountryManager countryManager;

    // Getters & Setters
    /*public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }*/
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

    public List<String> getRegionList() {
        return regionList;
    }

    public void setRegionList(List<String> regionList) {
        this.regionList = regionList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Spot getSpot() {
        return spot;
    }

    public void setSpot(Spot spot) {
        this.spot = spot;
    }

    public List<Spot> getListSpot() {
        return listSpot;
    }

    public void setListSpot(List<Spot> listSpot) {
        this.listSpot = listSpot;
    }

    public String doCreate() throws NotFoundException {
        /*member = memberManager.getMember(1);*/
        System.out.println("got the member: "+member);
        String vResult = ActionSupport.INPUT;
        continentList = countryManager.getListContinent();
        // checks that a spot has been submitted
        if(this.spot!=null){
            continent=spot.getCountry().getContinent();
            country=spot.getCountry().getName();
            System.out.println("continent: "+continent);
            // checks that a continent has been selected and prepares the countryList
            if (!continent.equals("") && !continent.equals("-1")) {
                countryList = countryManager.getListCountryStrings();
                System.out.println(country=spot.getCountry().getName());
                // checks that a country has been submitted and prepares the regionList

                if(country!=null && !country.equals("-1")){
                    regionList=spotManager.getListRegionByCountry(spot.getCountry());
                    System.out.println(regionList);
                    region=spot.getRegion();
                     /// to be cleaned up
                    System.out.println("region: "+region);

                    if(region!=null && !region.equals("create new") && !region.equals("-1") && !region.equals("")){
                       name=spot.getName();
                       /*nb_ways=spot.getNb_ways();*/
                        if(!name.equals("")){
                            System.out.println("trying to add the spot: ");
                           /* spot.setCreatorSpot(member);*/
                            /*spot.setZone(zoneManager.getZone(region));*/
                            System.out.println("spot before adding: "+spot);
                            spotManager.addSpot(spot);
                            vResult = ActionSupport.SUCCESS;
                        }
                    }
                }
                /*country=spot.getZone().getCountry().getName();*/
               /* if(!country.equals("") && country.equals("-1")){
                    System.out.println("country: "+country);
                }*/
                // checks that a country has been submitted and prepares the regionList
               /* if (!country.equals("") && !country.equals("-1")){
                    country=spot.getZone().getCountry().getName();
                    System.out.println("Country: "+country);
                    regionList = zoneManager.getListRegion(spot.getZone().getCountry().getName());
                    *//*region=spot.getZone().getRegion();*//*
                }*/
                /*region=spot.getZone().getRegion();
                if(spot.getZone().getRegion()!=null){
                    System.out.println("region: "+spot.getZone().getRegion());
                    System.out.println("Country: "+spot.getZone().getCountry());
                    System.out.println(countryManager.getCountry(country));
                    spot.getZone().setCountry(countryManager.getCountry(country));
                    zoneManager.addZone(zone);
                    vResult = ActionSupport.SUCCESS;
                }*/
            }
        }
        if (this.hasErrors()) {
            vResult = ActionSupport.ERROR;
        }
        return vResult;
    }
/*    public String doCreate() throws NotFoundException {
        System.out.println("do create starting");
        Member m = (Member) getSession().get("user");
        System.out.println("User is: "+m);
        String vResult = ActionSupport.INPUT;
        System.out.println(spot);

       *//* s.setName("plouf");
        s.setNb_ways(2);
        s.setRouteList(new ArrayList<Route>());*//*
        if (this.spot != null) {
            try{
                spot.setZone(zoneManager.getZone(3));
                System.out.println("zone set");
                spot.setCreatorSpot(memberManager.getMember(1));
                System.out.println("creator set");
                *//*spot.setCreatorSpot(m);*//*
                System.out.println("setting the zone ");
                *//*spot.setZone(zoneManager.getZone(3));*//* // atlantide
                *//*System.out.println("trying to add spot: "+spot);*//*
                *//*spotManager.addSpot(spot);*//*
                vResult = ActionSupport.SUCCESS;
            }catch (Exception e){
                this.addActionError("Vous devez vous connecter pour cette action!");
            }
            *//*System.out.println("Action: " + spot);*//*
        }
        if (this.hasErrors()) {
            vResult = ActionSupport.ERROR;
        }
        return vResult;
    }*/

    public String doDetail() throws NotFoundException {
        String vResult = ActionSupport.SUCCESS;
        System.out.println("Spot mgmt: " + spot);
        System.out.println("Id: " + id);

        spot = spotManager.getSpotById(id);
        System.out.println("Member from doDetail: " + spot);

        if (this.hasErrors()) {
            vResult = ActionSupport.ERROR;
        }
        return vResult;
    }

    public String doEdit() {
        String vResult = ActionSupport.SUCCESS;
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

    public String doList(String continent, String country, String region) {
        System.out.println("spot");
        listSpot = spotManager.getListSpotByRegion(region);
        System.out.println("size: " + listSpot.size());
        return ActionSupport.SUCCESS;
    }
    public String doList() {
        System.out.println("spot");
        listSpot = spotManager.getListSpot();
        System.out.println("size: " + listSpot.size());
        return ActionSupport.SUCCESS;
    }

    public String doUpdate() {
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
    }

    public String doDelete() {
        String vResult = ActionSupport.SUCCESS;
        System.out.println("delete id: " + id);


        spotManager.deleteSpot(id);

        if (this.hasErrors()) {
            vResult = ActionSupport.ERROR;
        }
        return vResult;

    }

}
