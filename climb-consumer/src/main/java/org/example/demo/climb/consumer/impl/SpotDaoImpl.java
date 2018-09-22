package org.example.demo.climb.consumer.impl;
import org.example.demo.climb.consumer.contract.SpotDao;
import org.example.demo.climb.model.bean.Spot;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.inject.Named;
import java.util.List;

@Named
public class SpotDaoImpl implements SpotDao {

    private Class cl = Spot.class;
    private Transaction tx;
    private Session session;
    private SessionFactory sf;

    private Session getSession() {
        if(this.sf==null) {
            System.out.println("creation of session factory");
            Configuration conf = new Configuration().configure().addAnnotatedClass(Spot.class);
            this.sf = conf.buildSessionFactory();
            System.out.println("creation session and opening");
            return this.session = this.sf.openSession();
        }else {
            System.out.println("creation session and opening");
            return this.session = this.sf.openSession();
        }/*else{
            System.out.println("getting current session");
            return   this.session = this.sf.getCurrentSession();
        }*/
    }

    @Override
    public void add(Object o) {
        /*session= transactionBeanMember.createFactory().openSession();*/
        getSession();
        tx = session.beginTransaction();
        System.out.println("transaction starting with object: " + o);
        session.saveOrUpdate(cl.getName(), o);
        tx.commit();
        System.out.println("Object has been added!");
    }

    @Override
    public List getAll() {
        /*session= transactionBeanMember.createFactory().openSession();*/
        getSession();
        Query query = session.getNamedQuery("findAllSpots");
        return query.getResultList();
    }

    @Override
    public Object getById(int id) {
        /*session= transactionBeanMember.createFactory().openSession();*/
        getSession();
        tx = session.beginTransaction();
        return session.get(cl, id);
    }

    @Override
    public void update(Object o) {
        /*createSession();*/
        /*session= transactionBeanMember.createFactory().openSession();*/
        getSession();
        tx = session.beginTransaction();
        session.saveOrUpdate(cl.getName(), o);
        tx.commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        /*session= transactionBeanMember.createFactory().openSession();*/
        getSession();
        tx = session.beginTransaction();
        session.remove(session.get(cl, id));
        tx.commit();
        session.close();
        System.out.println("Spot has been deleted!");

    }
}
