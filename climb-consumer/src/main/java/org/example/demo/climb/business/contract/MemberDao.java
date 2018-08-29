package org.example.demo.climb.business.contract;


import org.example.demo.climb.model.bean.Member;

import java.util.List;

public interface MemberDao {

    //CREATE

    void addMember(Member member);

    //READ
    Member getmemberById(int i);

    Member getMemberByLogin(String name);

    List<Member> getMemberList();

    //UPDATE

    boolean updateMember(Member member);

    //DELETE

    boolean deleteMember(int i);

    boolean connect(String login, String password);


}
