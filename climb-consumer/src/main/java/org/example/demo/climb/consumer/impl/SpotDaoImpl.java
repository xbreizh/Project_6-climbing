package org.example.demo.climb.consumer.impl;
import org.example.demo.climb.consumer.contract.MemberDao;
import org.example.demo.climb.consumer.contract.SpotDao;
import org.example.demo.climb.model.bean.Spot;
import org.example.demo.climb.model.bean.member.Member;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class SpotDaoImpl implements SpotDao {

    private Class cl = Spot.class;
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
        return sessionFactory.getCurrentSession().createQuery("from Spot").list();
    }

    @Override
    public Object getById(int id) {
        return(Spot) sessionFactory.getCurrentSession().get(cl, id);
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

        String request= "update Spot set creatorSpot=(select * from Member where id=1) where creatorSpot.id= 2";

        System.out.println("request: "+request);
        Query query = sessionFactory.getCurrentSession().createQuery(request);
        query.setParameter("member1", id1  );
        query.setParameter("member2", id2);
    }


}
