package org.example.demo.climb.consumer.contract.manager;

import org.example.demo.climb.model.bean.climb.Spot;
import org.example.demo.climb.model.exception.NotFoundException;

import java.util.List;


/**
 * Manager du package « utilisateur »
 */
public interface SpotManager {

    //Get list
    List<Spot> getListSpot();

    //Create

    void addSpot(Spot zone);

    //Read
    Spot getSpot(Integer pId) throws NotFoundException;

    Spot getSpot(String name) throws NotFoundException;

    //Update

    void updateSpot(Spot zone);

    //Delete

    void deleteSpot(int id);

    void setDaoClass();


}
