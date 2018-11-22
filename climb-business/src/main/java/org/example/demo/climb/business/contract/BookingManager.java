package org.example.demo.climb.business.contract;


import org.example.demo.climb.model.bean.Booking;

import java.util.List;

/**
 * Manager du package « utilisateur »
 */
public interface BookingManager {

    // Create
    List<Booking> addBooking(Booking booking);

   /* // Get
    Booking getBookingByName(String name) throws NotFoundException;*/

    List<Booking> getListBookingFromMember(int id);

    List<Booking> getListBookingFromSpot(int id);

    /*//Get list
    Booking getBookingById(Integer pId) throws NotFoundException;*/

    /*List<Booking> getListBooking(Spot spot, String grade, String type, int height);*/

    //Update
    void updateBooking(Booking booking);

    //Delete
    void deleteBooking(int id);

    /*//Update on delete
    void updateWhenDeletingMember(int id);
    List<String> getListGrade();
    List<String> getListClimbingType();*/


}
