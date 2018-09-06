package org.example.demo.climb.consumer.impl;

import org.example.demo.climb.consumer.contract.Dao;
import org.example.demo.climb.consumer.contract.manager.ZoneManager;
import org.example.demo.climb.model.bean.Zone;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named("zoneManager")
public class ZoneManagerImpl implements ZoneManager {

    @Inject
    private Dao dao;
    private Class cl = Zone.class;
    private Zone zone;

    @Override
    public List<Zone> getListZone() {
        setDaoClass();
        return dao.getAll();
    }

    @Override
    public void addZone(Zone zone) {
        setDaoClass();
        dao.add(zone);
    }

    @Override
    public Zone getZone(Integer pId) {
        setDaoClass();
        return (Zone) dao.getById(pId);
    }

    @Override
    public Zone getZone(String name) {
        return null;
    }

    @Override
    public void updateZone(Zone zone) {

    }

    @Override
    public void deleteZone(int id) {
        setDaoClass();
        dao.delete(id);
    }

    public void setDaoClass() {
        dao.setCl(cl);
    }
}
