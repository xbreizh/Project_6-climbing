package org.example.demo.climb.consumer.contract;

import org.example.demo.climb.model.bean.Booking;
import org.example.demo.climb.model.bean.Topo;

import java.util.List;

public interface BookingDao {

    void add(Booking booking);
    void update(Booking booking);
    List<Booking> getListBookingByBooker(int bookingerId);
    List<Booking> getListBookingByTopo(int topoId);
    List<Booking> getListBooking(int bookerId, int topoId);
    List<Booking> getListBookingInProgress();
    boolean isAvailable(Topo topo);


}