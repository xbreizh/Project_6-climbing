package org.example.demo.climb.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.math.Fraction;
import org.example.demo.climb.model.bean.member.Member;

/**
 * Action de démo pour les StrutsTypeConverter
 */
public class DemoConvertAction extends ActionSupport {


    // ==================== Attributs ====================
    /*private Fraction fraction;*/

    private Member id;
    public Member getId() {
        return id;
    }

    public void setId(Member id) {
        this.id = id;
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
       if(id!=null){
           this.addActionMessage("Member is: "+id);
       }else{
           this.addActionError("member couldn't be found ");
       }
        return ActionSupport.INPUT;
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