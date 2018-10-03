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

    @Inject
    private ZoneManager zoneManager;


    private List<Spot> spotList;
    private List<Zone> zoneList;
    private List<String> continentList;

    private List<String> countryList;

    private List<String> regionList;

    private Zone zone;
    private String continent;
    private String country;
    private String region;
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


    public void setContinentList(List<String> continentList) {
        this.continentList = continentList;
    }

    public DemoAjaxAction(){

    }

    public String execute() {
       /* continentList = zoneManager.getListContinent();
        if(continent!=null && !continent.equals("-1")){
            countryList=zoneManager.getListCountry(continent);
            if(country!=null && !country.equals("-1")){
                regionList=zoneManager.getListRegion(country);
            }
        }else{
            country = null;
            region = null;
        }*/
        return ActionSupport.SUCCESS;
    }


    public String display() {

        return NONE;
    }


}
