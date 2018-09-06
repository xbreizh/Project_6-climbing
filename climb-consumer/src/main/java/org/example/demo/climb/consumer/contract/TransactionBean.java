package org.example.demo.climb.consumer.contract;

import org.example.demo.climb.model.bean.climb.Spot;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Named;

@Transactional
@Named
public class TransactionBean {

    public Transaction openTransaction() {
        Configuration conf = new Configuration().configure().addAnnotatedClass(Spot.class);

        SessionFactory sf = conf.buildSessionFactory();


        Session session = sf.openSession();
        return session.getTransaction();
    }


}
