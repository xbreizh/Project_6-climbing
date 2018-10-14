package org.example.demo.climb.webapp.converter;

import com.opensymphony.xwork2.conversion.TypeConversionException;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.util.StrutsTypeConverter;
import org.example.demo.climb.business.contract.CountryManager;
import org.example.demo.climb.model.bean.Country;

import javax.inject.Inject;
import java.util.Map;

public class CountryConverter extends StrutsTypeConverter {

    @Inject
    CountryManager countryManager;
    @Override
    public Object convertFromString(Map pContext, String[] pValues, Class pToClass) {
        Object vRetour = null;
        System.out.println("trying to convert: "+pValues[0]);
        if (pValues != null) {
            if (pValues.length == 1) {
                String vValue = pValues[0];
                try {
                    vRetour = StringUtils.isEmpty(vValue) ? null : countryManager.getCountry(Integer.parseInt(vValue));
                    System.out.println(vRetour);
                } catch (NumberFormatException pEx) {
                    throw new TypeConversionException("Format de fraction invalide", pEx);
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
        if (pObject instanceof Country) {
            Country vFraction = (Country) pObject;
            Country country = (Country) pObject;
           /* vString = String.format("%d/%d",
                    vFraction.getNumerator(),
                    vFraction.getDenominator());*/
            vString=country.getName();
        } else {
            vString = "";
        }
        return vString;
    }
}
