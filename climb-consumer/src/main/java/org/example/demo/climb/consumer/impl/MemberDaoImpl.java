package org.example.demo.climb.consumer.impl;

import org.example.demo.climb.consumer.contract.Dao;
import org.example.demo.climb.consumer.contract.MemberDao;
import org.example.demo.climb.model.bean.member.Member;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class MemberDaoImpl  /*implements MemberDao*/ {

   /* *//*@Inject
    TransactionManager transactionManager;*//*
    private Class cl = Member.class;
    private Transaction tx;
   *//* private SessionFactory sf;
    private Session session;*//*
   *//* @Inject
    createConfigMember sess;*//*
   *//* @Autowired
    private SessionFactory sess;*//*





    @Override
    public void add(Object o) {
        *//* createSession();*//*
        *//*session= transactionBeanMember.createFactory().openSession();*//*
        *//*getSession();*//*
        tx = sess.getCurrentSession().beginTransaction();
        System.out.println("transaction starting with object: " + o);
        sess.getSession().saveOrUpdate(cl.getName(), o);
        tx.commit();
        System.out.println("Object added!");
    }

    @Override
    public List getAll() {
        *//*createSession();*//*
        System.out.println("creation de la transaction");


        *//*session= transactionBeanMember.createFactory().openSession();*//*
        *//*getSession();*//*
        System.out.println("Session: "+sess.getSession().toString());
        *//*tx = session.beginTransaction();*//*
        Query query = sess.getSession().getNamedQuery("findAllMembers");
        return query.getResultList();

    }


    @Override
    public Object getById(int id) {
        *//*createSession();*//*
        *//*session= transactionBeanMember.createFactory().openSession();*//*
      *//*  getSession();*//*
        tx = sess.getSession().beginTransaction();
        return sess.getSession().get(cl, id);
    }

    @Override
    public void update(Object o) {
        *//*createSession();*//*
        *//*session= transactionBeanMember.createFactory().openSession();*//*
      *//*  getSession();*//*
        tx = sess.getSession().beginTransaction();
        sess.getSession().saveOrUpdate(cl.getName(), o);
        tx.commit();
        sess.getSession().close();
        System.out.println("Update done!");
    }

    @Override
    @Transactional
    public void delete(int id) {
       *//* createSession();*//*
        *//*session= transactionBeanMember.createFactory().openSession();*//*
       *//* getSession();*//*
        *//*tx = sess.getSession().beginTransaction();*//*
        sess.getSession().remove(sess.getSession().get(cl, id));
       *//* tx.commit();
        sess.getSession().close();*//*
    }*/
}
