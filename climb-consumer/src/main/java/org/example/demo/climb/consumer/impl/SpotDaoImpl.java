package org.example.demo.climb.consumer.impl;
import org.example.demo.climb.consumer.contract.MemberDao;
import org.example.demo.climb.consumer.contract.SpotDao;
import org.example.demo.climb.model.bean.Spot;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class SpotDaoImpl implements SpotDao {

    private Class cl = Spot.class;
    @Inject
    private SessionFactory sessionFactory;
    @Inject
    private MemberDao memberDao;

    /*@Override*/
    public void add(Spot o) {
        /*sessionFactory.getCurrentSession().save(o);*/
        sessionFactory.getCurrentSession().persist(o);
    }

    // Get
    /*@Override*/
    public Spot getById(int id) {
        Query query=sessionFactory.getCurrentSession().createQuery(
                "From Spot where id=:n");
        query.setParameter("n", id);
        return (Spot) query.getSingleResult();
    }

    @Override
    public Spot getSpotByName(String name) {
        Query query=sessionFactory.getCurrentSession().createQuery(
                "From Spot where name=:n");
        query.setParameter("n", name);
        return (Spot) query.getSingleResult();
    }

    // Get List
   /* @Override*/
    public List getAll() {
        return sessionFactory.getCurrentSession().createQuery("from Spot").list();
    }


    @Override
    public List<Spot> ListSpotByContinent(String continent) {
        Query query=sessionFactory.getCurrentSession().createQuery(
                "From Spot where country.continent=:c");
        query.setParameter("c", continent);
        return query.getResultList();
    }

    @Override
    public List<Spot> ListSpotByCountry(String continent, String country) {
        Query query=sessionFactory.getCurrentSession().createQuery(
                "select spotList from Country c where c.name=:countryName and c.continent=:continentName");
        query.setParameter("continentName", continent);
        query.setParameter("countryName", country);
        return query.getResultList();
    }

    @Override
    public List<Spot> ListSpotByCity(String continent, String country, String city) {
        // no value
        if(continent.equals("")|| country.equals("")|| city.equals("")){

        }
        String str="From Spot where country.continent=:cn and country.name=:cr and city=:r";
        Query query=sessionFactory.getCurrentSession().createQuery(str
                );
        query.setParameter("cn", continent);
        query.setParameter("cr", country);
        query.setParameter("r", city);
  return query.getResultList();
    }

    @Override
    public List<String> ListCity() {
        Query query=sessionFactory.getCurrentSession().createQuery(
                "select distinct (city) from Spot ");

        return query.getResultList();
    }


   /* @Override*/
    public void update(Spot o) {
        sessionFactory.getCurrentSession().update(o);
    }

    /*@Override*/
    public void delete(Spot o) {
        sessionFactory.getCurrentSession().delete(cl.getName(), o);
    }

    @Override
    public void updateWhenDeletingMember(int id1, int id2){
       /* Member m = (Member) memberDao.getById(id1);
        Query query=sessionFactory.getCurrentSession().createQuery("update Spot set creatorSpot= :member1 where creatorSpot.id=:member2");
        query.setParameter("member1", m);
        query.setParameter("member2", id2);
        int result = query.executeUpdate();
        System.out.println("updated list?");*/
    }


}
