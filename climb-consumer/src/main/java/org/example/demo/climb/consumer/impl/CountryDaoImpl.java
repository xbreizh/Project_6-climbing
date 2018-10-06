package org.example.demo.climb.consumer.impl;

import org.example.demo.climb.consumer.contract.CountryDao;
import org.example.demo.climb.model.bean.Country;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class CountryDaoImpl  implements CountryDao {

    private Class cl= Country.class;

    @Inject
    private SessionFactory sessionFactory;

    // Get
    @Override
    public Country getCountryByName(String name) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "select max(z.id) from Country z where lower(z.name)=lower(:name)");
        query.setParameter("name", name);
        System.out.println(query.uniqueResult());
        int id= (int) query.uniqueResult();
        return sessionFactory.getCurrentSession().get(Country.class, id);
        /*return (Country) query.uniqueResult();*/
    }

    @Override
    public Country getCountryById(int id) {
        return sessionFactory.getCurrentSession().get(Country.class, id);
    }

    // Get List
    @Override
    public List getAll() {
        return sessionFactory.getCurrentSession().createQuery("from Country ").list();
    }

    @Override
    public List<String> getListContinent() {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "select distinct(continent) from Country");
        return query.getResultList();
    }



   /* @Override
    public List<String> getListContinent() {
      List<Country> continentList=sessionFactory.getCurrentSession().createQuery(
                "select distinct z.continent from Country z", String.class).getResultList();
        return continentList;
    }*/

    @Override
    public List<Country> getAllByContinent(String continent) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "From Country z where z.continent=:continent");
        query.setParameter("continent", continent);

        return query.getResultList();
    }




}
