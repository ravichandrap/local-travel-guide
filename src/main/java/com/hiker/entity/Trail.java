package com.hiker.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalTime;
import java.util.Objects;

@Entity
public class Trail {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private LocalTime start;
    private LocalTime end;
    private int minAge;
    private int maxAge;
    private double price;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public LocalTime getStart() {
        return start;
    }

    public void setStart(LocalTime start) {
        this.start = start;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public LocalTime getEnd() {
        return end;
    }

    public void setEnd(LocalTime end) {
        this.end = end;
    }

       public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    @Override
    public String toString() {
        return "Trail{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", minAge=" + minAge +
                ", maxAge=" + maxAge +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trail trail = (Trail) o;
        return minAge == trail.minAge &&
                maxAge == trail.maxAge &&
                Double.compare(trail.price, price) == 0 &&
                id.equals(trail.id) &&
                name.equals(trail.name) &&
                start.equals(trail.start) &&
                end.equals(trail.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, start, end, minAge, maxAge, price);
    }
}
