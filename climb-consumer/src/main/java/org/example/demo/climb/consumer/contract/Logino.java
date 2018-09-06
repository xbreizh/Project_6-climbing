package org.example.demo.climb.consumer.contract;

import org.example.demo.climb.model.bean.member.Member;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.inject.Named;

@Named
public class Logino implements LoginInterface {


    public Member checkLogin() {
        Configuration conf = new Configuration().configure().addAnnotatedClass(Member.class);
        /* *//*.addAnnotatedClass(Member.class).addAnnotatedClass(Laptop.class);*//*
        System.out.println("test");*/

        SessionFactory sf = conf.buildSessionFactory();


        Session session = sf.openSession();
        session.beginTransaction();

        Member stu = session.get(Member.class, 1);
        session.getTransaction().commit();
        session.close();

        return stu;
    }
}
