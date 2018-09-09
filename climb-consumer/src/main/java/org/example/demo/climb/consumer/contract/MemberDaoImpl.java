package org.example.demo.climb.consumer.contract;

import org.example.demo.climb.model.bean.member.Member;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.inject.Named;
import java.util.List;

@Named
public class MemberDaoImpl implements MemberDao {

    /*@Inject
    TransactionManager transactionManager;*/
    private Class cl = Member.class;
    private Transaction tx;
    private Session session;

    private void createSession() {
        Configuration conf = new Configuration().configure().addAnnotatedClass(cl);
        SessionFactory sf = conf.buildSessionFactory();
        session = sf.openSession();
    }


    @Override
    public List getAll() {
        createSession();
        tx = session.beginTransaction();
        Query query = session.getNamedQuery("findAllMembers");
        return query.getResultList();

    }


    @Override
    public void add(Object o) {
        createSession();
        tx = session.beginTransaction();
        System.out.println("transaction starting with object: " + o);
        session.saveOrUpdate(cl.getName(), o);
        tx.commit();
        System.out.println("Object added!");
        session.close();
    }

    @Override
    public Object getById(int id) {
        createSession();
        tx = session.beginTransaction();
        return session.get(cl, id);
    }

    @Override
    public void delete(int id) {
        createSession();
        tx = session.beginTransaction();
        session.remove(session.get(cl, id));
        tx.commit();
        session.close();
    }

    @Override
    public void update(Object o) {
        createSession();
        tx = session.beginTransaction();
        session.saveOrUpdate(cl.getName(), o);
        tx.commit();
        session.close();

    }
}
