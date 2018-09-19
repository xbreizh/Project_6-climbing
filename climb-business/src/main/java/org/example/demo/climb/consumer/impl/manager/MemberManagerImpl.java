package org.example.demo.climb.consumer.impl.manager;


import org.example.demo.climb.consumer.contract.MemberDao;
import org.example.demo.climb.consumer.contract.ZoneDao;
import org.example.demo.climb.consumer.contract.manager.MemberManager;
import org.example.demo.climb.model.bean.Zone;
import org.example.demo.climb.model.bean.member.Member;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
@Transactional
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
        member.setActive(true);
        System.out.println("Login saved: "+member.getLogin());
        member.setLogin2(member.getLogin());
        System.out.println("Login2 saved: "+member.getLogin2());
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
        System.out.println("login: "+m.getLogin());
        System.out.println(m);
        if(!member.isActive()){
            member.setLogin2(member.getLogin());
            member.setLogin("Inactive Member");
           /* member.setLogin2(m.getLogin2());*/
            System.out.println("disabling member!.new login: "+member.getLogin());
        }else{
            System.out.println("restoring original login: "+m.getLogin2());
            if(!member.getLogin().equals("")){
                member.setLogin2(member.getLogin());
            }else {
                member.setLogin2(m.getLogin2());
                member.setLogin(m.getLogin2());
            }
        }
        if(member.getPassword().equals("")){
            member.setPassword(m.getPassword());
        }
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
