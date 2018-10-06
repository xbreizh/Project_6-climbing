package org.example.demo.climb.business.impl;
import org.example.demo.climb.business.contract.manager.ZoneManager;
import org.example.demo.climb.consumer.contract.ZoneDao;
import org.example.demo.climb.model.bean.Zone;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/*@Transactional
@Named("zoneManager")*/
public class ZoneManagerImpl  /*implements ZoneManager*/ {


   /* private Class cl=Zone.class;

    @Inject
    private SessionFactory sessionFactory;
    @Inject
    private ZoneDao zoneDao;

    @Override
    public List<Zone> getListZone() {
        System.out.println("trying to get Zone list");
        *//*return sessionFactory.getCurrentSession().createQuery("from Zone ").list();*//*
        return zoneDao.getAll();

    }

    @Override
    public List<String> getListContinent() {
        return zoneDao.getListContinent();
    }

    @Override
    public List<String> getListCountry(String continent) {
        return zoneDao.getListCountry(continent);
    }

    @Override
    public List<String> getListRegion(String country) {
        return zoneDao.getListRegion( country);
    }


    @Override
    public void addZone(Zone zone) {
        zoneDao.add(zone);
    }

    @Override
    public Zone getZone(Integer pId) {
        return (Zone) zoneDao.getById(pId);
    }

    @Override
    public Zone getZone(String pLogin) {
        return null;
    }

    @Override
    public void updateZone(Zone zone) {
        zoneDao.update(zone);
    }

    @Override
    public void deleteZone(int id) {
        System.out.println("trying to delete zone: "+id);
        *//*Zone m= (Zone) sessionFactory.getCurrentSession().get(cl, id);*//*
        Zone m = (Zone) zoneDao.getById(id);
        *//*sessionFactory.getCurrentSession().delete(cl.getName(), m);*//*
        zoneDao.delete(m);
    }*/








}
