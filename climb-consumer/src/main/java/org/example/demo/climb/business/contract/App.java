package org.example.demo.climb.business.contract;


import org.example.demo.climb.model.bean.Zone;


public class App {

    public static void main(String[] args) {

        ZoneDaoImpl dao = new ZoneDaoImpl();

        Zone zone = new Zone();
        zone.setId(44);
        zone.setName("frfrfr");
        zone.setCountry("Germany");
        zone.setRegion("frfrf");
        zone.setType("varappe");

        /*dao.delete(44);*/
        Zone z = (Zone) dao.findOne(33);
        dao.delete(z);


    }


}