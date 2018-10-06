package org.example.demo.climb.consumer.contract;

import org.example.demo.climb.model.bean.Country;
import org.example.demo.climb.model.bean.Spot;

import java.util.List;

public interface SpotDao extends Dao {

    void updateWhenDeletingMember(int id1, int id2);
    // Get
    Spot getSpotByName(String name);

    // Get List
    List<Spot> ListSpotByContinent(String continent);
    List<Spot> ListSpotByCountry(Country country);
    List<Spot> ListSpotByRegion(String region);

}
