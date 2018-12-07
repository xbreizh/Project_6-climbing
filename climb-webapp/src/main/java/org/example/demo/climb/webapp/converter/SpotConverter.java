package org.example.demo.climb.webapp.converter;

import com.opensymphony.xwork2.conversion.TypeConversionException;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.util.StrutsTypeConverter;
import org.example.demo.climb.business.contract.SpotManager;
import org.example.demo.climb.model.bean.Spot;
import org.example.demo.climb.model.exception.NotFoundException;

import javax.inject.Inject;
import java.util.Map;

public class SpotConverter extends StrutsTypeConverter {
    private Logger logger = Logger.getLogger(this.getClass().getName());
    @Inject
    SpotManager spotManager;
    @Override
    public Object convertFromString(Map pContext, String[] pValues, Class pToClass) {
        Object vRetour = null;
        logger.debug("trying to convert: "+pValues[0]);
        if (pValues != null) {
            if (pValues.length == 1) {
                String vValue = pValues[0];
                try {
                    vRetour = StringUtils.isEmpty(vValue) ? null : spotManager.getSpotById(Integer.parseInt(vValue));
                    System.out.println(vRetour);
                } catch (NumberFormatException pEx) {
                    logger.error("Format de fraction invalide", pEx);
                } catch (NotFoundException e) {
                    logger.error("spot not found in converter");
                }
            } else {
                vRetour = performFallbackConversion(pContext, pValues, pToClass);
                logger.debug(vRetour.toString());
            }
        }

        return vRetour;
    }


    @Override
    public String convertToString(Map pContext, Object pObject) {
        logger.debug("trying to convert into string");
        String vString;
        if (pObject instanceof Spot) {
            Spot vFraction = (Spot) pObject;
            Spot spot = (Spot) pObject;
            vString=spot.getName();
        } else {
            vString = "";
        }
        return vString;
    }
}
