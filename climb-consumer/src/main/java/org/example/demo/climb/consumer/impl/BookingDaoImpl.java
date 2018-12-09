package org.example.demo.climb.consumer.impl;

import org.apache.log4j.Logger;
import org.example.demo.climb.consumer.contract.BookingDao;
import org.example.demo.climb.model.bean.Booking;
import org.example.demo.climb.model.bean.Topo;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class BookingDaoImpl implements BookingDao {
    private Logger logger = Logger.getLogger(this.getClass().getName());
    private Class cl = Booking.class;

    @Inject
    private SessionFactory sessionFactory;


    @Override
    public void add(Booking booking) {
        sessionFactory.getCurrentSession().persist(booking);
    }

    @Override
    public void update(Booking booking) {
        sessionFactory.getCurrentSession().update(cl.getName(), booking);
    }

    @Override
    public List<Booking> getListBookingByBooker(int bookerId) {
        Query query = sessionFactory.getCurrentSession().createQuery("" +
                "From Booking where booker.id=:bookerId");
        query.setParameter("bookerId", bookerId);
        return (List<Booking>) query.getResultList();
    }

    @Override
    public List<Booking> getListBookingByTopo(int topoId) {
        Query query = sessionFactory.getCurrentSession().createQuery("" +
                "From Booking where topo.id=:topoId");
        query.setParameter("topoId", topoId);
        return (List<Booking>) query.getResultList();
    }

    @Override
    public List<Booking> getListBooking(int bookerId, int topoId) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "From Booking where topo.id=:topoId and booker.id=:bookerId");
        query.setParameter("bookerId", bookerId);
        query.setParameter("topoId", topoId);
        return (List<Booking>) query.getResultList();
    }

    @Override
    public List<Booking> getListBookingInProgress() {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "From Booking where returnDate is null");
        return (List<Booking>) query.getResultList();
    }

    @Override
    public List<Booking> getAll() {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "From Booking");
        return (List<Booking>) query.getResultList();
    }

    @Override
    public boolean isAvailable(Topo topo) {
        Query query = sessionFactory.getCurrentSession().createQuery("" +
                "From Booking where topo.id = :topoId and returnDate is not null");
        int topoId = topo.getId();
        query.setParameter("topoId", topoId);
        if (query.getSingleResult() != null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Booking getBookingById(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "From Booking where id = :id");
        query.setParameter("id", id);

        return (Booking) query.getSingleResult();
    }


}
