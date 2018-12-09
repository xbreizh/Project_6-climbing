package org.example.demo.climb.consumer.impl;

import org.example.demo.climb.consumer.contract.CommentDao;
import org.example.demo.climb.consumer.contract.MemberDao;
import org.example.demo.climb.model.bean.Comment;
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
        Query query = sessionFactory.getCurrentSession().createQuery("from Comment where route.id=:id order by date desc");
        query.setParameter("id", id);
        return query.getResultList();
    }

    @Override
    public List<Comment> getListCommentBySpot(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Comment where spot.id=:id order by date desc");
        query.setParameter("id", id);
        return query.getResultList();
    }

    @Override
    public void add(Comment comment) {
        System.out.println("comment is in DAO: " + comment.getText());
        System.out.println("date: " + comment.getDate());
        sessionFactory.getCurrentSession().persist(comment);
    }

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

    @Override
    public List<Comment> getAllCommentsSpot() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Comment where spot.id != null order by date desc");
        return query.getResultList();
    }

    @Override
    public List<Comment> getAllCommentsRoute() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Comment where route.id != null order by date desc");
        return query.getResultList();
    }


}
