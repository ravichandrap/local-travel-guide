package com.hiker;

import com.hiker.entity.Hiker;
import com.hiker.util.HikerException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("hiker")
public class HikerController {
    static final Logger logger = Logger.getLogger(HikerController.class);

    @Autowired
    private HikerService service;

    @PostMapping
    public Hiker create(@RequestBody Hiker hiker) {
        System.out.println(hiker.toString());
        return service.create(hiker);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> cancel(@PathVariable int id) {
        logger.info("Fetching & Deleting Hiker with id :"+ id);

        Hiker hiker = service.findById(id);
        if(hiker == null) {
            return new ResponseEntity<>(new HikerException("Unable to delete. Hiker records with id: "
                    + id + " not found"), HttpStatus.NOT_FOUND);
        }
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public String view() {

        return "Hello world Hiker: View";
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> viewById(@PathVariable int id) {
        Hiker hiker = service.findById(id);
        if(hiker == null) {
            return new ResponseEntity<>(new HikerException("Unable to delete. Hiker records with id: "
                    + id + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(hiker, HttpStatus.OK);
    }
}
