package org.example.demo.climb.consumer.impl;

import org.example.demo.climb.model.bean.member.Member;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.inject.Named;

/*@Named*/
public class createConfigMember {

  /*  private SessionFactory sf;
    private Session session;
    private Class cl = Member.class;


    protected Session getSession() {

        if(this.sf==null) {
            System.out.println("creation of session factory");
            Configuration conf = new Configuration().configure().addAnnotatedClass(cl);
            this.sf = conf.buildSessionFactory();
            System.out.println("creation session and opening");
            return this.session = this.sf.openSession();
        }else {
            System.out.println("creation session and opening");
            return this.session = this.sf.openSession();
        }
    }*/
}
