package org.example.demo.climb.business.contract.manager;

import org.example.demo.climb.model.bean.Country;

import java.util.List;


/**
 * Manager du package « utilisateur »
 */
public interface CountryManager {



    //Get list
    List<Country> getListCountry();

    List<String> getListContinent();
    List<String> getListCountry(String continent);
    Country getCountry(String country);




}
