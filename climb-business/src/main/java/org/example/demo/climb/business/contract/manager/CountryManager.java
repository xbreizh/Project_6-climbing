package org.example.demo.climb.business.contract.manager;

import org.example.demo.climb.model.bean.Country;

import java.util.List;


/**
 * Manager du package « utilisateur »
 */
public interface CountryManager {



    //Get list
    List<String> getListContinent();
    List<Country> getListCountry();
    List<String> getListCountryStrings();
    List<String> getListCountryByContinent(String continent);
    Country getCountry(String country);
    Country getCountry(int id);




}
