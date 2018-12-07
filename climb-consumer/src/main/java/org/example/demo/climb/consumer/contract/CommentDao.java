package org.example.demo.climb.consumer.contract;

import org.example.demo.climb.model.bean.Comment;

import java.util.List;

public interface CommentDao {

    List<Comment> getListCommentByRoute(int id);
    List<Comment> getListCommentBySpot(int id);
    void add(Comment comment);
    void update(Comment comment);
    void delete(Comment comment);
    Comment getCommentById(int id);


    List<Comment> getAllCommentsSpot();

    List<Comment> getAllCommentsRoute();
}
