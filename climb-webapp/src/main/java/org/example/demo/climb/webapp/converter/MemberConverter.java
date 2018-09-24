package org.example.demo.climb.webapp.converter;

import com.opensymphony.xwork2.conversion.TypeConversionException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.Fraction;
import org.apache.struts2.util.StrutsTypeConverter;
import org.example.demo.climb.business.contract.manager.MemberManager;
import org.example.demo.climb.model.bean.member.Member;
import org.example.demo.climb.model.exception.NotFoundException;

import javax.inject.Inject;
import java.util.Map;

public class MemberConverter extends StrutsTypeConverter {

    @Inject
    MemberManager memberManager;
    @Override
    public Object convertFromString(Map pContext, String[] pValues, Class pToClass) {
        Object vRetour = null;
        System.out.println("trying to convert: "+pValues[0]);
        if (pValues != null) {
            if (pValues.length == 1) {
                String vValue = pValues[0];
                try {
                    vRetour = StringUtils.isEmpty(vValue) ? null : memberManager.getMember(Integer.parseInt(vValue));
                    System.out.println(vRetour);
                } catch (NumberFormatException pEx) {
                    throw new TypeConversionException("Format de fraction invalide", pEx);
                } catch (NotFoundException e) {
                    System.err.println("Format de fraction invalide"+ e.getMessage());
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
        if (pObject instanceof Member) {
            Member vFraction = (Member) pObject;
            Member member = (Member) pObject;
           /* vString = String.format("%d/%d",
                    vFraction.getNumerator(),
                    vFraction.getDenominator());*/
            vString=member.getLogin();
        } else {
            vString = "";
        }
        return vString;
    }
}
