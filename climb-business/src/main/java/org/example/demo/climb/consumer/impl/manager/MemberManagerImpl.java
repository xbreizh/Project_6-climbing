package org.example.demo.climb.consumer.impl.manager;


import org.example.demo.climb.consumer.contract.Dao;
import org.example.demo.climb.consumer.contract.manager.MemberManager;
import org.example.demo.climb.model.bean.member.Member;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named("memberManager")
public class MemberManagerImpl extends AbstractManager implements MemberManager {

    private Member member = null;
    @Inject
    private Dao dao;
    private Class cl = Member.class;

    @Override
    public List<Member> getListMember() {
        dao.setCl(cl);
        return dao.getAll();
    }

    @Override
    public void addMember(Member member) {
        setDaoClass();
        dao.add(member);
    }

    @Override
    public boolean disconnect(String login) {
        return false;
    }

    @Override
    public Member getMember(Integer pId) {
        setDaoClass();
        return (Member) dao.getById(pId);
    }

    @Override
    public Member getMember(String pLogin) {
        return null;
    }

    @Override
    public void updateMember(Member member) {
        setDaoClass();
    }

    @Override
    public void deleteMember(int id) {
        setDaoClass();
        dao.delete(id);
    }

    public void setDaoClass() {
        dao.setCl(cl);
    }


    @Override
    public boolean connect(String pLogin, String pPassword) {
        return false;
    }






}
