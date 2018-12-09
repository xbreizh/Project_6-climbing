package org.example.demo.climb.consumer.impl;

import org.apache.log4j.Logger;
import org.example.demo.climb.consumer.contract.MemberDao;
import org.example.demo.climb.model.bean.Member;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class MemberDaoImpl implements MemberDao {
    private Logger logger = Logger.getLogger(this.getClass().getName());
    private Class cl = Member.class;
    @Inject
    private SessionFactory sessionFactory;


    // Create
    @Override
    public void add(Object o) {
        sessionFactory.getCurrentSession().persist(o);
    }

    // Read One by Id
    @Override
    public Object getById(int id) {
        return sessionFactory.getCurrentSession().get(cl, id);
    }

    // Read One by Login
    @Override
    public Member getMemberByLogin(String login) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "From Member where login=:login");
        query.setParameter("login", login);
        return (Member) query.getSingleResult();
    }

    // Read All
    @Override
    public List getAll() {
        return sessionFactory.getCurrentSession().createQuery("from Member ").list();
    }

    // Update
    @Override
    public void update(Object o) {
        sessionFactory.getCurrentSession().update(cl.getName(), o);
    }

    // Delete
    @Override
    public void delete(Object o) {
        Member m = (Member) o;
        logger.info("member received to be deleted: " + m);
        sessionFactory.getCurrentSession().delete(cl.getName(), m);
    }
}
