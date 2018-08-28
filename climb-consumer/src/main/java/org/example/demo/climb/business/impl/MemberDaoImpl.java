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
        Configuration conf = new Configuration().configure().addAnnotatedClass(Member.class);

        SessionFactory sf = conf.buildSessionFactory();


        Session session = sf.openSession();
        session.beginTransaction();

        session.save(member);
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public Member getmemberById(int i) {
        Configuration conf = new Configuration().configure().addAnnotatedClass(Member.class);

        SessionFactory sf = conf.buildSessionFactory();


        Session session = sf.openSession();
        session.beginTransaction();

        Member stu = session.get(Member.class, i);
        session.getTransaction().commit();
        session.flush();
        session.close();

        return stu;
    }

    @Override
    public Member getMemberByName(String name) {
        return null;
    }

    @Override
    public List<Member> getMemberList() {
        Configuration conf = new Configuration().configure().addAnnotatedClass(Member.class);

        SessionFactory sf = conf.buildSessionFactory();


        Session session = sf.openSession();
        session.beginTransaction();

        List<Member> stu = session.createQuery("from Member").list();
        session.getTransaction().commit();
        session.flush();
        session.close();

        return stu;
    }

    @Override
    public boolean updateMember(Member member) {
        return false;
    }

    @Override
    public boolean deleteMember(int i) {
        return false;
    }
}
