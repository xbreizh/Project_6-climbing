package org.example.demo.climb.business.impl;


import org.apache.commons.lang3.EnumUtils;
import org.apache.log4j.Logger;
import org.example.demo.climb.business.contract.CountryManager;
import org.example.demo.climb.business.contract.MemberManager;
import org.example.demo.climb.business.contract.SpotManager;
import org.example.demo.climb.consumer.contract.SpotDao;
import org.example.demo.climb.model.ClimbingType;
import org.example.demo.climb.model.Grade;
import org.example.demo.climb.model.bean.Spot;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Transactional
@Named("spotManager")
public class SpotManagerImpl implements SpotManager {
    private Logger logger = Logger.getLogger(this.getClass().getName());
    private Class cl = Spot.class;
    @Inject
    private SpotDao spotDao;
    @Inject
    private MemberManager memberManager;
    @Inject
    private CountryManager countryManager;

    public static String toCamelCase(final String init) {
        if (init == null)
            return null;

        final StringBuilder ret = new StringBuilder(init.length());

        for (final String word : init.split(" ")) {
            if (!word.isEmpty()) {
                ret.append(word.substring(0, 1).toUpperCase());
                ret.append(word.substring(1).toLowerCase());
            }
            if (!(ret.length() == init.length()))
                ret.append(" ");
        }

        return ret.toString();
    }

    // Create
    @Override
    public void addSpot(Spot spot) {
        // Setting Spot Name and CityWith Upper Case
        spot.setCity(spot.getCity().toUpperCase());
        spot.setName(toCamelCase(spot.getName()));
        spotDao.add(spot);
    }

    // Get
    @Override
    public Spot getSpotById(Integer id) {
        return spotDao.getById(id);
    }

    // Get List
    @Override
    public List<Spot> getListSpot(String str, String climbingType, String hasTopo, String levelMin, String levelMax) {
        String ct = "ALL";
        String htopo = "";
        for (ClimbingType clt : ClimbingType.values()) {
            if (clt.getName().equals(climbingType)) {
                ct = clt.getName().toUpperCase();
            }
        }
        logger.info("Has topo: " + hasTopo);
        if (hasTopo != null) {
            if (hasTopo.equals("true")) {
                htopo = "is not null";
            }
        }
        str = str.toUpperCase();
        if (str == null) {
            logger.info("str was null");
            str = "";
        }
        logger.info("data passed: Str: "+str+ "\n ClimbingType: "+climbingType+"\n hasTopo: "+hasTopo+"\nlevelMin: "+levelMin+"\n levelMax: "+levelMax);
        /*boolean validGrade= EnumUtils.isValidEnum(Grade.class, levelMin) && EnumUtils.isValidEnum(Grade.class, levelMax);
        if(validGrade) {
            if (Grade.valueOf(levelMin).ordinal() == 0) {
                levelMin = Grade.values()[1].getValue();
                logger.info("levelMin: "+levelMin);
            }
            if (Grade.valueOf(levelMax).ordinal() == 0) {
                levelMax = Grade.values()[32].getValue();
                logger.info("levelMax: "+levelMax);
            }
            logger.info("str: " + str + " climb: " + ct + " topo: " + htopo);
            return spotDao.ListSpotByCriterias(str, ct, htopo, levelMin, levelMax);
        }else{
            logger.info("data search invalid, returning null");
            return null;
        }*/


        return spotDao.ListSpotByCriterias(str, ct, htopo, levelMin, levelMax);

    }

    @Override
    public List<Spot> getListSpot() {
        return spotDao.getAll();
    }


    // Delete

    // Update
    @Override
    public void updateSpot(Spot spot) {
        logger.info("spot received: " + spot);
        try {
            spotDao.update(spot);
        } catch (NullPointerException e) {
            logger.info("spot couldn t be found: " + spot.getName());
        }


    }

    @Override
    public void deleteSpot(Spot spot) {
        try {
            spotDao.delete(spot);
        } catch (NullPointerException e) {
            logger.info("spot couldn t be deleted: ");
        }
    }

}
