package org.example.demo.climb.business.impl;
import org.example.demo.climb.business.contract.manager.CountryManager;
import org.example.demo.climb.consumer.contract.CountryDao;
import org.example.demo.climb.model.bean.Country;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
@Transactional
@Named("countryManager")
public class CountryManagerImpl implements CountryManager {


    private Class cl= Country.class;

    @Inject
    private SessionFactory sessionFactory;
    @Inject
    private CountryDao countryDao;

    @Override
    public List<String> getListContinent() {
       /* List<String> continentList = new ArrayList<>();
        System.out.println(countryDao.getAll());
        for (Country country: countryDao.getAll()
             ) {
            continentList.add(country.getContinent());
        }
        System.out.println(continentList);*/
        return countryDao.getListContinent();
    }

    @Override
    public List<Country> getListCountry() {
        System.out.println("trying to get Country list");
        return countryDao.getAll();

    }
    @Override
    public List<String> getListCountryStrings(){
        List<String> countryList = new ArrayList<>();
        for (Country country: countryDao.getAll()
        ) {
            countryList.add(country.getName());
        }
        return countryList;
    }

    @Override
    public List<String> getListCountryByContinent(String continent) {
        List<String> countrytList = null;
        for (Country country: countryDao.getAllByContinent(continent)
        ) {
            countrytList.add(country.getContinent());
        }
        return countrytList;
    }

    @Override
    public Country getCountry(String name) {
        return countryDao.getCountryByName(name);
    }

    @Override
    public Country getCountry(int id) {
        return countryDao.getCountryById(id);
    }


}
