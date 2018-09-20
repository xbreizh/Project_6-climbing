package org.example.demo.climb.consumer.impl;


import org.example.demo.climb.consumer.contract.MemberDao;
import org.example.demo.climb.consumer.contract.SpotDao;
import org.example.demo.climb.consumer.contract.manager.SpotManager;
import org.example.demo.climb.model.bean.Spot;
import org.example.demo.climb.model.bean.member.Member;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Transactional
@Named("spotManager")
public class SpotManagerImpl /*implements SpotManager*/ {

/*
    private Spot spot;
    @Inject
    private SpotDao spotDao;
    @Inject
    private MemberDao memberDao;

    @Override
    public List<Spot> getListSpot() {
        return spotDao.getAll();
    }

    @Override
    public void addSpot(Spot spot) {
        Member m = (Member) memberDao.findOne(1);
        spot.setCreator(m);
        spotDao.add(spot);
    }

    @Override
    public Spot getSpot(Integer pId) {
        Spot spot = (Spot) spotDao.getById(pId);
        return spot;
    }

    @Override
    public Spot getSpot(String name) {
        return null;
    }

    @Override
    public void updateSpot(Spot spot) {
        int id = spot.getId();
        Spot m = (Spot) spotDao.getById(id);
        spot.setName(m.getName());
        spotDao.update(spot);
    }

    @Override
    public void deleteSpot(int id) {
        spotDao.delete(id);
    }*/


}
