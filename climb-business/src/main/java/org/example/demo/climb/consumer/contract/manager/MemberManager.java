package org.example.demo.climb.consumer.contract.manager;

import org.example.demo.climb.model.bean.member.Member;
import org.example.demo.climb.model.exception.NotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

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


}
