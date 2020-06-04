package com.hiker.repository;

import com.hiker.BookingRequest;
import com.hiker.entity.Booking;
import com.hiker.entity.Trail;
import com.hiker.entity.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class BookingService {
    static final Logger logger = Logger.getLogger(BookingService.class);

    @Autowired
    private BookingRepository bookingRepo;

    @Autowired
    private TrailRepository trailRepo;

    @Autowired
    private UserRepository userRepository;

    public void booking(BookingRequest bookingRequest) throws Exception {
        final String name = bookingRequest.getTrail();
//        Trail trail = trailRepo.findByName(name).orElseThrow(()->new TrailNotFoundException(name));
        List<Trail> trails = trailRepo.findAll();
        trails.forEach(t->{
            System.out.println("-------"+t.toString());
        });
        Trail trail = trailRepo.findByName(name).orElseThrow(()->new Exception(""));
        User[] users = bookingRequest.getUsers();
        Arrays.stream(users).forEach(u->{
            if(!(u.getAge() >= trail.getMinAge() && u.getAge() <= trail.getMaxAge() )) {
                    //throw  new RuntimeException("User age criteria is not match!");
                    logger.error("User age criteria is not match!");
            }
        });
        List<User> userList = new ArrayList<>(users.length);
        Arrays.stream(users).forEach(u->{
//            u.setBookingId(booking.getId());
            u.setBookings(null);
            userList.add(u);

        });
        List<User> l = userRepository.saveAll(userList);

        Booking booking = new Booking();
        booking.setDate(bookingRequest.getBookingDate());
        booking.setStatus(1);
        booking.setTrailId(trail.getId());
        Booking b = bookingRepo.save(booking);

        l.forEach(u->{
            u.setBookingId(b.getId());
            userRepository.save(u);
        });

    }

    public void cancel(Long id) {
    }

    public List<User> view() {

        bookingRepo.findAll().forEach(b->{
            System.out.println(b.toString());
        });
        return (List<User>)userRepository.findAll();
    }

    public void view(LocalDate date) {
    }
}
