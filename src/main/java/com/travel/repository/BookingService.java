package com.travel.repository;

import com.travel.BookingRequest;
import com.travel.entity.Booking;
import com.travel.entity.Trail;
import com.travel.entity.User;
import com.travel.exception.BookingException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    static final Logger logger = Logger.getLogger(BookingService.class);

    @Autowired
    private BookingRepository bookingRepo;

    @Autowired
    private TrailRepository trailRepo;

    @Autowired
    private UserRepository userRepository;

    public void createBooking(BookingRequest bookingRequest) {
        Trail trail = isTrailExits(bookingRequest.getTrail());
        bookingRequestValidation(trail, bookingRequest.getUsers());

        Booking booking = new Booking();
        booking.setDate(bookingRequest.getBookingDate());
        booking.setStatus(1);
        booking.setTrailId(trail.getId());
        Booking b = bookingRepo.save(booking);

        User[] users = bookingRequest.getUsers();
        Arrays.stream(users).forEach(u -> {
            u.setBookingId(b.getId());
            userRepository.save(u);
        });
    }

    private Trail isTrailExits(String name) {
        return trailRepo.findByName(name).orElseThrow(() -> new BookingException("No Trail found with " + name));
    }

    private void bookingRequestValidation(Trail trail, User[] users) {
        if (users.length == 0) {
            throw new BookingException("Users not found");
        }

        Arrays.stream(users).forEach(u -> {
            if (!(u.getAge() >= trail.getMinAge() && u.getAge() <= trail.getMaxAge())) {
                logger.error("User age criteria is not match!");
                throw new BookingException("User age criteria is not match!");
            }
        });
    }

    public Booking cancel(Long id) {
        return bookingRepo.findById(id).map(booking -> {
            booking.setStatus(0);
            bookingRepo.save(booking);
            return booking;
        }).orElseThrow(() -> new BookingException("Booking not found with id " + id));
    }

    public List<User> viewUser(String name) {
        return userRepository.findByName(name);
    }

    public Optional<User> viewUser(Long id) {
        return userRepository.findById(id);
    }

    public List<Booking> viewBookings(LocalDate date) {
        return bookingRepo.findByDate(date);
    }

    public List<Booking> viewBookings(String name) {
        return bookingRepo.findByTrailId(name);
    }

    public List<Booking> viewBookings() {
        return bookingRepo.findAll();
    }

    public List<User> viewUser() {
        return userRepository.findAll();
    }
}
