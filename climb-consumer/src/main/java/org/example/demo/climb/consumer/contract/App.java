package org.example.demo.climb.consumer.contract;


public class App {

    public static void main(String[] args) {
       /* Configuration conf = new Configuration().configure().addAnnotatedClass(Zone.class);

        SessionFactory sf = conf.buildSessionFactory();
       Session session = sf.openSession();


        *//*Session session = sf.openSession();*//*
         *//*session.beginTransaction();*//*

         *//* ZoneDaoImpl dao = new ZoneDaoImpl();*//*

        Zone zone = new Zone();
        zone.setId(4444554);
        zone.setName("frfrfr");
        zone.setCountry("Germany");
        zone.setRegion("frfrf");
        zone.setType("varappe");

        Transaction tx =session.beginTransaction();
        Zone z=session.get(Zone.class, zone.getId());
        System.out.println(z);*/
        DaoImpl dao = new DaoImpl();
        /* System.out.println(dao.findAll());*/
    }


}