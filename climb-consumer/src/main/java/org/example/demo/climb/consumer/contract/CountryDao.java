package org.example.demo.climb.consumer.contract;



import org.example.demo.climb.model.bean.Country;

import java.util.List;

public interface CountryDao {

    // Get
    Country getCountryByName(String name);
    Country getCountryById(int id);

    // Get List
    List<Country> getAll();
    List<String> getListContinent();
    List<Country> getAllByContinent(String continent);

}
