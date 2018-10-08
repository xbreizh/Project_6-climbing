package org.example.demo.climb.consumer.impl;

import org.example.demo.climb.consumer.contract.MemberDao;
import org.example.demo.climb.model.bean.Member;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class MemberDaoImpl  implements MemberDao {

    private Class cl=Member.class;
    @Inject
    private SessionFactory sessionFactory;



    @Override
    public void add(Object o) {
        sessionFactory.getCurrentSession().persist(o);
    }

    @Override
    public Object getById(int id) {
        /*Query query = sessionFactory.getCurrentSession().createQuery(
                "From Member where id=:id");
        query.setParameter("id", id);
        return query.getSingleResult();*/
        return sessionFactory.getCurrentSession().get(cl, id);
        /*return (Member) sessionFactory.getCurrentSession().get(cl, id);*/
    }

    @Override
    public Member getMemberByLogin(String name) {
        Query query = sessionFactory.getCurrentSession().createQuery("" +
                "From Member where login=:name");
        query.setParameter("name", name);
        return (Member) query.getSingleResult();
    }

    @Override
    public List getAll() {
        return sessionFactory.getCurrentSession().createQuery("from Member ").list();
    }

    @Override
    public void update(Object o) {
        sessionFactory.getCurrentSession().update(o);
    }

    @Override
    public void delete(Object o) {
        Member m = (Member) o;
        sessionFactory.getCurrentSession().delete(cl.getName(), m);
    }
}
