package org.example.demo.climb.business.impl;


import org.apache.log4j.Logger;
import org.example.demo.climb.business.contract.CountryManager;
import org.example.demo.climb.business.contract.MemberManager;
import org.example.demo.climb.business.contract.SpotManager;
import org.example.demo.climb.consumer.contract.SpotDao;
import org.example.demo.climb.model.ClimbingType;
import org.example.demo.climb.model.bean.Country;
import org.example.demo.climb.model.bean.Spot;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Named("spotManager")
public class SpotManagerImpl  implements SpotManager {
    private Logger logger = Logger.getLogger(this.getClass().getName());
    private Class cl=Spot.class;
    @Inject
    private SpotDao spotDao;
    @Inject
    private MemberManager memberManager;
    @Inject
    private CountryManager countryManager;

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
    public List<Spot> getListSpot(String str, String climbingType, String hasTopo, int levelMin, int levelMax) {
        String  ct = "ALL";
        String  htopo = "";
        for(ClimbingType clt: ClimbingType.values()){
            if(clt.getName().equals(climbingType)){
                ct = clt.getName().toUpperCase();
            }
        }
        logger.debug("Has topo: "+hasTopo);
        if(hasTopo!=null) {
            if (hasTopo.equals("true")) {
                htopo = "is not null";
            }
        }
        str = str.toUpperCase();
        if(str == null){
            logger.debug("str was null");
            str="";
        }
        if(levelMin == 0){levelMin=1;}
        if(levelMax == 0){levelMax=32;}
        logger.debug("str: "+str+" climb: "+ct+" topo: "+htopo);
       return spotDao.ListSpotByCriterias(str, ct, htopo, levelMin, levelMax);
    }

    @Override
    public List<Spot> getListSpot() {
        return spotDao.getAll();
    }
  
    // Update
    @Override
    public void updateSpot(Spot spot) {
        logger.debug("spot received: "+spot);
     try{spotDao.update(spot);}
     catch(NullPointerException e){
         logger.debug("spot couldn t be found: "+spot.getName());
     }


    }


    // Delete

    @Override
    public void deleteSpot(Spot spot) {
        try{
            spotDao.delete(spot);}
        catch(NullPointerException e){
            logger.debug("spot couldn t be deleted: ");
        }
    }
    public static String toCamelCase(final String init) {
        if (init==null)
            return null;

        final StringBuilder ret = new StringBuilder(init.length());

        for (final String word : init.split(" ")) {
            if (!word.isEmpty()) {
                ret.append(word.substring(0, 1).toUpperCase());
                ret.append(word.substring(1).toLowerCase());
            }
            if (!(ret.length()==init.length()))
                ret.append(" ");
        }

        return ret.toString();
    }

}
