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
    private Session session;

    @Override
    public List<Spot> getListSpot() {
        gettingSession();
        return session.createQuery("from Spot ").list();

    }

    private void gettingSession() {
        this.session= sessionFactory.getCurrentSession();
    }

    @Override
    public void addSpot(Spot spot) {
        gettingSession();
        session.persist(spot);
    }

    @Override
    public Spot getSpot(Integer pId) {
        gettingSession();
        return (Spot) session.get(cl, pId);
    }

    @Override
    public Spot getSpot(String pLogin) {
        return null;
    }

    @Override
    public void updateSpot(Spot spot) {
        gettingSession();
        int id = spot.getId();
        Spot s = (Spot) session.get(cl, id);
        if(!(spot.getName()==null)){
            s.setName(spot.getName());
        }
        if(!(spot.getNb_ways()==0)){
            s.setNb_ways(spot.getNb_ways());
        }

        session.update(s);
    }

    @Override
    public void deleteSpot(int id) {
        gettingSession();
        System.out.println("trying to delete spot: "+id);
        Spot m= (Spot) session.get(cl, id);
        session.delete(cl.getName(), m);
    }








}
