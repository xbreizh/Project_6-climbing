package org.example.demo.climb.consumer.contract.manager;

import org.example.demo.climb.model.bean.Zone;
import org.example.demo.climb.model.exception.NotFoundException;

import java.util.List;


/**
 * Manager du package « utilisateur »
 */
public interface ZoneManager {

    //Get list
    List<Zone> getListZone();

    //Create

    void addZone(Zone zone);

    //Read
    Zone getZone(Integer pId) throws NotFoundException;

    Zone getZone(String name) throws NotFoundException;

    //Update

    void updateZone(Zone zone);

    //Delete

    void deleteZone(int id);

    void setDaoClass();


}
