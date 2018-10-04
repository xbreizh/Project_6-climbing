package org.example.demo.climb.consumer.contract;



import org.example.demo.climb.model.bean.Country;

import java.util.List;

public interface CountryDao {

    List getAll();
    List<String> getListContinent();
    List<String> getListCountry(String continent);
    Country getCountry(String name);

}
