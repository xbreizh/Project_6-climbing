package org.example.demo.climb.consumer.impl;


import org.example.demo.climb.consumer.contract.Dao;
import org.example.demo.climb.consumer.contract.manager.SpotManager;
import org.example.demo.climb.model.bean.climb.Spot;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named("spotManager")
public class SpotManagerImpl implements SpotManager {

    @Inject
    private Dao dao;
    private Class cl = Spot.class;
    private Spot spot;

    @Override
    public List<Spot> getListSpot() {
        setDaoClass();
        return dao.getAll();
    }

    @Override
    public void addSpot(Spot spot) {
        setDaoClass();
        dao.add(spot);
    }

    @Override
    public Spot getSpot(Integer pId) {
        setDaoClass();
        Spot spot = (Spot) dao.getById(pId);
        return spot;
    }

    @Override
    public Spot getSpot(String name) {
        return null;
    }

    @Override
    public void updateSpot(Spot spot) {
    }

    @Override
    public void deleteSpot(int id) {
        setDaoClass();
        dao.delete(id);
    }

    public void setDaoClass() {
        dao.setCl(cl);
    }
}
