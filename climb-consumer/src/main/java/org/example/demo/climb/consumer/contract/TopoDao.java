package org.example.demo.climb.consumer.contract;

import org.example.demo.climb.model.bean.Topo;

import java.util.List;

public interface TopoDao /*extends Dao*/ {

    void updateWhenDeletingMember(int id1, int id2);

    // Get
    Topo getTopoByName(String name);

    // Get List
    List<Topo> ListTopoByOwner(String name);

    List<String> ListTopoNames();


    void update(Topo topo);

    void delete(Topo topo);

    List<Topo> getAll();

    Topo getById(int id);

    void add(Topo topo);

}
