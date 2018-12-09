package org.example.demo.climb.business.impl;

import org.apache.log4j.Logger;
import org.example.demo.climb.business.contract.SearchManager;
import org.example.demo.climb.consumer.contract.SearchDao;
import org.example.demo.climb.model.bean.Spot;
import org.example.demo.climb.model.bean.Topo;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Transactional(readOnly = true)
@Named("searchManager")
public class SearchManagerImpl implements SearchManager {


    private Logger logger = Logger.getLogger(this.getClass().getName());
    @Inject
    private SearchDao searchDao;

    @Override
    public List<Spot> findSpotByString(String str) {
        List<Spot> list = searchDao.findListSpotByString(str);
        String rep = "<font color=\"red\">" + str + "</font>";
        for (Spot spot : list
        ) {
            spot.setName(spot.getName().replaceAll("(?i)" + str, rep));
            spot.setCity(spot.getCity().replaceAll("(?i)" + str, rep));
            spot.setDescription(spot.getDescription().replaceAll("(?i)" + str, rep));
            spot.getCountry().setName(spot.getCountry().getName().replaceAll("(?i)" + str, rep));
            spot.getCountry().setContinent(spot.getCountry().getContinent().replaceAll("(?i)" + str, rep));
        }
        return list;
    }


    @Override
    public List<Topo> findTopoByString(String str) {
        List<Topo> list = searchDao.findListTopoByString(str);
        String rep = "<font color=\"red\">" + str + "</font>";
        for (Topo topo : list
        ) {
            topo.setName(topo.getName().replaceAll("(?i)" + str, rep));
            topo.setDescription(topo.getDescription().replaceAll("(?i)" + str, rep));
        }
        return list;
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
