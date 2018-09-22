package org.example.demo.climb.business.contract.manager;

import org.example.demo.climb.model.bean.Spot;
import org.example.demo.climb.model.exception.NotFoundException;

import java.util.List;


/**
 * Manager du package « utilisateur »
 */
public interface SpotManager {

    //Create
    void addSpot(Spot zone);

    //Get list
    List<Spot> getListSpot();

    //Read
    Spot getSpot(Integer pId) throws NotFoundException;

    Spot getSpot(String name) throws NotFoundException;

    //Update
    void updateSpot(Spot zone);

    //Delete
    void deleteSpot(int id);

}
