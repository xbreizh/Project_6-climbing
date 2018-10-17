package org.example.demo.climb.business.contract;


import org.example.demo.climb.model.bean.Comment;
import org.example.demo.climb.model.bean.Spot;
import org.example.demo.climb.model.bean.Topo;

import java.util.ArrayList;
import java.util.List;

/**
 * Manager du package « utilisateur »
 */
public interface SearchManager {
List<Spot> findSpotByString(String str);
List<Topo> findTopoByString(String str);
List<Spot> findSpotByCriterias(ArrayList<String>list);
List<Topo> findTopoByCriterias(ArrayList<String>list);
}
