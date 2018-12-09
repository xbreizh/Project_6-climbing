package org.example.demo.climb.business.impl;


import org.apache.log4j.Logger;
import org.example.demo.climb.business.contract.CountryManager;
import org.example.demo.climb.business.contract.MemberManager;
import org.example.demo.climb.business.contract.RouteManager;
import org.example.demo.climb.consumer.contract.RouteDao;
import org.example.demo.climb.model.bean.Route;
import org.example.demo.climb.model.bean.Spot;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Transactional
@Named("routeManager")
public class RouteManagerImpl implements RouteManager {
    private Logger logger = Logger.getLogger(this.getClass().getName());
    private Class cl = Route.class;
    @Inject
    private RouteDao routeDao;
    @Inject
    private MemberManager memberManager;
    @Inject
    private CountryManager countryManager;

    @Override
    public void addRoute(Route route) {
        route.setName(route.getName().toUpperCase());
        routeDao.add(route);
    }

    @Override
    public Route getRouteById(Integer id) {
        return (Route) routeDao.getById(id);
    }

    @Override
    public Route getRouteByName(String name) {
        return routeDao.getRouteByName(name);
    }

    @Override
    public List<Route> getListRoute() {
        return routeDao.getAll();

    }

    @Override
    public List<String> getListGrade() {
        return routeDao.ListGrade();

    }

    @Override
    public List<String> getListClimbingType() {
        return routeDao.ListClimbingType();

    }

    @Override
    public List<Route> getListRoute(Spot spot, String grade, String type, int height) {
        return routeDao.ListByCriterias(spot, grade, type, height);
    }


    @Override
    public void updateRoute(Route route) {
        logger.info("id from route: " + route.getId());
        int id = route.getId();
        try {
            Route s = (Route) routeDao.getById(id);
            if (!(route.getName() == null)) {
                s.setName(route.getName());
                s.setDescription(route.getDescription());
                s.setHeight(route.getHeight());
                routeDao.update(s);
            } else {
                logger.info("route is null");

            }
        } catch (NullPointerException e) {
            System.err.println("route couldn't be found: " + id);
        }

    }

    @Override
    public void deleteRoute(Route route) {
        logger.info("trying to delete route: " + route.getName());
        routeDao.delete(route);
    }

    @Override
    public void updateWhenDeletingMember(int id) {
        logger.info("trying to update member routes before deleting");
        routeDao.updateWhenDeletingMember(1, id);
    }


}
