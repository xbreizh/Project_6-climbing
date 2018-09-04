package org.example.demo.climb.business.impl;

import org.example.demo.climb.business.contract.ZoneDao;
import org.example.demo.climb.business.contract.manager.ZoneManager;
import org.example.demo.climb.model.bean.Zone;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named("zoneManager")
public class ZoneManagerImpl implements ZoneManager {

    private Zone vZone = null;
    @Inject
    private ZoneDao zoneDao;


    @Override
    public List<Zone> getListZone() {
        System.out.println("zone manager: " + zoneDao.findAll().size());
        return zoneDao.findAll();

    }

    @Override
    public boolean addZone(Zone zone) {
        System.out.println("Managered: " + zone);
        zoneDao.addZone(zone);
        return true;
    }

    @Override
    public Zone getZone(Integer pId) {
        Zone zone = (Zone) zoneDao.findOne(pId);
        return zone;
    }

    @Override
    public Zone getZone(String name) {
        return null;
    }

    /*boolean updateZone(Zone zone);*/

    @Override
    public boolean updateZone(Zone zone) {
        try {
            System.out.println("zone mgmt: " + zone);
            zoneDao.update(zone);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteZone(int id) {

        zoneDao.delete(id);
        return true;
    }
}
