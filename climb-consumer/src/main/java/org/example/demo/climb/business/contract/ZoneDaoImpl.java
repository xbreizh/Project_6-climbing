package org.example.demo.climb.business.contract;

import org.example.demo.climb.model.bean.Zone;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
public class ZoneDaoImpl implements JpaRepository, ZoneDao {

    private HibernateTemplate hibernate;

    private Session openTransaction() {


        Configuration conf = new Configuration().configure().addAnnotatedClass(Zone.class);

        SessionFactory sf = conf.buildSessionFactory();

        this.hibernate = new HibernateTemplate(sf);
        Session session = sf.openSession();
        session.beginTransaction();
        return session;
    }


    private void closeTransaction(Session session) {
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List findAll() {
        Session session = openTransaction();
        /*System.out.println("dao ");
        List<Zone> stu = session.createQuery("from Zone").list();
        System.out.println(stu.size());
        closeTransaction(session);
        return stu;*/
        return hibernate.loadAll(Zone.class);
    }

    /*  public List FindEverything(){
          hibernate
      }
  */
    public boolean update(Zone zone) {
        System.out.println("DAO, zone received: " + zone);
        Session session = openTransaction();
        // Getting member from the dbb
       /* Zone z = session.get(Zone.class, zone.getId());
        System.out.println("DAO, member from dbb: " + z);

        session.evict(z);
        z.setCountry(zone.getCountry());
        z.setName(zone.getName());
        z.setRegion(zone.getRegion());
        z.setType(zone.getType());
        System.out.println("DAO, member updated: " + z);

        session.update(z);
        closeTransaction(session);*/
        hibernate.saveOrUpdate(zone);
        return true;
    }

    @Override
    public boolean addZone(Zone zone) {

        Session session = openTransaction();
        session.save(zone);
        closeTransaction(session);
        return false;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Serializable id) {
        Session session = openTransaction();
        Zone z = session.get(Zone.class, id);
        System.out.println("DAO, zone from dbb: " + z);
        session.delete(z);
        System.out.println("Zone has been deleted");
        closeTransaction(session);

    }

    @Override
    public void delete(Object o) {

    }

    @Override
    public void delete(Iterable id) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List findAll(Sort sort) {
        return null;
    }

    @Override
    public Page findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Object save(Object o) {
        Session session = openTransaction();
        System.out.println("dao: " + o);

        Zone zone = (Zone) o;
        session.save(zone);
        session.close();
        return null;
    }

    @Override
    public List save(Iterable iterable) {
        return null;
    }

    @Override
    public Object findOne(Serializable id) {

        Session session = openTransaction();
        Zone zone = hibernate.get(Zone.class, id);
        closeTransaction(session);

        return zone;
    }

    @Override
    public boolean exists(Serializable id) {
        Session session = openTransaction();
        Zone z = hibernate.get(Zone.class, id);
        return z != null;
    }

    @Override
    public void flush() {
        hibernate.flush();
    }

    @Override
    public Object saveAndFlush(Object o) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable iterable) {

    }

    @Override
    public Serializable getId() {
        return null;
    }

    @Override
    public boolean isNew() {
        return false;
    }
}
