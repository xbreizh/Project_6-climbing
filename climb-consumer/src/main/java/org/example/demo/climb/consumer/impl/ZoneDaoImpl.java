package org.example.demo.climb.consumer.impl;
import org.example.demo.climb.consumer.contract.Dao;
import org.example.demo.climb.consumer.contract.ZoneDao;
import org.example.demo.climb.model.bean.Spot;
import org.example.demo.climb.model.bean.Zone;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class ZoneDaoImpl implements ZoneDao {

    private Class cl = Zone.class;
    private Transaction tx;
    private Session session;
    private SessionFactory sf;

    private Session getSession() {
        if(this.sf==null) {
            System.out.println("creation of session factory");
            Configuration conf = new Configuration().configure().addAnnotatedClass(Zone.class);
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
        System.out.println("Zone has been added!");

    }

    @Override
    public List getAll() {
        /*session= transactionBeanMember.createFactory().openSession();*/
        getSession();
        Query query = session.getNamedQuery("findAllZones");
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
        System.out.println("trying to update");
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
        System.out.println("Zone has been deleted!");

    }
}
