package org.example.demo.climb.consumer.impl;
import org.apache.log4j.Logger;
import org.example.demo.climb.consumer.contract.MemberDao;
import org.example.demo.climb.consumer.contract.RouteDao;
import org.example.demo.climb.model.ClimbingType;
import org.example.demo.climb.model.Grade;
import org.example.demo.climb.model.bean.Route;
import org.example.demo.climb.model.bean.Member;
import org.example.demo.climb.model.bean.Spot;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Named
public class RouteDaoImpl implements RouteDao {
    private Logger logger = Logger.getLogger(this.getClass().getName());
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
        Query query=sessionFactory.getCurrentSession().createQuery("update Route set memberRoute= :member1 where memberRoute.id=:member2");
        query.setParameter("member1", m);
        query.setParameter("member2", id2);
        int result = query.executeUpdate();
        logger.debug("updated list?");
    }

    @Override
    public List<Route> ListByCriterias(Spot spot, String grade, String type, int height) {
        return null; // to do
    }

    @Override
    public List<String> ListGrade() {
        List<Grade> listGrade = Arrays.asList(Grade.values());
        List<String> listGradeString = new ArrayList<>();
        for (Grade grade:listGrade
             ) {
            listGradeString.add(grade.getValue());
        }
        return listGradeString;
    }

    @Override
    public List<String> ListClimbingType(){
        List<ClimbingType> listClimbingType = Arrays.asList(ClimbingType.values());
        List<String> listClimbingTypeString = new ArrayList<>();
        for (ClimbingType ct:listClimbingType
        ) {
            listClimbingTypeString.add(ct.getName());
        }
        return listClimbingTypeString;
    }

    @Override
    public Route getRouteByName(String name) {
        try{
        Query query=sessionFactory.getCurrentSession().createQuery(
                "From Route where name=:name");
        query.setParameter("name", name);
            return (Route) query.getSingleResult();
        }catch(NoResultException e){
            return null;
        }
    }

    @Override
    public Route getRouteById(int id) {
        try{
        Query query=sessionFactory.getCurrentSession().createQuery(
                "From Route where id=:id");
        query.setParameter("id", id);
        return (Route) query.getSingleResult();
        }catch(NoResultException e){
        return null;
        }
    }

}
