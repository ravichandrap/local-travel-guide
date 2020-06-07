package com.travel;


import com.travel.entity.Booking;
import com.travel.entity.User;
import com.travel.exception.BookingException;
import com.travel.repository.BookingService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("booking")
public class BookingController {
    static final Logger logger = Logger.getLogger(BookingController.class);

    @Autowired
    private BookingService service;

    @PostMapping
    public ResponseEntity create(@RequestBody BookingRequest bookingRequest) {
        service.createBooking(bookingRequest);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Booking> cancel(@PathVariable Long id) {
        return new ResponseEntity<>(service.cancel(id), HttpStatus.OK);
    }

    @GetMapping("/user/")
    public List<User> viewUsers() {
        return service.viewUser();
    }

    @GetMapping("/user/name/{name}")
    public List<User> viewUsers(@PathVariable String name) {
        return service.viewUser(name);
    }

    @GetMapping("/user/id/{id}")
    public User viewUsers(@PathVariable Long id) {
        Optional<User> user = service.viewUser(id);
        return user.orElseThrow(() -> new BookingException("No user found with id " + id));
    }

    @GetMapping("/date/{date}")
    public List<Booking> viewBookings(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable LocalDate date) {
        return service.viewBookings(date);
    }

    @GetMapping("/name/{name}")
    public List<Booking> viewBookings(@PathVariable String name) {
        return service.viewBookings(name);
    }

    @GetMapping
    public List<Booking> viewBookings() {
//        return service.viewBookings().stream().map(b -> b.add(linkTo(methodOn(BookingController.class).viewBookings(b.getDate())).withRel("Date"))).collect(Collectors.toList());
        return service.viewBookings();
    }
}
