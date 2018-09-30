package org.example.demo.climb.business.impl;


import org.example.demo.climb.business.contract.manager.MemberManager;
import org.example.demo.climb.business.contract.manager.SpotManager;
import org.example.demo.climb.consumer.contract.SpotDao;
import org.example.demo.climb.model.bean.Spot;
import org.example.demo.climb.model.bean.member.Member;
import org.example.demo.climb.model.exception.NotFoundException;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Transactional
@Named("spotManager")
public class SpotManagerImpl  implements SpotManager {

    private Class cl=Spot.class;
    @Inject
    private SpotDao spotDao;
    @Inject
    private MemberManager memberManager;

    @Override
    public List<Spot> getListSpot() {
        return spotDao.getAll();

    }

    @Override
    public List<Spot> getListSpot(String continent, String country, String region) {

        return null;
    }


    @Override
    public void addSpot(Spot spot) {
        spotDao.add(spot);
    }

    @Override
    public Spot getSpot(Integer id) {
        return (Spot) spotDao.getById(id);
    }

    @Override
    public Spot getSpot(String pLogin) {
        return null;
    }

    @Override
    public void updateSpot(Spot spot) {
        int id = spot.getId();
        Spot s = (Spot) spotDao.getById(id);
        if(!(spot.getName()==null)){
            s.setName(spot.getName());
        }
        if(!(spot.getNb_ways()==0)){
            s.setNb_ways(spot.getNb_ways());
        }

        spotDao.update(spot);
    }

    @Override
    public void deleteSpot(int id) {
        System.out.println("trying to delete spot: "+id);
        Spot m= (Spot) spotDao.getById(id);
        spotDao.delete(m);
    }

    @Override
    public void updateWhenDeletingMember(int id) {
        System.out.println("trying to update member spots before deleting");
        /*System.out.println("updating spotList owner on member deletion");
       *//* try {*//*
            *//*Member m = memberManager.getMember(1);*//*
        List<Spot> spotList= spotDao.getListfromMember(id);
            spotDao.updateWhenDeletingMember(1, id);
            System.out.println("update done");*/
        /*} catch (NotFoundException e) {
            e.printStackTrace();
        }*/
        /*Query query = sessionFactory.getCurrentSession().createQuery("update Spot set creatorSpot=(select m from Member m where Member.id=1) where creatorSpot= :memberId");*/

    }


}
