package org.example.demo.climb.consumer.contract;


import java.util.List;

public interface ZoneDao extends Dao {

    public List<String> getListContinent();
    public List<String> getListCountry(String continent);
    public List<String> getListRegion(String country);

}
