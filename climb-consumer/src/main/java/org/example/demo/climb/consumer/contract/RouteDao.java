package org.example.demo.climb.consumer.contract;

import org.example.demo.climb.model.bean.Route;
import org.example.demo.climb.model.bean.Spot;

import java.util.List;

public interface RouteDao extends Dao {

    public void updateWhenDeletingMember(int id1, int id2);
    List<Route> ListByCriterias(Spot spot, String grade, String type, int height );

}
