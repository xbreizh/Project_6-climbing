package org.example.demo.climb.business.impl;


import org.example.demo.climb.business.contract.manager.CountryManager;
import org.example.demo.climb.business.contract.manager.MemberManager;
import org.example.demo.climb.business.contract.manager.RouteManager;
import org.example.demo.climb.consumer.contract.RouteDao;
import org.example.demo.climb.model.bean.Route;
import org.example.demo.climb.model.bean.Route;
import org.example.demo.climb.model.bean.Spot;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Transactional
@Named("routeManager")
public class RouteManagerImpl implements RouteManager {

    private Class cl= Route.class;
    @Inject
    private RouteDao routeDao;
    @Inject
    private MemberManager memberManager;
    @Inject
    private CountryManager countryManager;

    @Override
    public void addRoute(Route route) {
        routeDao.add(route);
    }

    @Override
    public Route getRouteById(Integer id) {
        return (Route) routeDao.getById(id);
    }

    @Override
    public Route getRouteByName(String pLogin) {
        return null;
    }

    @Override
    public List<Route> getListRoute() {
        return routeDao.getAll();

    }

    @Override
    public List<Route> getListRoute(Spot spot, String grade, String type, int height) {
        return routeDao.ListByCriterias(spot, grade, type, height);
    }


    @Override
    public void updateRoute(Route route) {
        int id = route.getId();
        Route s = (Route) routeDao.getById(id);
        if(!(route.getName()==null)){
            s.setName(route.getName());
        }
       /* if(!(route.getNb_ways()==0)){
            s.setNb_ways(route.getNb_ways());
        }*/

        routeDao.update(route);
    }

    @Override
    public void deleteRoute(int id) {
        System.out.println("trying to delete route: "+id);
        Route m= (Route) routeDao.getById(id);
        routeDao.delete(m);
    }

    @Override
    public void updateWhenDeletingMember(int id) {
        System.out.println("trying to update member routes before deleting");
        routeDao.updateWhenDeletingMember(1, id);
    }


}
