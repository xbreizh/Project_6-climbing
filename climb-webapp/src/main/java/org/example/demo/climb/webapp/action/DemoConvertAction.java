package org.example.demo.climb.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.math.Fraction;

/**
 * Action de démo pour les StrutsTypeConverter
 */
public class DemoConvertAction extends ActionSupport {


    // ==================== Attributs ====================
    private Fraction fraction;


    // ==================== Getters/Setters ====================
    public Fraction getFraction() {
        return fraction;
    }
    public void setFraction(Fraction pFraction) {
        fraction = pFraction;
    }


    // ==================== Méthodes ====================
    @Override
    public String execute() throws Exception {
        if (this.fraction != null) {
            this.addActionMessage(String.format("La fraction est : %d sur %d",
                    this.fraction.getNumerator(),
                    this.fraction.getDenominator()));
        }

        return ActionSupport.INPUT;
    }
}