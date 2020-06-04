package com.hiker.entity;

import java.time.LocalTime;

public class Hiker {
    private int id;
    private String name;
    private LocalTime start;
    private LocalTime end;
    private int age;
    private double price;

    public Hiker() {}

    public Hiker(int id, String name, LocalTime start, LocalTime end, int age, double price) {
        this.id = id;
        this.name = name;
        this.start = start;
        this.end = end;
        this.age = age;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Throwable getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalTime getStart() {
        return start;
    }

    public void setStart(LocalTime start) {
        this.start = start;
    }

    public LocalTime getEnd() {
        return end;
    }

    public void setEnd(LocalTime end) {
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
