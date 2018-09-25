package org.example.demo.climb.business.impl;
import org.example.demo.climb.business.contract.manager.ZoneManager;
import org.example.demo.climb.model.bean.Zone;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Transactional
@Named("zoneManager")
public class ZoneManagerImpl  implements ZoneManager {


    private Class cl=Zone.class;

    @Inject
    private SessionFactory sessionFactory;

    @Override
    public List<Zone> getListZone() {
        System.out.println("trying to get Zone list");
        return sessionFactory.getCurrentSession().createQuery("from Zone ").list();

    }


    @Override
    public void addZone(Zone zone) {
        sessionFactory.getCurrentSession().persist(zone);
    }

    @Override
    public Zone getZone(Integer pId) {
        return (Zone) sessionFactory.getCurrentSession().get(cl, pId);
    }

    @Override
    public Zone getZone(String pLogin) {
        return null;
    }

    @Override
    public void updateZone(Zone zone) {
        int id = zone.getId();
        Zone z = (Zone) sessionFactory.getCurrentSession().get(cl.getName(), id);
        if(zone.getName() != null){
            z.setName(zone.getName());
        }
        if(zone.getCountry() != null){
            z.setCountry(zone.getCountry());
        }
        if(zone.getRegion() != null){
            z.setRegion(zone.getRegion());
        }
        if(zone.getType() != null){
            z.setType(zone.getType());
        }
        sessionFactory.getCurrentSession().update(z);
    }

    @Override
    public void deleteZone(int id) {
        System.out.println("trying to delete zone: "+id);
        Zone m= (Zone) sessionFactory.getCurrentSession().get(cl, id);
        sessionFactory.getCurrentSession().delete(cl.getName(), m);
    }








}
