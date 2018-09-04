package org.example.demo.climb.business.contract;


import org.example.demo.climb.model.bean.member.Member;

import java.util.List;

public interface MemberDao {

    //CREATE

    void addMember(Member member);

    //READ
    Member getmemberById(int id);

    Member getMemberByLogin(String name);

    List<Member> getMemberList();

    //UPDATE

    boolean updateMember(Member member);

    //DELETE

    boolean deleteMember(int id);

    boolean connect(String login, String password);


}
