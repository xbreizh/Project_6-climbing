package org.example.demo.climb.consumer.impl.manager;
import org.example.demo.climb.consumer.contract.manager.MemberManager;
import org.example.demo.climb.model.bean.member.Member;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;


import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
@Transactional
@Named("memberManager")
public class MemberManagerImpl  implements MemberManager {

    /*private Member member = null;*/
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
        this.session= sessionFactory.getCurrentSession();
    }

    @Override
    public void addMember(Member member) {
        gettingSession();
      /*  if(sessionFactory == null){
            System.out.println("session factory is null");
        }

        session = sessionFactory.getCurrentSession();
        if(session == null){
            System.out.println("session  is null");
        }*/
        member.setActive(true);
        /*System.out.println("Login saved: "+member.getLogin());*/
        member.setLogin2(member.getLogin());
       /* System.out.println("Login2 saved: "+member.getLogin2());*/
        session.persist(member);
        /*memberDao.save(member);*/
    }

    @Override
    public boolean disconnect(String login) {
        return false;
    }

    @Override
    public Member getMember(Integer pId) {
        gettingSession();
        return (Member) session.get(cl, pId);
    }

    @Override
    public Member getMember(String pLogin) {
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
    public boolean connect(String pLogin, String pPassword) {
        return false;
    }





}
