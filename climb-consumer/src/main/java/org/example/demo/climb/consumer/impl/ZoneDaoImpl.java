package org.example.demo.climb.consumer.impl;

import org.example.demo.climb.consumer.contract.ZoneDao;
import org.example.demo.climb.model.bean.zone.Zone;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class ZoneDaoImpl implements ZoneDao {

    private Class cl= Zone.class;

    @Inject
    private SessionFactory sessionFactory;

    @Override
    public void add(Object o) {
        /*int i= Integer.parseInt(sessionFactory.getCurrentSession().createQuery("select max(id) from Zone ").getSingleResult().toString());
        System.out.println("max would be: "+i);
        Zone zone= (Zone) o;
        *//*zone.setId(i+1);*//*
        System.out.println(zone);
        System.out.println("id de o: "+(zone.getId()));*/
        System.out.println("Object to be saved: "+o);
        System.out.println("trying to save object");
        sessionFactory.getCurrentSession().save(o);
        System.out.println("after saving object");
        sessionFactory.getCurrentSession().persist(o);
        System.out.println("object has been persisted");
    }

    @Override
    public List getAll() {
        System.out.println("niveau DAO");

        /*List<Zone> de = sessionFactory.getCurrentSession().createQuery("from Zone ").list();
        System.out.println("liste spots: "+de);*/
        return sessionFactory.getCurrentSession().createQuery("from Zone").list();
    }

    @Override
    public Object getById(int id) {
        return (Zone) sessionFactory.getCurrentSession().get(cl, id);
    }

    @Override
    public void update(Object o) {
        sessionFactory.getCurrentSession().update(o);
    }

    @Override
    public void delete(Object o) {
        sessionFactory.getCurrentSession().delete(cl.getName(), o);
    }

    @Override
    public List<String> getListContinent() {
        /*List<Zone> zoneList = sessionFactory.getCurrentSession().createQuery("select distinct from Zone z ").list();
        List<String> continentList=new ArrayList<>();
        for (Zone zone:zoneList) {
            if (zone != null && zone.getContinent()!=null) {
                continentList.add(zone.getContinent());
            }
        }*/
        List<String> continentList=sessionFactory.getCurrentSession().createQuery(
                "select distinct z.country.continent from Zone z", String.class).getResultList();
        return continentList;
    }

    @Override
    public List<String> getListCountry(String continent) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "select distinct z.country from Zone z where z.country.continent=:continent");
        query.setParameter("continent", continent);

        return query.getResultList();
    }

    @Override
    public List<String> getListRegion(String country) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "select distinct z.region from Zone z where  z.country=:country");
        query.setParameter("country", country);

        return query.getResultList();
    }
}
