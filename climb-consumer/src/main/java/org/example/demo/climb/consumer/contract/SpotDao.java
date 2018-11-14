package org.example.demo.climb.consumer.contract;

import org.example.demo.climb.model.ClimbingType;
import org.example.demo.climb.model.bean.Country;
import org.example.demo.climb.model.bean.Spot;

import java.util.List;

public interface SpotDao /*extends Dao*/ {

    void updateWhenDeletingMember(int id1, int id2);
    // Get
    Spot getSpotByName(String name);

    // Get List
    List<Spot> ListSpotByContinent(String continent);
    List<Spot> ListSpotByCountry(Country country);
    List<Spot> ListSpotByCriterias(String str, String climbingType, String hasTopo);
    List<Spot> ListSpotByCity(String continent, String country, String city);
    List<String> ListCity();


    void update(Spot o);
    void delete(Spot o);
    List getAll();
    Spot getById(int id);
    void add(Spot o);

}
