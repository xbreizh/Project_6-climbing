package org.example.demo.climb.consumer.impl.manager;


import org.example.demo.climb.consumer.contract.MemberDao;
import org.example.demo.climb.consumer.contract.manager.MemberManager;
import org.example.demo.climb.model.bean.member.Member;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named("memberManager")
public class MemberManagerImpl extends AbstractManager implements MemberManager {

    private Member member = null;
    @Inject
    private MemberDao memberDao;

    @Override
    public List<Member> getListMember() {
        return memberDao.getAll();
    }

    @Override
    public void addMember(Member member) {
        memberDao.add(member);
    }

    @Override
    public boolean disconnect(String login) {
        return false;
    }

    @Override
    public Member getMember(Integer pId) {
        return (Member) memberDao.getById(pId);
    }

    @Override
    public Member getMember(String pLogin) {
        return null;
    }

    @Override
    public void updateMember(Member member) {

        int id = member.getId();
        Member m = (Member) memberDao.getById(id);
        member.setLogin(m.getLogin());
        memberDao.update(member);
    }

    @Override
    public void deleteMember(int id) {
        memberDao.delete(id);
    }


    @Override
    public boolean connect(String pLogin, String pPassword) {
        return false;
    }






}
