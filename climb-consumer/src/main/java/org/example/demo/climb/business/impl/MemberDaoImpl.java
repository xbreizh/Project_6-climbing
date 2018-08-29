package org.example.demo.climb.business.impl;

import org.example.demo.climb.business.contract.MemberDao;
import org.example.demo.climb.model.bean.Member;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.inject.Named;
import java.util.List;

@Named
public class MemberDaoImpl implements MemberDao {


    @Override
    public void addMember(Member member) {
        Session session = openTransaction();
        session.save(member);
        closeTransaction(session);

    }

    @Override
    public Member getmemberById(int id) {
        Session session = openTransaction();

        Member member = session.get(Member.class, id);
        closeTransaction(session);

        return member;
    }

    @Override
    public Member getMemberByLogin(String login) {
        Session session = openTransaction();

        Member member = session.get(Member.class, login);
        closeTransaction(session);

        return member;
    }

    public Session openTransaction() {
        Configuration conf = new Configuration().configure().addAnnotatedClass(Member.class);

        SessionFactory sf = conf.buildSessionFactory();


        Session session = sf.openSession();
        session.beginTransaction();
        return session;
    }

    @Override
    public List<Member> getMemberList() {
        Session session = openTransaction();

        List<Member> stu = session.createQuery("from Member").list();
        closeTransaction(session);

        return stu;
    }

    public void closeTransaction(Session session) {
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public boolean updateMember(Member member) {
        Session session = openTransaction();
        Member m = session.get(Member.class, member.getLogin());
        m.setPassword(member.getPassword());
        m.setDescription(member.getDescription());
        session.update(m);
        closeTransaction(session);
        return true;
    }

    @Override
    public boolean deleteMember(int i) {
        return false;
    }

    @Override
    public boolean connect(String login, String password) {
        return false;
    }
}
