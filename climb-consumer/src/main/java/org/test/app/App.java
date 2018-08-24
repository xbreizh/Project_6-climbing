package org.test.app;


import org.test.app.impl.GestionDAO;

import javax.persistence.EntityManager;

public class App {

    public static void main(String[] args) {
        new App().getEntityManager();


    }

    public void  getEntityManager() {
        GestionDAO gdao = GestionDAO.getInstance();
        EntityManager em = gdao.getEntityManager();

        System.out.println(em.find(Alien.class, 4));
    }


}
