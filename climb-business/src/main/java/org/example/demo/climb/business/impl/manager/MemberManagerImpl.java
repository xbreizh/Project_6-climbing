package org.example.demo.climb.business.impl.manager;
import org.example.demo.climb.business.contract.manager.MemberManager;
import org.example.demo.climb.model.bean.member.Member;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;


import javax.inject.Inject;
import javax.inject.Named;
import java.util.Date;
import java.util.List;
@Transactional
@Named("memberManager")
public class MemberManagerImpl  implements MemberManager {

    private Member member;
    private Class cl=Member.class;
    /*@Inject
    private MemberDao memberDao;*/
    @Inject
    private SessionFactory sessionFactory;

    @Override
    public List<Member> getListMember() {
        return sessionFactory.getCurrentSession().createQuery("from Member ").list();

    }



    @Override
    public void addMember(Member member) {
        System.out.println("Session: "+sessionFactory.getCurrentSession().toString());
        member.setActive(true);//activating user
        member.setLogin2(member.getLogin().toUpperCase());//setting backup login
        member.setLogin(member.getLogin().toUpperCase());//setting upper case login
        member.setDate(new Date());
        System.out.println("Member to be added: "+member);
        /*session.save(member);*/
        sessionFactory.getCurrentSession().persist(member);
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
    public Member getMember(Integer pId) {
        return (Member) sessionFactory.getCurrentSession().get(cl, pId);
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
        Member m = (Member) sessionFactory.getCurrentSession().get(cl, id);
        System.out.println("login: "+m.getLogin());
        System.out.println(m);
        if(!member.isActive()){
            /*m.setLogin2(member.getLogin());*/
            m.setLogin("Inactive Member");
            m.setActive(false);
           /* member.setLogin2(m.getLogin2());*/
            System.out.println("disabling member!.new login: "+m.getLogin());
        }else{
            System.out.println("restoring original login: "+m.getLogin2());
            m.setLogin(m.getLogin2());
            /*if(!member.getLogin().equals("")){
                member.setLogin2(member.getLogin());
            }else {
                member.setLogin2(m.getLogin2());
                member.setLogin(m.getLogin2());
            }*/
        }
        if(!member.getPassword().equals("")){
            m.setPassword(member.getPassword());
        }
        sessionFactory.getCurrentSession().update(m);
    }

    @Override
    public void deleteMember(int id) {
        System.out.println("trying to delete member: "+id);
        Member m= (Member) sessionFactory.getCurrentSession().get(cl, id);
        sessionFactory.getCurrentSession().delete(cl.getName(), m);
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

    }

    @Override
    public boolean updatePassword(String login, String password){
        System.out.println("trying to update pwd");
        if(exists(login.toUpperCase())){
            Member m = getMember(login.toUpperCase());
            m.setPassword(password);
            sessionFactory.getCurrentSession().update(cl.getName(), m);
            return true;
        }else{
            return false;
        }
    }


    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
