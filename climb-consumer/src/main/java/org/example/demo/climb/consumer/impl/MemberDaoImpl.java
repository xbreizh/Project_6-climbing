package org.example.demo.climb.consumer.impl;

import org.example.demo.climb.consumer.contract.MemberDao;
import org.example.demo.climb.consumer.contract.TransactionBeanMember;
import org.example.demo.climb.model.bean.member.Member;
import org.hibernate.Session;
import org.hibernate.Transaction;
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
    private Session session;
    @Inject
    TransactionBeanMember transactionBeanMember;

   /* private void createSession() {
        Configuration conf = new Configuration().configure().addAnnotatedClass(cl);
        SessionFactory sf = conf.buildSessionFactory();
        session = sf.openSession();
    }*/


    @Override
    public void add(Object o) {
        /* createSession();*/
        session= transactionBeanMember.createFactory().openSession();
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
        System.out.println("Transaction manager: "+transactionBeanMember.toString());

        session= transactionBeanMember.createFactory().openSession();
        System.out.println("Session: "+session.toString());
        /*tx = session.beginTransaction();*/
        Query query = session.getNamedQuery("findAllMembers");
        return query.getResultList();

    }


    @Override
    public Object getById(int id) {
        /*createSession();*/
        session= transactionBeanMember.createFactory().openSession();
        tx = session.beginTransaction();
        return session.get(cl, id);
    }

    @Override
    public void update(Object o) {
        /*createSession();*/
        session= transactionBeanMember.createFactory().openSession();
        tx = session.beginTransaction();
        session.saveOrUpdate(cl.getName(), o);
        tx.commit();
        session.close();
        System.out.println("Update done!");
    }

    @Override
    public void delete(int id) {
       /* createSession();*/
        session= transactionBeanMember.createFactory().openSession();
        tx = session.beginTransaction();
        session.remove(session.get(cl, id));
        tx.commit();
        session.close();
    }
}
