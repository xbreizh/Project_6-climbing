package org.example.demo.climb.business.impl;

import org.example.demo.climb.business.contract.SearchManager;
import org.example.demo.climb.consumer.contract.SearchDao;
import org.example.demo.climb.model.bean.Spot;
import org.example.demo.climb.model.bean.Topo;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Transactional
@Named("searchManager")
public class SearchManagerImpl implements SearchManager {


   /* @Inject
    private SessionFactory sessionFactory;*/
    @Inject
    private SearchDao searchDao;

    @Transactional(readOnly = true)
    @Override
    public List<Spot> findSpotByString(String str) {
        List<Spot> list =  searchDao.findListSpotByString(str);
        for (Spot spot: list
             ) {
                spot.setName(spot.getName().replace(str, "<strong>" + str + "</strong>"));

        }
        return list;
    }


    @Override
    public List<Topo> findTopoByString(String str) {
        return searchDao.findListTopoByString(str);
    }

    @Override
    public List<Spot> findSpotByCriterias(ArrayList<String> list) {
        return searchDao.findListSpotByCriterias(list);
    }

    @Override
    public List<Topo> findTopoByCriterias(ArrayList<String> list) {
        return searchDao.findListTopoByCriterias(list);
    }
}
