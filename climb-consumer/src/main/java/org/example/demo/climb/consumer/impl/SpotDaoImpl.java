package org.example.demo.climb.consumer.impl;
import org.example.demo.climb.consumer.contract.SpotDao;
import org.example.demo.climb.consumer.contract.TransactionBeanSpot;
import org.example.demo.climb.model.bean.Spot;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class SpotDaoImpl implements SpotDao {

    private Class cl = Spot.class;
    private Transaction tx;
    private Session session;
    @Inject
    TransactionBeanSpot transactionBeanSpot;

    @Override
    public void add(Object o) {
        session=transactionBeanSpot.createFactory().openSession();
        tx = session.beginTransaction();
        System.out.println("transaction starting with object: " + o);
        session.saveOrUpdate(cl.getName(), o);
        tx.commit();
        System.out.println("Object has been added!");
    }

    @Override
    public List getAll() {
        session=transactionBeanSpot.createFactory().openSession();
        Query query = session.getNamedQuery("findAllSpots");
        return query.getResultList();
    }

    @Override
    public Object getById(int id) {
        session=transactionBeanSpot.createFactory().openSession();
        tx = session.beginTransaction();
        return session.get(cl, id);
    }

    @Override
    public void update(Object o) {
        /*createSession();*/
        session=transactionBeanSpot.createFactory().openSession();
        tx = session.beginTransaction();
        session.saveOrUpdate(cl.getName(), o);
        tx.commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        session=transactionBeanSpot.createFactory().openSession();
        tx = session.beginTransaction();
        session.remove(session.get(cl, id));
        tx.commit();
        session.close();
        System.out.println("Spot has been deleted!");

    }
}
