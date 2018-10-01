package org.example.demo.climb.webapp.action;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

import com.opensymphony.xwork2.ActionSupport;

import org.example.demo.climb.business.contract.manager.MemberManager;
import org.example.demo.climb.business.contract.manager.SpotManager;
import org.example.demo.climb.model.bean.Spot;
import org.example.demo.climb.model.bean.Zone;
import org.example.demo.climb.model.bean.member.Member;
import org.example.demo.climb.model.exception.NotFoundException;


/**
 * Action de démo pour les appels AJAX
 */
public class DemoAjaxAction extends ActionSupport{

    private List<String> fruits;
    @Inject
    private MemberManager memberManager;

    public void setListMember(List<Member> listMember) {
        this.listMember = listMember;
    }

    private List<Member> listMember;
    private List<Spot> spotList;
    private Member member;
    private Spot spot;
    private String yourFruits;
    private String yourMonth;

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

    public String execute() {
        System.out.println("trying to get member lists");
        listMember = memberManager.getListMember();
        System.out.println("got the members list");
        /*System.out.println("Liste: "+member.getSpotList());*/
        if(member==null) {
            member = listMember.get(0);
        }
        /*spotList = member.getSpotList();*/
        return SUCCESS;
    }

    public String display() {
        return NONE;
    }

}
