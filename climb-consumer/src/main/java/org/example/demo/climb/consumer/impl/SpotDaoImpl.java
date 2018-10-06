package org.example.demo.climb.consumer.impl;
import org.example.demo.climb.consumer.contract.MemberDao;
import org.example.demo.climb.consumer.contract.SpotDao;
import org.example.demo.climb.model.bean.Country;
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

    @Override
    public void add(Object o) {
        /*sessionFactory.getCurrentSession().save(o);*/
        sessionFactory.getCurrentSession().persist(o);
    }

    // Get
    @Override
    public Object getById(int id) {
        return(Spot) sessionFactory.getCurrentSession().get(cl, id);
    }

    @Override
    public Spot getSpotByName(String name) {
        Query query=sessionFactory.getCurrentSession().createQuery(
                "From Spot where name=:n");
        query.setParameter("n", name);
        return (Spot) query.getSingleResult();
    }

    // Get List
    @Override
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
    public List<Spot> ListSpotByCountry(Country country) {
        Query query=sessionFactory.getCurrentSession().createQuery(
                "From Spot where country=:c");
        query.setParameter("c", country);
        return query.getResultList();
    }

    @Override
    public List<Spot> ListSpotByRegion(String region) {

        Query query=sessionFactory.getCurrentSession().createQuery(
                "From Spot where region=:r");
        query.setParameter("r", region);
        // if continent, country, region = "" -> return all spots
        // if country, region = "" -> return all spots from continent
        // if region = "" -> return all spots from country
        // else -> return all spots from region
  /*      Query query;
        if(region.equals("")){
            if(country.equals("")){
                query=sessionFactory.getCurrentSession().createQuery(
                        "From Spot where country.continent=:c");
                query.setParameter("c", country.getContinent());
            }else {
                if (country==null) {
                    query = sessionFactory.getCurrentSession().createQuery(
                            "From Spot");
                    query.setParameter("n", country);
                } else {
                    query = sessionFactory.getCurrentSession().createQuery(
                            "From Spot where country.name=:n");
                    query.setParameter("n", country);
                }
            }
        }else{
            query=sessionFactory.getCurrentSession().createQuery(
                    "From Spot where region=:r");
            query.setParameter("r", region);
        }
        return query.getResultList();*/
  return query.getResultList();
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
    public void updateWhenDeletingMember(int id1, int id2){
       /* Member m = (Member) memberDao.getById(id1);
        Query query=sessionFactory.getCurrentSession().createQuery("update Spot set creatorSpot= :member1 where creatorSpot.id=:member2");
        query.setParameter("member1", m);
        query.setParameter("member2", id2);
        int result = query.executeUpdate();
        System.out.println("updated list?");*/
    }


}
