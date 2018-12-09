package org.example.demo.climb.business.impl;

import org.apache.log4j.Logger;
import org.example.demo.climb.business.contract.CommentManager;
import org.example.demo.climb.business.contract.RouteManager;
import org.example.demo.climb.consumer.contract.CommentDao;
import org.example.demo.climb.model.bean.Comment;
import org.example.demo.climb.model.exception.NotFoundException;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Transactional
@Named("commentManager")
public class CommentManagerImpl implements CommentManager {
    private Logger logger = Logger.getLogger(this.getClass().getName());


    @Inject
    private CommentDao commentDao;
    @Inject
    private RouteManager routeManager;


    @Override
    public void addComment(Comment comment) {

        logger.info("comment  to be added(manager): "+comment);


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
        logger.info("comment received in manager: " + comment);
        commentDao.delete(comment);
    }
}
