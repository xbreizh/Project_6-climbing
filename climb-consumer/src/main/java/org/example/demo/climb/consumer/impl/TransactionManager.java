package org.example.demo.climb.consumer.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.inject.Named;

@Named
public class TransactionManager {
    private Class cl;

    public TransactionManager() {
    }

    public Class getCl() {
        return cl;
    }

    public void setCl(Class cl) {
        this.cl = cl;
    }

    public Session createTransaction() {
        Configuration conf = new Configuration().configure().addAnnotatedClass(cl);

        SessionFactory sf = conf.buildSessionFactory();

        return sf.openSession();
    }
}
