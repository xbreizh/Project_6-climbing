package org.example.demo.climb.business.contract.manager;


import org.example.demo.climb.model.bean.Route;
import org.example.demo.climb.model.bean.Spot;
import org.example.demo.climb.model.exception.NotFoundException;

import java.util.List;

/**
 * Manager du package « utilisateur »
 */
public interface RouteManager {

    // Create
    void addRoute(Route route);

    // Get
    Route getRouteByName(String name) throws NotFoundException;

    List<Route> getListRoute();

    //Get list
    Route getRouteById(Integer pId) throws NotFoundException;

    List<Route> getListRoute(Spot spot, String grade, String type, int height);

    //Update
    void updateRoute(Route route);

    //Delete
    void deleteRoute(int id);

    //Update on delete
    void updateWhenDeletingMember(int id);


}
