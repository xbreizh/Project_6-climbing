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

        System.out.println("date: "+comment.getDate());
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
    public List<Comment> getListCommentsSpot() {
        return commentDao.getAllCommentsSpot();
    }

    @Override
    public List<Comment> getListCommentsRoute() {
        return commentDao.getAllCommentsRoute();
    }

    @Override
    public Comment getComment(int id) {
        return commentDao.getCommentById(id);
    }


    @Override
    public void updateComment(Comment comment) {
        Comment c = commentDao.getCommentById(comment.getId());

        commentDao.update(c);


    }

    @Override
    public void deleteComment(Comment comment) {
        System.out.println("comment received in manager: "+comment);
        commentDao.delete(comment);
       /* if(
        commentDao.getCommentById(id) != null){

            commentDao.delete(commentDao.getCommentById(id));
        }else{
            System.out.println("comment cannot be found: "+id);
        }*/
    }
}
