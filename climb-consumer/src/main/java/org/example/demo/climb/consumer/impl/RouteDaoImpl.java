package org.example.demo.climb.consumer.impl;
import org.example.demo.climb.consumer.contract.MemberDao;
import org.example.demo.climb.consumer.contract.RouteDao;
import org.example.demo.climb.model.bean.Route;
import org.example.demo.climb.model.bean.Route;
import org.example.demo.climb.model.bean.member.Member;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class RouteDaoImpl implements RouteDao {

    private Class cl = Route.class;
    @Inject
    private SessionFactory sessionFactory;
    @Inject
    private MemberDao memberDao;

    @Override
    public void add(Object o) {
        sessionFactory.getCurrentSession().persist(o);
    }

    @Override
    public List getAll() {
        return sessionFactory.getCurrentSession().createQuery("from Route").list();
    }

    @Override
    public Object getById(int id) {
        return(Route) sessionFactory.getCurrentSession().get(cl, id);
    }

    @Override
    public void update(Object o) {
        sessionFactory.getCurrentSession().update(o);
    }

    @Override
    public void delete(Object o) {
        sessionFactory.getCurrentSession().delete(cl.getName(), o);
    }


    @Override
    public void updateWhenDeletingMember(int id1, int id2){
        Member m = (Member) memberDao.getById(id1);
        Query query=sessionFactory.getCurrentSession().createQuery("update Route set creatorRoute= :member1 where creatorRoute.id=:member2");
        query.setParameter("member1", m);
        query.setParameter("member2", id2);
        int result = query.executeUpdate();
        System.out.println("updated list?");
    }


}
