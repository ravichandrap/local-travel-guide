package com.hiker;

import com.hiker.entity.Hiker;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class HikerService {
static final Logger logger = Logger.getLogger(HikerService.class);

    public Hiker create(Hiker hiker) {
        logger.info("Hiker has created: "+ hiker.getName());
        return hiker;
    }

    public Hiker findById(int id) {
        Hiker hiker = new Hiker();
        hiker.setId(id);
        return hiker;
    }

    public void deleteById(int id) {

    }
}
