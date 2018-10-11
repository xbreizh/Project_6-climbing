package org.example.demo.climb.business.contract.manager;


import org.example.demo.climb.model.bean.Comment;
import org.example.demo.climb.model.bean.Spot;
import org.example.demo.climb.model.exception.NotFoundException;

import java.util.List;

/**
 * Manager du package « utilisateur »
 */
public interface CommentManager {

    // Create
    void addComment(Comment comment);

   /* // Get
    Comment getCommentByName(String name) throws NotFoundException;*/

    List<Comment> getListCommentFromRoute(int id);

    /*//Get list
    Comment getCommentById(Integer pId) throws NotFoundException;*/

    /*List<Comment> getListComment(Spot spot, String grade, String type, int height);*/

    //Update
    void updateComment(Comment comment);

    //Delete
    void deleteComment(int id);

    /*//Update on delete
    void updateWhenDeletingMember(int id);
    List<String> getListGrade();
    List<String> getListClimbingType();*/


}
