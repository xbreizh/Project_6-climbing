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
    private Session session;

    @Override
    public List<Member> getListMember() {
        gettingSession();
        return session.createQuery("from Member ").list();

    }

    private void gettingSession() {
        System.out.println("Session: "+session);
        /*if((this.session=sessionFactory.getCurrentSession())==null){*/
            this.session=sessionFactory.openSession();
           /* System.out.println("Opening a new session");
        }else{
            System.out.println("getting existing session");
        }*/
    }

    @Override
    public void addMember(Member member) {
        gettingSession();
        System.out.println("Session: "+session.toString());
        member.setActive(true);//activating user
        member.setLogin2(member.getLogin().toUpperCase());//setting backup login
        member.setLogin(member.getLogin().toUpperCase());//setting upper case login
        member.setDate(new Date());
        System.out.println("Member to be added: "+member);
        /*session.save(member);*/
        session.persist(member);
        System.out.println("Checking if member is added: "+getMember(member.getId()));
    }



    @Override //checks if the login passed is already in use
    public boolean exists(String login) {
        gettingSession();
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
        gettingSession();
        return (Member) session.get(cl, pId);
    }

    @Override
    public Member getMember(String login) {
        gettingSession();
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
        gettingSession();
        int id = member.getId();
        Member m = (Member) session.get(cl, id);
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
        session.update(m);
    }

    @Override
    public void deleteMember(int id) {
        gettingSession();
        System.out.println("trying to delete member: "+id);
        Member m= (Member) session.get(cl, id);
        session.delete(cl.getName(), m);
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
        gettingSession();
        if(exists(login.toUpperCase())){
            Member m = getMember(login.toUpperCase());
            m.setPassword(password);
        session.update(cl.getName(), m);
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
