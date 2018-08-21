package org.example.demo.ticket.business.impl.manager;


import org.test.app.Alien;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mojo");
        EntityManager em = emf.createEntityManager();

        Alien a = em.find(Alien.class, 4);

        System.out.println(a);


    }
}
