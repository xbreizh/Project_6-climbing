package org.example.demo.climb.consumer.contract;

import org.example.demo.climb.consumer.impl.TransactionManager;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class DaoImpl implements Dao {

    @Inject
    TransactionManager transactionManager;
    private Class cl = null;
    private Transaction tx;
    private Session session;


    @Override
    public void setCl(Class cl) {
        this.cl = cl;

    }

    @Override
    public List getAll() {
        /*System.out.println("class: "+cl.getName());*/
        transactionManager.setCl(cl);
        session = transactionManager.createTransaction();
        tx = session.beginTransaction();
        return session.createQuery("from " + cl.getName()).list();


    }

    @Override
    public void add(Object o) {
        transactionManager.setCl(cl);
        session = transactionManager.createTransaction();
        tx = session.beginTransaction();
        System.out.println("transaction starting with object: " + o);
        session.saveOrUpdate(cl.getName(), o);
        tx.commit();
        System.out.println("Object added!");

    }

    @Override
    public Object getById(int id) {
        transactionManager.setCl(cl);
        session = transactionManager.createTransaction();
        tx = session.beginTransaction();
        return session.get(cl, id);
    }

    @Override
    public void delete(int id) {
        transactionManager.setCl(cl);
        session = transactionManager.createTransaction();
        tx = session.beginTransaction();
        session.remove(session.get(cl, id));
        tx.commit();
    }

    @Override
    public void update(Object o) {
        transactionManager.setCl(cl);
        session = transactionManager.createTransaction();
        tx = session.beginTransaction();
        session.saveOrUpdate(cl.getName(), o);
        tx.commit();

    }
}
