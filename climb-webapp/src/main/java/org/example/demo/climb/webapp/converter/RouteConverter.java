package org.example.demo.climb.webapp.converter;

import com.opensymphony.xwork2.conversion.TypeConversionException;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.util.StrutsTypeConverter;
import org.example.demo.climb.business.contract.RouteManager;
import org.example.demo.climb.model.bean.Route;
import org.example.demo.climb.model.exception.NotFoundException;

import javax.inject.Inject;
import java.util.Map;

public class RouteConverter extends StrutsTypeConverter {

    @Inject
    RouteManager routeManager;
    @Override
    public Object convertFromString(Map pContext, String[] pValues, Class pToClass) {
        Object vRetour = null;
        System.out.println("trying to convert: "+pValues[0]);
        if (pValues != null) {
            if (pValues.length == 1) {
                String vValue = pValues[0];
                try {
                    vRetour = StringUtils.isEmpty(vValue) ? null : routeManager.getRouteById(Integer.parseInt(vValue));
                    System.out.println(vRetour);
                } catch (NumberFormatException pEx) {
                    throw new TypeConversionException("Issue while trying to convert", pEx);
                } catch (NotFoundException e) {
                    System.err.println("id not found in converter: "+vValue);
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
        if (pObject instanceof Route) {
            Route vFraction = (Route) pObject;
            Route route = (Route) pObject;
            vString=route.getName();
        } else {
            vString = "";
        }
        return vString;
    }
}
