package org.example.demo.climb.consumer.contract;

import org.example.demo.climb.model.bean.Comment;

import java.util.List;

public interface CommentDao {

    /*void updateWhenDeletingMember(int id1, int id2);*/
  /*  List<Comment> getAllRouteComment(int id);
    List<Comment> getAllSpotComment(int id);*/
    void add(Comment comment);
    void update(Object o);
    void delete(Object o);


}
