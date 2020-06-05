package com.travel;

import com.travel.entity.User;

import java.time.LocalDate;

public class BookingRequest {
    private User[] users;
    private String trail;
    private LocalDate bookingDate;

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public User[] getUsers() {
        return users;
    }

    public void setUsers(User[] users) {
        this.users = users;
    }

    public String getTrail() {
        return trail;
    }

    public void setTrail(String trail) {
        this.trail = trail;
    }
}
