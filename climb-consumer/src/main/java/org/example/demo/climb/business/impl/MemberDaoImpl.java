package org.example.demo.climb.business.impl;

import org.example.demo.climb.business.contract.MemberDao;
import org.example.demo.climb.model.bean.TransactionCreation;
import org.example.demo.climb.model.bean.member.Member;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class MemberDaoImpl implements MemberDao {

    @Inject
    private TransactionCreation tx;


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

    private Session openTransaction() {
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

    private void closeTransaction(Session session) {
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public boolean updateMember(Member member) {
        System.out.println("DAO, member received: " + member);
        Session session = openTransaction();
        // Getting member from the dbb
        Member m = session.get(Member.class, member.getId());
        System.out.println("DAO, member from dbb: " + m);

        session.evict(m);
        m.setPassword(member.getPassword());
        m.setDescription(member.getDescription());
        System.out.println("DAO, member updated: " + m);

        session.update(m);
        closeTransaction(session);
        return true;
    }

    @Override
    public boolean deleteMember(int id) {
        System.out.println("DAO, member id received: " + id);
        Session session = openTransaction();
        Member m = session.get(Member.class, id);
        System.out.println("DAO, member from dbb: " + m);
        session.delete(m);
        System.out.println("Member has been deleted");
        closeTransaction(session);

        return true;
    }

    @Override
    public boolean connect(String login, String password) {
        return false;
    }
}
