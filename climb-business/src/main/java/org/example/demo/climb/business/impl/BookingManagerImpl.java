package org.example.demo.climb.business.impl;

import org.example.demo.climb.business.contract.BookingManager;
import org.example.demo.climb.consumer.contract.BookingDao;
import org.example.demo.climb.model.bean.Booking;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Named
public class BookingManagerImpl implements BookingManager {

    @Inject
    BookingDao bookingDao;
    @Override
    public List<Booking> addBooking(Booking booking) {
        String str="";
        String checkDate1="";
        String checkDate2="";
        String checkDate3="";
        List<Booking> bookingList = bookingDao.getListBookingByTopo(booking.getTopo().getId());
        List<Booking> conflictList=new ArrayList<>();
        for (Booking b: bookingList
             ) {
                if (booking.getBookingDate().equals(b.getBookingDate())||(booking.getBookingDate().after(b.getBookingDate()) && booking.getBookingDate().before(b.getReturnDate()))) {
                   conflictList.add(b);
                }else if
                (booking.getReturnDate().after(b.getBookingDate()) && booking.getReturnDate().before(b.getReturnDate())) {
                    conflictList.add(b);
                }else if
            (booking.getBookingDate().before(b.getBookingDate()) && booking.getReturnDate().after(b.getReturnDate())){
                    conflictList.add(b);
        }

        }
        if(conflictList.size()==0) {
            bookingDao.add(booking);
        }

       return conflictList;



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
