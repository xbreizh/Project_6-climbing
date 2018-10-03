package org.example.demo.climb.business.impl;
import org.example.demo.climb.business.contract.manager.CountryManager;
import org.example.demo.climb.consumer.contract.CountryDao;
import org.example.demo.climb.model.bean.Country;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
/*
@Transactional
@Named("zoneManager")*/
public class CountryManagerImpl /*implements CountryManager*/ {
/*


    private Class cl= Country.class;

    @Inject
    private SessionFactory sessionFactory;
    @Inject
    private CountryDao countryDao;

    @Override
    public List<Country> getListCountry() {
        System.out.println("trying to get Country list");
        */
/*return sessionFactory.getCurrentSession().createQuery("from Zone ").list();*//*

        return countryDao.getAll();

    }

    @Override
    public List<String> getListContinent() {
        return countryDao.getListContinent();
    }

    @Override
    public List<String> getListCountry(String continent) {
        return countryDao.getListCountry(continent);
    }










*/




}
