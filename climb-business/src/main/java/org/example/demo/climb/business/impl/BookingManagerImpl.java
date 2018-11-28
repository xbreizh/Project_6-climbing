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
                if (booking.getBookingDate().equals(b.getBookingDate())||(booking.getBookingDate().after(b.getBookingDate()) && booking.getBookingDate().before(b.getReturnDate()))) {
                   conflictList.add(b);
                    System.out.println("base: "+b.getBookingDate());
                    System.out.println("base: "+b.getReturnDate());
                    System.out.println("booking: "+booking.getBookingDate());
                    System.out.println("booking: "+booking.getReturnDate());
                    System.out.println("added 1");
                }else if
                (booking.getReturnDate().after(b.getBookingDate()) && booking.getReturnDate().before(b.getReturnDate())) {
                    conflictList.add(b);
                    System.out.println("added 2");
                }else if
            (booking.getBookingDate().before(b.getBookingDate()) && booking.getReturnDate().after(b.getReturnDate())){
                    conflictList.add(b);
                    System.out.println("added 3");
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
    public void updateBooking(Booking booking) {

    }

    @Override
    public void deleteBooking(int id) {

    }
}
