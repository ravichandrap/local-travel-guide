package com.hiker.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Hiker {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private LocalDateTime start;
    private LocalDateTime end;
    private int age;
    private double price;

    public Hiker() {}

    public Hiker(Long id, String name, LocalDateTime start, LocalDateTime end, int age, double price) {
        this.id = id;
        this.name = name;
        this.start = start;
        this.end = end;
        this.age = age;
        this.price = price;
    }

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
    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hiker hiker = (Hiker) o;
        return age == hiker.age &&
                Double.compare(hiker.price, price) == 0 &&
                Objects.equals(id, hiker.id) &&
                Objects.equals(name, hiker.name) &&
                Objects.equals(start, hiker.start) &&
                Objects.equals(end, hiker.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, start, end, age, price);
    }

    @Override
    public String toString() {
        return "Hiker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", age=" + age +
                ", price=" + price +
                '}';
    }
}
