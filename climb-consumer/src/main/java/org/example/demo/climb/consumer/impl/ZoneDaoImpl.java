package org.example.demo.climb.consumer.impl;

import org.example.demo.climb.consumer.contract.ZoneDao;
import org.example.demo.climb.model.bean.Zone;
import org.hibernate.SessionFactory;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class ZoneDaoImpl implements ZoneDao {

    private Class cl= Zone.class;

    @Inject
    private SessionFactory sessionFactory;

    @Override
    public void add(Object o) {
        sessionFactory.getCurrentSession().persist(o);
    }

    @Override
    public List getAll() {
        return sessionFactory.getCurrentSession().createQuery("from Zone ").list();
    }

    @Override
    public Object getById(int id) {
        return (Zone) sessionFactory.getCurrentSession().get(cl, id);
    }

    @Override
    public void update(Object o) {
        sessionFactory.getCurrentSession().update(o);
    }

    @Override
    public void delete(Object o) {
        sessionFactory.getCurrentSession().delete(cl.getName(), o);
    }
}
