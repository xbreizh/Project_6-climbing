package org.example.demo.climb.webapp.converter.locator;

import com.opensymphony.xwork2.conversion.TypeConversionException;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.util.StrutsTypeConverter;
import org.example.demo.climb.business.contract.manager.MemberManager;
import org.example.demo.climb.model.bean.member.Member;
import org.example.demo.climb.model.bean.member.Utilisateur;
import org.example.demo.climb.model.exception.NotFoundException;

import javax.inject.Inject;
import java.util.Map;

public class MemberLocator extends StrutsTypeConverter {
    @Inject
    private MemberManager memberManager;


    @Override
    public Object convertFromString(Map pContext, String[] pValues, Class pToClass) {
        Object vRetour = null;

        if (pValues != null) {
            if (pValues.length == 1) {
                String vValue = pValues[0];
                try {
                    vRetour
                            = StringUtils.isEmpty(vValue)
                            ? null
                            :  memberManager.getMember(new Integer(vValue));
                    System.out.println("vValue: "+vValue);
                } catch (NumberFormatException pEx) {
                    throw new TypeConversionException("Format d'identifiant membre invalide", pEx);
                } catch (NotFoundException pEx) {
                    throw new TypeConversionException("Membre introuvable", pEx);
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
        String vString="";
        if (pObject instanceof Member) {
            Member member = (Member) pObject;
           /* vString = member.getId() != null? member.getId().toString(): "";*/
            if(member.getId()!=0){
                try {
                    vString = memberManager.getMember().toString();
                } catch (NotFoundException e) {
                    e.printStackTrace();
                }
            }
        } else {
            vString = "";
        }
        return vString;
    }
}
