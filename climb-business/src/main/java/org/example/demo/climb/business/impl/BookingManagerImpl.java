package org.example.demo.climb.business.impl;

import org.example.demo.climb.business.contract.BookingManager;
import org.example.demo.climb.consumer.contract.BookingDao;
import org.example.demo.climb.model.bean.Booking;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.Date;
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
        if(bookingList.size() == 0){
            System.out.println("bookingList is empty");
        }else{
            System.out.println("bookingList is not empty: "+bookingList.get(0));
        }
        List<Booking> conflictList=new ArrayList<>();
        if(conflictList.size() > 0) {
            System.out.println("cl list manager debu: " + conflictList.get(0));
            System.out.println("cl list manager debu size: " + conflictList.size());
        }
        for (Booking b: bookingList
             ) {
                if (booking.getBookingDate().equals(b.getBookingDate())||(booking.getBookingDate().after(b.getBookingDate()) && booking.getBookingDate().before(b.getPlannedReturnDate()))) {
                   conflictList.add(b);
                }else if
                (booking.getPlannedReturnDate().after(b.getBookingDate()) && booking.getPlannedReturnDate().before(b.getPlannedReturnDate())) {
                    conflictList.add(b);
                }else if
            (booking.getBookingDate().before(b.getBookingDate()) && booking.getPlannedReturnDate().after(b.getPlannedReturnDate())){
                    conflictList.add(b);
        }

        }
        if(conflictList.size()==0) {
            bookingDao.add(booking);
        }
        if(conflictList.size() > 0) {
            System.out.println("cl list manager fin: " + conflictList.get(0));
            System.out.println("cl list manager fin size: " + conflictList.size());
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
    public List<Booking> getListBooking() {
        return bookingDao.getAll();
    }

    @Override
    public void endBooking(int id) {
        Date today = new Date();
        Booking booking = bookingDao.getBookingById(id);
        booking.setReturnDate(today);
        if(booking.getPlannedReturnDate().after(today)){
            booking.setPlannedReturnDate(today);
        }
        updateBooking(booking);
    }

    @Override
    public List<Booking> getBookedListByBooker(int id) {
        return bookingDao.getListBookingByBooker(id);
    }

    @Override
    public void updateBooking(Booking booking) {
        bookingDao.update(booking);
    }

    @Override
    public void deleteBooking(int id) {

    }
}
