package org.example.demo.climb.webapp.converter;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.util.StrutsTypeConverter;
import org.example.demo.climb.business.contract.CommentManager;
import org.example.demo.climb.model.bean.Comment;

import javax.inject.Inject;
import java.util.Map;

public class CommentConverter extends StrutsTypeConverter {
    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Inject
    CommentManager CommentManager;
    @Override
    public Object convertFromString(Map pContext, String[] pValues, Class pToClass) {
        Object vRetour = null;
        logger.debug("trying to convert: "+pValues[0]);
        if (pValues != null) {
            if (pValues.length == 1) {
                String vValue = pValues[0];
                try {
                    vRetour = StringUtils.isEmpty(vValue) ? null : CommentManager.getComment(Integer.parseInt(vValue));
                    System.out.println(vRetour);
                } catch (NumberFormatException pEx) {
                    logger.error("Format de fraction invalide", pEx);
                } catch (Exception e) {
                    logger.error("Comment not found in converter");
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
        if (pObject instanceof Comment) {
            Comment vFraction = (Comment) pObject;
            Comment Comment = (Comment) pObject;
            vString=Comment.getText();
        } else {
            vString = "";
        }
        return vString;
    }
}
