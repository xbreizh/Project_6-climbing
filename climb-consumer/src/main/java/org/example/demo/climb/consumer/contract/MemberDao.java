package org.example.demo.climb.consumer.contract;


import org.example.demo.climb.model.bean.Member;

public interface MemberDao extends Dao {

    Member getMemberByLogin(String name);




}
