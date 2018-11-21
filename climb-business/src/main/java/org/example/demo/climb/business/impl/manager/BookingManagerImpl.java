package org.example.demo.climb.business.impl.manager;

import org.example.demo.climb.business.contract.BookingManager;
import org.example.demo.climb.consumer.contract.BookingDao;
import org.example.demo.climb.model.bean.Booking;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Transactional
@Named
public class BookingManagerImpl implements BookingManager {

    @Inject
    BookingDao bookingDao;
    @Override
    public void addBooking(Booking booking) {

        System.out.println("check if I can get the booking: ");
        System.out.println("booker: "+booking.getBooker().getLogin());
        System.out.println("topo: "+booking.getTopo().getName());
        System.out.println("bookingDate: "+booking.getBookingDate());
        System.out.println("bookingReturn: "+booking.getReturnDate());
        bookingDao.add(booking);
    }

    @Override
    public List<Booking> getListBookingFromMember(int id) {
        return null;
    }

    @Override
    public List<Booking> getListBookingFromSpot(int id) {
        return null;
    }

    @Override
    public void updateBooking(Booking booking) {

    }

    @Override
    public void deleteBooking(int id) {

    }
}
