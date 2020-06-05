package com.hiker.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.Objects;

@Entity
public class Trail implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    //    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss.SSSXXX" )
    private LocalTime start;

    //    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss.SSSXXX")
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonFormat(pattern = "HH:mm:ss")
    public LocalTime getStart() {
        return start;
    }

    public void setStart(LocalTime start) {
        this.start = start;
    }

    @JsonFormat(pattern = "HH:mm:ss")
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
