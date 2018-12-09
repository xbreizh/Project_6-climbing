package org.example.demo.climb.consumer.impl;

import org.apache.log4j.Logger;
import org.example.demo.climb.consumer.contract.MemberDao;
import org.example.demo.climb.consumer.contract.TopoDao;
import org.example.demo.climb.model.bean.Topo;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class TopoDaoImpl implements TopoDao {
    private Logger logger = Logger.getLogger(this.getClass().getName());
    private Class cl = Topo.class;
    @Inject
    private SessionFactory sessionFactory;
    @Inject
    private MemberDao memberDao;


    @Override
    public void updateWhenDeletingMember(int id1, int id2) {

    }

    @Override
    public Topo getTopoByName(String name) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "From Topo where name=:name");
        query.setParameter("name", name);
        return (Topo) query.getResultList();
    }

    @Override
    public List<Topo> ListTopoByOwner(String name) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "From Topo where owner.login=:name order by available, name, publishedYear");
        query.setParameter("login", name);
        return query.getResultList();
    }

    @Override
    public List<String> ListTopoNames() {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "select distinct(name) From Topo");
        return query.getResultList();
    }

    @Override
    public void update(Topo topo) {
        logger.info("trying to update: " + topo.getName());
        logger.info("list: " + topo.getSpots().size());
        sessionFactory.getCurrentSession().update(cl.getName(), topo);
    }

    @Override
    public void delete(Topo topo) {
        sessionFactory.getCurrentSession().delete(cl.getName(), topo);
    }

    @Override
    public List<Topo> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from Topo").list();
    }

    @Override
    public Topo getById(int id) {
        return (Topo) sessionFactory.getCurrentSession().get(cl, id);
    }

    @Override
    public void add(Topo topo) {
        sessionFactory.getCurrentSession().persist(cl.getName(), topo);
    }
}
