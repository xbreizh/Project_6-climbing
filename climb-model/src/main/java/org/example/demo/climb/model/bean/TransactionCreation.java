package org.example.demo.climb.model.bean;

import org.example.demo.climb.model.bean.member.Member;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.inject.Named;


@Named
public class TransactionCreation {

    public Transaction getTransaction(Object object) {
        object = Member.class;
        Configuration conf = new Configuration().configure().addAnnotatedClass(Object.class);
        SessionFactory sf = conf.buildSessionFactory();

        Session session = sf.openSession();
        Transaction tx = session.getTransaction();

        return tx;
    }
}
