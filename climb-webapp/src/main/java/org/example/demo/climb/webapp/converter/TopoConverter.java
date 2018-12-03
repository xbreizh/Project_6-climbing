package org.example.demo.climb.webapp.converter;

import com.opensymphony.xwork2.conversion.TypeConversionException;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.util.StrutsTypeConverter;
import org.example.demo.climb.business.contract.TopoManager;
import org.example.demo.climb.model.bean.Topo;
import org.example.demo.climb.model.exception.NotFoundException;

import javax.inject.Inject;
import java.util.Map;

public class TopoConverter extends StrutsTypeConverter {

    @Inject
    TopoManager topoManager;
    @Override
    public Object convertFromString(Map pContext, String[] pValues, Class pToClass) {
        Object vRetour = null;
        System.out.println("trying to convert: "+pValues[0]);
        if (pValues != null) {
            if (pValues.length == 1) {
                String vValue = pValues[0];
                try {
                    vRetour = StringUtils.isEmpty(vValue) ? null : topoManager.getTopo(Integer.parseInt(vValue));
                    System.out.println(vRetour);
                } catch (NumberFormatException pEx) {
                    throw new TypeConversionException("Format de fraction invalide", pEx);
                } catch (Exception e) {
                    System.err.println("topo not found in converter");
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
        if (pObject instanceof Topo) {
            Topo vFraction = (Topo) pObject;
            Topo topo = (Topo) pObject;
            vString=topo.getName();
        } else {
            vString = "";
        }
        return vString;
    }
}
