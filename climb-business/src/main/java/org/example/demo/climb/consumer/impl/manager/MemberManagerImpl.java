package org.example.demo.climb.consumer.impl.manager;
import org.example.demo.climb.consumer.contract.manager.MemberManager;
import org.example.demo.climb.model.bean.member.Member;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;


import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
@Transactional
@Named("memberManager")
public class MemberManagerImpl /*extends  HibernateTemplate*/ implements MemberManager {

    /*private Member member = null;*/
    private Class cl=Member.class;
    /*@Inject
    private MemberDao memberDao;*/
    @Inject
    private SessionFactory sessionFactory;

    @Override
    public List<Member> getListMember() {
        Session session = sessionFactory.openSession();
        String hql = "select * FROM Member";
        Query query = session.createNativeQuery(hql);
        List results = query.list();
        return results;
        /*return null;*/
    }

    @Override
    public void addMember(Member member) {
        member.setActive(true);
        System.out.println("Login saved: "+member.getLogin());
        member.setLogin2(member.getLogin());
        System.out.println("Login2 saved: "+member.getLogin2());
        sessionFactory.getCurrentSession().persist(member);
        /*memberDao.save(member);*/
    }

    @Override
    public boolean disconnect(String login) {
        return false;
    }

    @Override
    public Member getMember(Integer pId) {
        return (Member) sessionFactory.getCurrentSession().get(cl, pId);
    }

    @Override
    public Member getMember(String pLogin) {
        return null;
    }

    @Override
    public void updateMember(Member member) {
        int id = member.getId();
        Member m = (Member) sessionFactory.getCurrentSession().get(cl, id);
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
        sessionFactory.getCurrentSession().persist(member);
    }

    @Override
    public void deleteMember(int id) {
        sessionFactory.getCurrentSession().delete(id);
    }


    @Override
    public boolean connect(String pLogin, String pPassword) {
        return false;
    }





}
