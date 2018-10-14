package org.example.demo.climb.consumer.impl;

import org.example.demo.climb.consumer.contract.BorrowDao;
import org.example.demo.climb.consumer.contract.CountryDao;
import org.example.demo.climb.model.bean.Borrow;
import org.example.demo.climb.model.bean.Country;
import org.example.demo.climb.model.bean.Topo;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class BorrowDaoImpl implements BorrowDao {

    private Class cl= Borrow.class;

    @Inject
    private SessionFactory sessionFactory;


    @Override
    public void add(Borrow borrow) {
        sessionFactory.getCurrentSession().persist(borrow);
    }

    @Override
    public void update(Borrow borrow) {
        sessionFactory.getCurrentSession().update(cl.getName(), borrow);
    }

    @Override
    public List<Borrow> getListBorrowByBorrower(int borrowerId) {
        Query query = sessionFactory.getCurrentSession().createQuery("" +
                "From Borrow where borrower.id=:borrowerId");
        query.setParameter("borrowerId", borrowerId);
        return (List<Borrow>) query.getResultList();
    }

    @Override
    public List<Borrow> getListBorrowByTopo(int topoId) {
        Query query = sessionFactory.getCurrentSession().createQuery("" +
                "From Borrow where topo.id=:topoId");
        query.setParameter("topoId", topoId);
        return (List<Borrow>) query.getResultList();
    }

    @Override
    public List<Borrow> getListBorrow(int borrowerId, int topoId) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "From Borrow where topo.id=:topoId and borrower.id=:borrowerId");
        query.setParameter("borrowerId", borrowerId);
        query.setParameter("topoId", topoId);
        return (List<Borrow>) query.getResultList();
    }

    @Override
    public List<Borrow> getListBorrowInProgress() {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "From Borrow where returnDate is null");
        return (List<Borrow>) query.getResultList();
    }

    @Override
    public boolean isAvailable(Topo topo) {
        Query query = sessionFactory.getCurrentSession().createQuery("" +
                "From Borrow where topo.id = :topoId and returnDate is not null");
        int topoId = topo.getId();
        query.setParameter("topoId", topoId);
        if(query.getSingleResult()!=null){
            return false;
        }else{
            return true;
        }
    }


}
