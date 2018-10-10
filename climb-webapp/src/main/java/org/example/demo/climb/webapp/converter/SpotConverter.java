package org.example.demo.climb.webapp.converter;

import com.opensymphony.xwork2.conversion.TypeConversionException;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.util.StrutsTypeConverter;
import org.example.demo.climb.business.contract.manager.SpotManager;
import org.example.demo.climb.model.bean.Spot;
import org.example.demo.climb.model.exception.NotFoundException;

import javax.inject.Inject;
import java.util.Map;

public class SpotConverter extends StrutsTypeConverter {

    @Inject
    SpotManager spotManager;
    @Override
    public Object convertFromString(Map pContext, String[] pValues, Class pToClass) {
        Object vRetour = null;
        System.out.println("trying to convert: "+pValues[0]);
        if (pValues != null) {
            if (pValues.length == 1) {
                String vValue = pValues[0];
                try {
                    vRetour = StringUtils.isEmpty(vValue) ? null : spotManager.getSpotById(Integer.parseInt(vValue));
                    System.out.println(vRetour);
                } catch (NumberFormatException pEx) {
                    throw new TypeConversionException("Format de fraction invalide", pEx);
                } catch (NotFoundException e) {
                    System.err.println("spot not found in converter");
                }
            } else {
                vRetour = performFallbackConversion(pContext, pValues, pToClass);
            }
        }

        return vRetour;
    }


    @Override
    public String convertToString(Map pContext, Object pObject) {
        System.out.println("trying to convert into string");
        String vString;
        if (pObject instanceof Spot) {
            Spot vFraction = (Spot) pObject;
            Spot spot = (Spot) pObject;
           /* vString = String.format("%d/%d",
                    vFraction.getNumerator(),
                    vFraction.getDenominator());*/
            vString=spot.getName();
        } else {
            vString = "";
        }
        return vString;
    }
}
