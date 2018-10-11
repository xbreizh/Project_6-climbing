package org.example.demo.climb.consumer.impl;
import org.example.demo.climb.consumer.contract.CommentDao;
import org.example.demo.climb.consumer.contract.MemberDao;
import org.example.demo.climb.model.bean.Comment;
import org.example.demo.climb.model.bean.Member;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class CommentDaoImpl implements CommentDao {

    private Class cl = Comment.class;
    @Inject
    private SessionFactory sessionFactory;
    @Inject
    private MemberDao memberDao;

    @Override
    public List<Comment> getListCommentByRoute(int id) {
        Query query=sessionFactory.getCurrentSession().createQuery("from Comment where route.id=:id order by date desc");
        query.setParameter("id", id);
        return query.getResultList();
    }

    @Override
    public void add(Comment comment) {
        sessionFactory.getCurrentSession().persist(comment);
    }

   /* @Override
    public List<Comment> getAllRouteComment(int id) {
        Query query=sessionFactory.getCurrentSession().createQuery("from Comment where route.id=:id");
        query.setParameter("id", id);
        return query.getResultList();
    }

    @Override
    public List<Comment> getAllSpotComment(int id) {
        Query query=sessionFactory.getCurrentSession().createQuery("from Comment where spot.id=:id");
        query.setParameter("id", id);
        return query.getResultList();
    }*/
/*
    @Override
    public Object getById(int id) {
        return(Comment) sessionFactory.getCurrentSession().get(cl, id);
    }
*/
    @Override
    public void update(Comment comment) {
        sessionFactory.getCurrentSession().update(comment);
    }

    @Override
    public void delete(Comment comment) {
        sessionFactory.getCurrentSession().delete(cl.getName(), comment);
    }

    @Override
    public Comment getCommentById(int id) {
        return (Comment) sessionFactory.getCurrentSession().get(cl, id);
    }


   /* @Override
    public void updateWhenDeletingMember(int id1, int id2){
        Member m = (Member) memberDao.getById(id1);
        Query query=sessionFactory.getCurrentSession().createQuery("update Comment set member= :member1 where member.id=:member2");
        query.setParameter("member1", m);
        query.setParameter("member2", id2);
        int result = query.executeUpdate();
        System.out.println("updated list?");
    }*/


}
