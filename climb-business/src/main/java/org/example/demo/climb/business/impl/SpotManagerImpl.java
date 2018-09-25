package org.example.demo.climb.business.impl;


import org.example.demo.climb.business.contract.manager.SpotManager;
import org.example.demo.climb.model.bean.Spot;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Transactional
@Named("spotManager")
public class SpotManagerImpl  implements SpotManager {

    /*private Spot spot = null;*/
    private Class cl=Spot.class;
    /*@Inject
    private SpotDao spotDao;*/
    @Inject
    private SessionFactory sessionFactory;

    @Override
    public List<Spot> getListSpot() {
        return sessionFactory.getCurrentSession().createQuery("from Spot ").list();

    }



    @Override
    public void addSpot(Spot spot) {
        sessionFactory.getCurrentSession().persist(spot);
    }

    @Override
    public Spot getSpot(Integer pId) {
        return (Spot) sessionFactory.getCurrentSession().get(cl, pId);
    }

    @Override
    public Spot getSpot(String pLogin) {
        return null;
    }

    @Override
    public void updateSpot(Spot spot) {
        int id = spot.getId();
        Spot s = (Spot) sessionFactory.getCurrentSession().get(cl, id);
        if(!(spot.getName()==null)){
            s.setName(spot.getName());
        }
        if(!(spot.getNb_ways()==0)){
            s.setNb_ways(spot.getNb_ways());
        }

        sessionFactory.getCurrentSession().update(s);
    }

    @Override
    public void deleteSpot(int id) {
        System.out.println("trying to delete spot: "+id);
        Spot m= (Spot) sessionFactory.getCurrentSession().get(cl, id);
        sessionFactory.getCurrentSession().delete(cl.getName(), m);
    }








}
