package org.example.demo.climb.consumer.impl;

import org.example.demo.climb.consumer.contract.SearchDao;
import org.example.demo.climb.model.bean.Country;
import org.example.demo.climb.model.bean.Spot;
import org.example.demo.climb.model.bean.Topo;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
public class SearchDaoImpl implements SearchDao {

    @Inject
    private SessionFactory sessionFactory;
    @Override
    public List<Spot> findListSpotByString(String str) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "From Spot where lower(name) like :n or lower(city) like :n");
        query.setParameter("n", "%"+str+"%".toLowerCase());
        System.out.println(str);
        return query.getResultList();
}

    @Override
    public List<Topo> findListTopoByString(String str) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "From Topo where lower(name) like :n ");
        query.setParameter("n", "%"+str+"%".toLowerCase());
        System.out.println("string passed: "+str);
        System.out.println("search from dao: "+query.getParameter("n").toString());
        return query.getResultList();
    }

    @Override
    public List<Topo> findListTopoByCriterias(ArrayList<String> aList) {
        return null;
    }

    @Override
    public List<Spot> findListSpotByCriterias(ArrayList<String> aList) {
        return null;
    }
}
