package org.example.demo.climb.consumer.contract;

import org.example.demo.climb.model.bean.Spot;
import org.example.demo.climb.model.bean.Topo;

import java.util.ArrayList;
import java.util.List;

public interface SearchDao {

    List<Spot> findListSpotByString(String str);

    List<Topo> findListTopoByString(String str);

    List<Topo> findListTopoByCriterias(ArrayList<String> aList);

    List<Spot> findListSpotByCriterias(ArrayList<String> aList);


}
