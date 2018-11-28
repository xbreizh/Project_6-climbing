package org.example.demo.climb.business.impl;
import org.example.demo.climb.business.contract.CountryManager;
import org.example.demo.climb.business.contract.TopoManager;
import org.example.demo.climb.consumer.contract.CountryDao;
import org.example.demo.climb.consumer.contract.SpotDao;
import org.example.demo.climb.consumer.contract.TopoDao;
import org.example.demo.climb.model.bean.Country;
import org.example.demo.climb.model.bean.Spot;
import org.example.demo.climb.model.bean.Topo;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Named("topoManager")
public class TopoManagerImpl implements TopoManager {


    private Class cl= Topo.class;

    @Inject
    private SessionFactory sessionFactory;
    @Inject
    private TopoDao topoDao;
    @Inject
    private SpotDao spotDao;

    @Override
    public List<String> getListTopoByString() {
        return topoDao.ListTopoNames();
    }

    @Override
    public List<Topo> getListTopo() {
        return topoDao.getAll();
    }

    @Override
    public Topo getTopo(String name) {
        return topoDao.getTopoByName(name);
    }

    @Override
    public Topo getTopo(int id) {
        return topoDao.getById(id);
    }

    @Override
    public void addTopo(Topo topo) {
        //make topo available
        topo.setAvailable(true);
        topoDao.add(topo);
    }

    @Override
    public void updateTopo(Topo topo) {

        topoDao.update(topo);

    }

    @Override
    public void deleteTopo(Topo topo) {
        Topo topoToDelete = topoDao.getById(topo.getId());
        topoDao.delete(topoToDelete);
    }

    @Override
    public boolean addSpotToTopo(Spot spot, Topo topo) {
        for ( Spot s: topo.getSpots()
             ) {
            if(s.getId() == spot.getId()){
                return false;
            }
        }
        topo.getSpots().add(spot);
        spot.getTopos().add(topo);
        topoDao.update(topo);
        spotDao.update(spot);
        return true;
    }

    @Override
    public boolean removeSpotFromTopo(Spot spot, Topo topo) {
        List<Spot> spotList = topo.getSpots();
        topo.setSpots(new ArrayList<>());
        System.out.println("list spots mgr: "+spot.getTopos().size());
        System.out.println("list: topos mgr: "+topo.getSpots().size());

        for (Spot s: spotList
             ) {
            if(s.getId() != spot.getId()){
                topo.getSpots().add(s);
            }
        }

        List<Topo> topoList = spot.getTopos();
        spot.setTopos(new ArrayList<>());
        for (Topo t: topoList
        ) {
            if(t.getId() != topo.getId()){
                spot.getTopos().add(t);
            }
        }
        spotDao.update(spot);
        topoDao.update(topo);
        return true;
    }
}
