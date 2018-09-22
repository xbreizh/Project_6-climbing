package org.example.demo.climb.business.contract.manager;

import org.example.demo.climb.model.bean.member.Member;
import org.example.demo.climb.model.exception.NotFoundException;

import java.util.List;


/**
 * Manager du package « utilisateur »
 */
public interface MemberManager  {

    //Get list
    List<Member> getListMember();

    //Create

    void addMember(Member member);

    //Read
    Member getMember(Integer pId) throws NotFoundException;

    Member getMember(String pLogin) throws NotFoundException;
    Member getMember() throws NotFoundException;

    //Update

    void updateMember(Member member);

    //Delete

    void deleteMember(int id);

    //Connect

    boolean connect(String login, String password);

    //Disconnect

    boolean disconnect(String login);

    // Check if existing

    boolean exists(String login);

    boolean updatePassword(String login, String password);


}
