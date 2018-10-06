package org.example.demo.climb.business.contract.manager;

import org.example.demo.climb.model.bean.Member;
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

    //Get
    Member getMember();
    Member getMemberById(Integer id) throws NotFoundException;

    Member getMemberByLogin(String login) throws NotFoundException;
    /*Member getMember() throws NotFoundException;*/

    //Update

    void updateMember(Member member);

    //Delete

    void deleteMember(int id);

    // Check if exists
    boolean exists(String login);

    //Connect

    Member connect(String login, String password);

    //Disconnect
    void disconnect(String login);
    //get last connexion date??!

    // Check if existing

    boolean updatePassword(String login, String email, String password);


}
