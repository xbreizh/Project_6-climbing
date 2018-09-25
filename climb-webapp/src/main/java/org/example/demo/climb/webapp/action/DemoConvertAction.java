package org.example.demo.climb.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.math.Fraction;
import org.example.demo.climb.business.contract.manager.MemberManager;
import org.example.demo.climb.model.bean.Spot;
import org.example.demo.climb.model.bean.member.Member;

import javax.inject.Inject;
import java.util.List;

/**
 * Action de démo pour les StrutsTypeConverter
 */
public class DemoConvertAction extends ActionSupport {


    // ==================== Attributs ====================
    /*private Fraction fraction;*/


    private Member member;
    private Spot spot;
    private int id;

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

    private List<Member> listMember;
    private List<Spot> spotList;

    public List<Spot> getSpotList() {
        return spotList;
    }

    public void setSpotList(List<Spot> spotList) {
        this.spotList = spotList;
    }

    public void setListMember(List<Member> listMember) {
        this.listMember = listMember;
    }

    public List<Member> getMemberList() {
        return listMember;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
    // ==================== Getters/Setters ====================
   /* public Fraction getFraction() {
        return fraction;
    }
    public void setFraction(Fraction pFraction) {
        fraction = pFraction;
    }*/


    // ==================== Méthodes ====================

 /*   @Override*/
    public String memberConvert() throws Exception {
       if(member!=null){
           this.addActionMessage("Member is: "+member);
           System.out.println("Member is: "+member.getLogin());
       }else{
           this.addActionError("member couldn't be found ");
       }
        return ActionSupport.INPUT;
    }

    public String droptest() throws  Exception{
        return ActionSupport.INPUT;
    }

    public String droptest_result() throws  Exception{
        System.out.println("Member: :"+member.getLogin());
        System.out.println("Spot: "+spot.getName());
        return ActionSupport.SUCCESS;
    }
   /* @Override
    public String execute() throws Exception {
        if (this.fraction != null) {
            this.addActionMessage(String.format("La fraction est : %d sur %d",
                    this.fraction.getNumerator(),
                    this.fraction.getDenominator()));
        }

        return ActionSupport.INPUT;
    }*/
}