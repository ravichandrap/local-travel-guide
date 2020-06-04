package com.hiker.repository;

import com.hiker.entity.Hiker;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface HikerRepository extends CrudRepository<Hiker, Long> {

    List<Hiker> findByStart(LocalDateTime from);
}
