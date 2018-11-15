package org.example.demo.climb.business.impl;


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

    @Override
    public Spot getSpotByName(String login) {
        return spotDao.getSpotByName(login);
    }

    // Get List
    @Override
    public List<Spot> getListSpot(String str, String climbingType, String hasTopo) {
        String  ct = "ALL";
        String  htopo = "is null";
        for(ClimbingType clt: ClimbingType.values()){
            if(clt.getName().equals(climbingType)){
                ct = clt.getName().toUpperCase();
            }
        }
        if(hasTopo!=null) {
            if (hasTopo.equals("on")) {
                htopo = "is not null";
            }
        }
        str = str.toUpperCase();
        if(str == null){
            System.out.println("str was null");
            str="";
        }
        System.out.println("str: "+str+" climb: "+ct+" topo: "+htopo);
       return spotDao.ListSpotByCriterias(str, ct, htopo);
    }

    @Override
    public List<Spot> getListSpot() {
        return spotDao.getAll();
    }
    @Override
    public List<String> getListCityByCountry(Country country) {
        List<String> cityList = new ArrayList<>();
        for (Spot spot:spotDao.ListSpotByCountry(country)
             ) {
            cityList.add(spot.getCity());
        }
        return cityList;
    }

    @Override
    public List<String> getListCity() {
        return spotDao.ListCity();
    }

    @Override
    public List<String> getListCityByContinent(String continent) {
        return null;
    }

    @Override
    public List<Spot> getListSpotByContinent(String continent) {
        return spotDao.ListSpotByContinent(continent);
    }

    @Override
    public List<Spot> getListSpotByCountry(Country country) {
        return spotDao.ListSpotByCountry(country);
    }


    // Update
    @Override
    public void updateSpot(Spot spot) {
        int id = spot.getId();
        System.out.println(spot.getName());
        System.out.println(spot.getCity());
        System.out.println(spot.getId());
        System.out.println("got spot from dao ok");
        Spot s = (Spot) spotDao.getById(id);
        if(!(spot.getName().equals(""))){
            s.setName(spot.getName());
            System.out.println("updated name");
        }
        if(!spot.getCity().equals("")){
            s.setCity(spot.getCity());
            System.out.println("updated city");
        }
        if(!spot.getDescription().equals("")){
            s.setDescription(spot.getDescription());
            System.out.println("updated description");
        }
        if(!spot.getDescription().equals("")){
            s.setDescription(spot.getDescription());
            System.out.println("updated description");
        }
        if(spot.getLatitude()==0){
            s.setLatitude(spot.getLatitude());
            System.out.println("updated latitude");
        }
        if(spot.getLongitude()==0){
            s.setLongitude(spot.getLongitude());
            System.out.println("updated longitude");
        }

        spotDao.update(s);
    }

    @Override
    public void updateWhenDeletingMember(int id) {
        System.out.println("trying to update member spots before deleting");
        spotDao.updateWhenDeletingMember(1, id);
    }

    // Delete

    @Override
    public void deleteSpot(int id) {
        System.out.println("trying to delete spot: "+id);
        Spot m= (Spot) spotDao.getById(id);
        spotDao.delete(m);
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
