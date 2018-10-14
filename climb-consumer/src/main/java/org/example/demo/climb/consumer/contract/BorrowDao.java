package org.example.demo.climb.consumer.contract;

import org.example.demo.climb.model.bean.Borrow;
import org.example.demo.climb.model.bean.Topo;

import java.util.List;

public interface BorrowDao {

    void add(Borrow borrow);
    void update(Borrow borrow);
    List<Borrow> getListBorrowByBorrower(int borrowerId);
    List<Borrow> getListBorrowByTopo(int topoId);
    List<Borrow> getListBorrow(int borrowerId, int topoId);
    List<Borrow> getListBorrowInProgress();
    boolean isAvailable(Topo topo);


}
