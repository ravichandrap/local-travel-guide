package com.hiker;

import com.hiker.entity.Booking;
import com.hiker.entity.User;
import com.hiker.repository.BookingService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/booking")
public class BookingController {
    static final Logger logger = Logger.getLogger(BookingController.class);

    @Autowired
    private BookingService service;

    @PostMapping
    public ResponseEntity<Booking> create(@RequestBody BookingRequest bookingRequest ) throws Exception {
        service.booking(bookingRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Booking> cancel(@PathVariable Long id) {
        service.cancel(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public List<User> viewByUserId() {
        return  service.view();
    }

    @GetMapping("/{date}")
    public List<Booking> viewByDate(@PathVariable LocalDate date) {
        service.view(date);

        return new ArrayList<>();
    }
}
