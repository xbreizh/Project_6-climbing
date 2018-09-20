package org.example.demo.climb.consumer.impl;

import org.example.demo.climb.consumer.contract.Dao;
import org.example.demo.climb.consumer.contract.MemberDao;
import org.example.demo.climb.model.bean.member.Member;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class MemberDaoImpl implements MemberDao {

    /*@Inject
    TransactionManager transactionManager;*/
    private Class cl = Member.class;
    private Transaction tx;
    private SessionFactory sf;
    private Session session;

    private Session getSession() {
        if(this.sf==null) {
            System.out.println("creation of session factory");
            Configuration conf = new Configuration().configure().addAnnotatedClass(Member.class);
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
        /* createSession();*/
        /*session= transactionBeanMember.createFactory().openSession();*/
        getSession();
        tx = session.beginTransaction();
        System.out.println("transaction starting with object: " + o);
        session.saveOrUpdate(cl.getName(), o);
        tx.commit();
        System.out.println("Object added!");
    }

    @Override
    public List getAll() {
        /*createSession();*/
        System.out.println("creation de la transaction");


        /*session= transactionBeanMember.createFactory().openSession();*/
        getSession();
        System.out.println("Session: "+session.toString());
        /*tx = session.beginTransaction();*/
        Query query = session.getNamedQuery("findAllMembers");
        return query.getResultList();

    }


    @Override
    public Object getById(int id) {
        /*createSession();*/
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
        System.out.println("Update done!");
    }

    @Override
    public void delete(int id) {
       /* createSession();*/
        /*session= transactionBeanMember.createFactory().openSession();*/
        getSession();
        tx = session.beginTransaction();
        session.remove(session.get(cl, id));
        tx.commit();
        session.close();
    }
}