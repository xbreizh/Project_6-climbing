package org.example.demo.climb.webapp.converter;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.util.StrutsTypeConverter;
import org.example.demo.climb.business.contract.CountryManager;
import org.example.demo.climb.model.bean.Country;

import javax.inject.Inject;
import java.util.Map;

public class CountryConverter extends StrutsTypeConverter {
    private Logger logger = Logger.getLogger(this.getClass().getName());
    @Inject
    CountryManager countryManager;
    @Override
    public Object convertFromString(Map pContext, String[] pValues, Class pToClass) {
        Object vRetour = null;
        logger.debug("trying to convert: "+pValues[0]);
        if (pValues != null) {
            if (pValues.length == 1) {
                String vValue = pValues[0];
                try {
                    vRetour = StringUtils.isEmpty(vValue) ? null : countryManager.getCountry(Integer.parseInt(vValue));

                } catch (NumberFormatException pEx) {
                    logger.error("Format de fraction invalide", pEx);
                    logger.debug(vRetour.toString());
                }
            } else {
                vRetour = performFallbackConversion(pContext, pValues, pToClass);
            }
        }

        return vRetour;
    }


    @Override
    public String convertToString(Map pContext, Object pObject) {
        logger.debug("trying to convert into string");
        String vString;
        if (pObject instanceof Country) {
            Country vFraction = (Country) pObject;
            Country country = (Country) pObject;
            vString=country.getName();
        } else {
            vString = "";
        }
        return vString;
    }
}
