package org.example.demo.climb.consumer.contract;

import org.example.demo.climb.model.bean.Member;

public interface CommentDao extends Dao {

    void updateWhenDeletingMember(int id1, int id2);


}
