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
    private Session session;

    @Override
    public List<Zone> getListZone() {
        System.out.println("trying to get Zone list");
        gettingSession();
        return session.createQuery("from Zone ").list();

    }

    private void gettingSession() {
        this.session= sessionFactory.getCurrentSession();
    }

    @Override
    public void addZone(Zone zone) {
        gettingSession();
        session.persist(zone);
    }

    @Override
    public Zone getZone(Integer pId) {
        gettingSession();
        return (Zone) session.get(cl, pId);
    }

    @Override
    public Zone getZone(String pLogin) {
        return null;
    }

    @Override
    public void updateZone(Zone zone) {
        gettingSession();
        int id = zone.getId();
        Zone z = (Zone) session.get(cl.getName(), id);
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
        session.update(z);
    }

    @Override
    public void deleteZone(int id) {
        gettingSession();
        System.out.println("trying to delete zone: "+id);
        Zone m= (Zone) session.get(cl, id);
        session.delete(cl.getName(), m);
    }








}
