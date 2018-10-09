package org.example.demo.climb.business.contract.manager;

import org.example.demo.climb.model.bean.Country;
import org.example.demo.climb.model.bean.Spot;
import org.example.demo.climb.model.exception.NotFoundException;

import java.util.List;


/**
 * Manager du package « utilisateur »
 */
public interface SpotManager {

    //Create
    void addSpot(Spot zone);

    //Get
    Spot getSpotByName(String name) throws NotFoundException;
    Spot getSpotById(Integer id) throws NotFoundException;

    //Get list
    List<Spot> getListSpot(String continent, String country, String city);
    List<Spot> getListSpot();
    /*List<Spot> getListSpotByCity(String city);*/
    List<String> getListCityByCountry(Country country);
    List<String> getListCity();
    List<String> getListCityByContinent(String continent);

    //Update
    void updateSpot(Spot zone);
    void updateWhenDeletingMember(int id);

    //Delete
    void deleteSpot(int id);

}
