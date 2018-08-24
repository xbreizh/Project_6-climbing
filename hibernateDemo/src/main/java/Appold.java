import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;


public class Appold {

    public  void crudTest() {

        AlienName an = new AlienName();
        an.setFirstname("Bob");
        an.setSurname("Fisher");
        an.setLastname("rokobo");

        Alien alien = new Alien();
        alien.setAid(109);

        alien.setTech("IT");

        alien.setName(an);

        Configuration conf = new Configuration().configure().addAnnotatedClass(Alien.class);


        SessionFactory sf = conf.buildSessionFactory();
        Session session = sf.openSession();

        /*//Fetch
        Transaction tx = session.beginTransaction();
        alien = session.get(Alien.class, 105);
        tx.commit();
        System.out.println(alien);*/
        Transaction tx = session.beginTransaction();
        Query<Alien> q = session.createQuery("select  a from Alien a where a.aid = :aid", Alien.class).setParameter("aid", 109);
        List<Alien> resultList = q.getResultList();
        tx.commit();

        /*//Create*/
       /* Transaction tx = session.beginTransaction();
        session.save(alien);
        tx.commit();*/

        /*//Delete
        tx.begin();
        session.remove(alien);
        tx.commit();*/


    }
}
