package com.travel.data;

import com.travel.repository.TrailRepository;
import com.travel.entity.Trail;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class TrailData {
    static final Logger logger = Logger.getLogger(TrailData.class);

    @Autowired
    private TrailRepository repository;

    @EventListener
    public void appReady(ApplicationReadyEvent event) {
        logger.info("Create default trail data");
        Trail shire = new Trail();
        shire.setName("Shire");
        shire.setMaxAge(100);
        shire.setMinAge(5);
        shire.setStart(LocalTime.of(7, 0, 0, 0));
        shire.setEnd(LocalTime.of(9, 0, 0, 0));
        shire.setPrice(29.90);

        Trail gondor = new Trail();
        gondor.setName("Gondor");
        gondor.setMaxAge(50);
        gondor.setMinAge(11);
        gondor.setStart(LocalTime.of(10, 0, 0, 0));
        gondor.setEnd(LocalTime.of(13, 0, 0, 0));
        gondor.setPrice(59.90);

        Trail mordor = new Trail();
        mordor.setName("Mordor");
        mordor.setMaxAge(40);
        mordor.setMinAge(18);
        mordor.setStart(LocalTime.of(14, 0, 0, 0));
        mordor.setEnd(LocalTime.of(19, 0, 0, 0));
        mordor.setPrice(99.90);


        List<Trail> trails = new ArrayList<>(3);
        trails.add(shire);
        trails.add(gondor);
        trails.add(mordor);

        repository.saveAll(trails);
        logger.info("Create default trail data finished");
    }
}
