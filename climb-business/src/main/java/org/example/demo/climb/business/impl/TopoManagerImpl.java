package org.example.demo.climb.business.impl;
import org.example.demo.climb.business.contract.CountryManager;
import org.example.demo.climb.business.contract.TopoManager;
import org.example.demo.climb.consumer.contract.CountryDao;
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
      /*  Topo topoToUpdate = topoDao.getById(topo.getId());
        topoToUpdate.setName(topo.getName());
        topoToUpdate.setAvailable(topo.isAvailable());
        topoToUpdate.setKeywords(topo.getKeywords());
        topoToUpdate.setAuthor(topo.getAuthor());
        topoToUpdate.setEdition(topo.getEdition());
        for (Spot s: topo.getListSpot()
             ) {
            topoToUpdate.getListSpot().add(s);
        }*/
     /* if(topo.getSpotList().size()>0){
          System.out.println("spot List: "+topo.getSpotList().get(0));
      }*/
        System.out.println("updating topo from manager");
        /*topoDao.update(topoToUpdate);*/
        topoDao.update(topo);
    }

    @Override
    public void deleteTopo(Topo topo) {
        Topo topoToDelete = topoDao.getById(topo.getId());

        topoDao.delete(topoToDelete);
    }
}
