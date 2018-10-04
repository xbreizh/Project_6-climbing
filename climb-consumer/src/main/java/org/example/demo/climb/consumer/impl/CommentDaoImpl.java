package org.example.demo.climb.consumer.impl;
import org.example.demo.climb.consumer.contract.CommentDao;
import org.example.demo.climb.consumer.contract.MemberDao;
import org.example.demo.climb.consumer.contract.CommentDao;
import org.example.demo.climb.model.bean.Comment;
import org.example.demo.climb.model.bean.Comment;
import org.example.demo.climb.model.bean.member.Member;
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
    public void add(Object o) {
        sessionFactory.getCurrentSession().persist(o);
    }

    @Override
    public List getAll() {
        return sessionFactory.getCurrentSession().createQuery("from Comment").list();
    }

    @Override
    public Object getById(int id) {
        return(Comment) sessionFactory.getCurrentSession().get(cl, id);
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
        Query query=sessionFactory.getCurrentSession().createQuery("update Comment set creatorComment= :member1 where creatorComment.id=:member2");
        query.setParameter("member1", m);
        query.setParameter("member2", id2);
        int result = query.executeUpdate();
        System.out.println("updated list?");
    }


}
