package org.example.demo.climb.business.impl.manager;
import org.example.demo.climb.business.contract.manager.MemberManager;
import org.example.demo.climb.business.contract.manager.SpotManager;
import org.example.demo.climb.consumer.contract.MemberDao;
import org.example.demo.climb.model.bean.Spot;
import org.example.demo.climb.model.bean.member.Member;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;


import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Transactional
@Named("memberManager")
public class MemberManagerImpl  implements MemberManager {

    private Member member;
    private Class cl=Member.class;
    @Inject
    private MemberDao memberDao;
    @Inject
    private SpotManager spotManager;

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @Override
    public List<Member> getListMember() {
        /*return sessionFactory.getCurrentSession().createQuery("from Member ").list();*/
        return memberDao.getAll();

    }



    @Override
    public void addMember(Member member) {
        /*System.out.println("Session: "+sessionFactory.getCurrentSession().toString());*/
        member.setActive(true);//activating user
        member.setLogin2(member.getLogin().toUpperCase());//setting backup login
        member.setLogin(member.getLogin().toUpperCase());//setting upper case login
        member.setDatejoin(new Date());
        System.out.println("Member to be added: "+member);
        /*sessionFactory.getCurrentSession().persist(member);*/
        memberDao.add(member);
        System.out.println("Checking if member is added: "+getMember(member.getId()));
    }



    @Override //checks if the login passed is already in use
    public boolean exists(String login) {
        for (Member m : getListMember()
        ) {
            if (m.getLogin().equals(login.toUpperCase())) {
                return true;
            }
        }
            return false;
    }

    @Override
    public Member getMember(Integer id) {
        /*Member m = (Member) sessionFactory.getCurrentSession().get(cl, pId);*/
        return (Member) memberDao.getById(id);
    }

    @Override
    public Member getMember(String login) {
        for (Member m : getListMember()
        ) {
            if (m.getLogin().equals(login)) {
                return m;
            }
        }
        return null;
    }

    @Override
    public void updateMember(Member member) {
        int id = member.getId();
        /*Member m = (Member) sessionFactory.getCurrentSession().get(cl, id);*/
        Member m = (Member) memberDao.getById(id);
        System.out.println("login: "+m.getLogin());
        System.out.println(m);
        if(!member.isActive()){
            m.setLogin("Inactive Member");
            m.setActive(false);
        }else{
            m.setLogin(m.getLogin2());
            m.setActive(true);
            m.setDescription(member.getDescription());
        }
        /*sessionFactory.getCurrentSession().update(m);*/
        memberDao.update(m);
    }

    @Override
    public void deleteMember(int id) {
        spotManager.updateWhenDeletingMember(id);
        System.out.println("trying to delete member: "+id);
        /*Member m= (Member) sessionFactory.getCurrentSession().get(cl, id);*/
        Member m= (Member)memberDao.getById(id);
       /* Member m2= (Member)memberDao.getById(1);
        System.out.println("trying to remove spotList");
        *//*m.setSpotList(null);*//*
        *//*sessionFactory.getCurrentSession().delete(cl.getName(), m);*//*
       *//* spotManager.updateWhenDeletingMember(id);*//*
        List<Spot> spotList1= m.getSpotList();
        List<Spot> spotList2= m2.getSpotList();
        for (Spot spot:spotList1){
            spotList2.add(spot);
        }
        List<Spot> spotList3 = new ArrayList<>();
        m.setSpotList(spotList3);
        System.out.println("new list for member: "+m.getSpotList());
        memberDao.update(m);*/
        System.out.println("member to delete after update: "+m);
        if(m.getSpotList().size()==0) {
            memberDao.delete(m);
        }else{
            System.err.println("issue while updating the spotlist for member: "+m);
        }
    }


    @Override
    public Member connect(String login, String password) {
        System.out.println("yo!");
        Member m;
        if(((m=getMember(login.toUpperCase()))!=null)){
            System.out.println("login ok :"+login);
            if(m.getPassword().equals(password)){
                System.out.println("login & pwd ok");
                return m;
            }
        }
        return null;
    }

    @Override
    public void disconnect(String login) {
        Member m;
        if(((m=getMember(login.toUpperCase()))!=null)){
            m.setDateLastConnect(new Date());
        }
    }

    @Override
    public boolean updatePassword(String login, String email, String password){
        System.out.println("trying to update pwd");
        if(exists(login.toUpperCase())){
            Member m = getMember(login.toUpperCase());
            if(m.getEmail().equals(email)) {
                m.setPassword(password);
                /*sessionFactory.getCurrentSession().update(cl.getName(), m);*/
                memberDao.update(m);
                return true;
            }
        }
        return false;
    }



}
