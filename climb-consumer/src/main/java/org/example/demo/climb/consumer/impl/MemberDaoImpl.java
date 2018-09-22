package org.example.demo.climb.consumer.impl;

import javax.inject.Named;

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
