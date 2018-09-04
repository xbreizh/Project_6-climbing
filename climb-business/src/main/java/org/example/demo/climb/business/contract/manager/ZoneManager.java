package org.example.demo.climb.business.contract.manager;

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

    boolean addZone(Zone zone);

    //Read
    Zone getZone(Integer pId) throws NotFoundException;

    Zone getZone(String name) throws NotFoundException;

    //Update

    boolean updateZone(Zone zone);

    //Delete

    boolean deleteZone(int id);


}
