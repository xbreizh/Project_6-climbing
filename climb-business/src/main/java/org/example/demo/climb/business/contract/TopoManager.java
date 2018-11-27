package org.example.demo.climb.business.contract;

import org.example.demo.climb.model.bean.Country;
import org.example.demo.climb.model.bean.Spot;
import org.example.demo.climb.model.bean.Topo;

import java.util.List;


/**
 * Manager du package « utilisateur »
 */
public interface TopoManager {



    //Get list
    List<String> getListTopoByString();
    List<Topo> getListTopo();
    Topo getTopo(String name);
    Topo getTopo(int id);
    void addTopo(Topo topo);
    void updateTopo(Topo topo);
    void deleteTopo(Topo topo);
    boolean addSpotToTopo(Spot spot, Topo topo);
    boolean removeSpotFromTopo(Spot spot, Topo topo);




}
