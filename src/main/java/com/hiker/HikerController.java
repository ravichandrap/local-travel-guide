package com.hiker;

import com.hiker.entity.Hiker;
import com.hiker.repository.HikerRepository;
import com.hiker.util.HikerNotFoundException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("hiker")
public class HikerController {
    static final Logger logger = Logger.getLogger(HikerController.class);

    @Autowired
    private HikerRepository repository;

    @PostMapping
    public Hiker create(@RequestBody Hiker hiker) {
        System.out.println(hiker.toString());
        return repository.save(hiker);
    }

    @GetMapping("/id/{id}")
    public Hiker viewById(@PathVariable Long id) {
        logger.info("Fetching & Deleting Hiker with id :"+ id);
        return repository.findById(id).orElseThrow(()-> new HikerNotFoundException(id));
    }
    @GetMapping("/date/{from}")
    public List<Hiker>  viewByDate(@PathVariable LocalDateTime from) {
        logger.info("Fetching Hiker by Date :"+ from);
         return repository.findByStart(from);
    }

    @GetMapping
    public List<Hiker> view() {
        return (List<Hiker>) repository.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> cancel(@PathVariable Long id) {
        logger.info("Fetching & Deleting Hiker with id :"+ id);
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
