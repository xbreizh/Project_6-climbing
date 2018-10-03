package org.example.demo.climb.consumer.contract;


import java.util.List;

public interface CountryDao {

    public List getAll();
    public List<String> getListContinent();
    public List<String> getListCountry(String continent);

}
