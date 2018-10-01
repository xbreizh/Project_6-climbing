package org.example.demo.climb.consumer.impl;

import org.example.demo.climb.consumer.contract.MemberDao;
import org.example.demo.climb.model.bean.member.Member;
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
    public List getAll() {
        return sessionFactory.getCurrentSession().createQuery("from Member ").list();
    }

    @Override
    public Object getById(int id) {
        return (Member) sessionFactory.getCurrentSession().get(cl, id);
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
