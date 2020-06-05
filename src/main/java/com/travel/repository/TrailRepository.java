package com.travel.repository;

import com.travel.entity.Trail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrailRepository extends JpaRepository<Trail, Long> {


    Optional<Trail> findByName(String name);
}
