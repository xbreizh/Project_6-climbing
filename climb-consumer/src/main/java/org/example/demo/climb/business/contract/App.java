package org.example.demo.climb.business.contract;


import org.example.demo.climb.model.bean.Member;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class App {

    public static void main(String[] args) {

        Configuration conf = new Configuration().configure().addAnnotatedClass(Member.class);

        SessionFactory sf = conf.buildSessionFactory();


        Session session = sf.openSession();
        session.beginTransaction();

        List<Member> stu = session.createQuery("from Member").list();
        session.getTransaction().commit();
        session.close();

        for (Member m : stu) {
            System.out.println(m);
        }
    }


}