package org.example.demo.climb.business.impl;

import org.example.demo.climb.business.contract.CommentManager;
import org.example.demo.climb.consumer.contract.CommentDao;
import org.example.demo.climb.model.bean.Comment;
import org.example.demo.climb.model.bean.__to_delete.Zone;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Date;
import java.util.List;

@Transactional
@Named("commentManager")
public class CommentManagerImpl  implements CommentManager {


    private Class cl= Zone.class;

    @Inject
    private SessionFactory sessionFactory;
    @Inject
    private CommentDao commentDao;


    @Override
    public void addComment(Comment comment) {
        Date date = new Date();
        System.out.println("date now: "+date);
        comment.setDate(date);
        commentDao.add(comment);
    }

    @Override
    public List<Comment> getListCommentFromRoute(int id) {
        return commentDao.getListCommentByRoute(id);
    }

    @Override
    public List<Comment> getListCommentFromSpot(int id) {
        return commentDao.getListCommentBySpot(id);
    }


    @Override
    public void updateComment(Comment comment) {
        Comment c = commentDao.getCommentById(comment.getId());

        commentDao.update(c);


    }

    @Override
    public void deleteComment(int id) {
        Comment comment = commentDao.getCommentById(id);

        commentDao.delete(comment);
    }
}
