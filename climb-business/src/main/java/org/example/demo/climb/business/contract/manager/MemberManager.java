package org.example.demo.climb.business.contract.manager;

import org.example.demo.climb.model.bean.Member;
import org.example.demo.climb.model.exception.NotFoundException;

import java.util.List;


/**
 * Manager du package « utilisateur »
 */
public interface MemberManager {

    //Get list
    List<Member> getListMember();

    //Create

    boolean addMember(Member member);

    //Read
    Member getMember(Integer pId) throws NotFoundException;

    Member getMember(String pLogin) throws NotFoundException;

    //Update

    boolean updateMember(Member member);

    //Delete

    boolean deleteMember(int id);

    //Connect

    boolean connect(String login, String password);

    //Disconnect

    boolean disconnect(String login);
}
