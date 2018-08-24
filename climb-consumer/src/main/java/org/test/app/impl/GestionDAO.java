package org.test.app.impl;



import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Named
public class GestionDAO {




    private static GestionDAO instance;

    private  static EntityManagerFactory emf=null;

    private static EntityManager entityManager=null;

    private static final String conf="mojo";

    public static GestionDAO getInstance() {
        if (instance == null) {
            instance = new GestionDAO();
            emf=Persistence.createEntityManagerFactory(conf);
            entityManager=emf.createEntityManager();

        }

        return instance;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }



}
