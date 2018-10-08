package org.example.demo.climb.business.impl;


import org.example.demo.climb.business.contract.manager.CountryManager;
import org.example.demo.climb.business.contract.manager.MemberManager;
import org.example.demo.climb.business.contract.manager.SpotManager;
import org.example.demo.climb.consumer.contract.SpotDao;
import org.example.demo.climb.model.bean.Country;
import org.example.demo.climb.model.bean.Spot;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
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
        /*System.out.println("country passed: "+country);
        Country c=countryManager.getCountry(country);
        System.out.println(c.getName());
        spot.setCountry(c);*/
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
    public List<Spot> getListSpot(String continent, String country, String city) {
       return spotDao.ListSpotByCity(continent, country, city);
    }

    @Override
    public List<String> getListCityByCountry(String continent, String country) {
        List<String> list = new ArrayList<>();
        for (Spot spot: spotDao.ListSpotByCountry(continent, country)
             ) {
            list.add(spot.getCity());
        }
        return list;
    }

    @Override
    public List<String> getListCity() {
        return spotDao.ListCity();
    }

    @Override
    public List<String> getListCityByContinent(String continent) {
        return null;
    }


    // Update
    @Override
    public void updateSpot(Spot spot) {
        int id = spot.getId();
        Spot s = (Spot) spotDao.getById(id);
        if(!(spot.getName()==null)){
            s.setName(spot.getName());
        }
       /* if(!(spot.getNb_ways()==0)){
            s.setNb_ways(spot.getNb_ways());
        }*/

        spotDao.update(spot);
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


}
