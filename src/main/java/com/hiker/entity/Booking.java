package com.hiker.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Booking {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDate date;
    private int status;
    private Long trailId;

//    @OneToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "trail_id", nullable = false)
    @OneToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="trailId", insertable = false, updatable = false)
    private Trail trail;

    public Long getTrailId() {
        return trailId;
    }

    public void setTrailId(Long trailId) {
        this.trailId = trailId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Trail getTrail() {
        return trail;
    }

    public void setTrail(Trail trail) {
        this.trail = trail;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", date=" + date +
                ", status=" + status +
                ", trailId=" + trailId +
                ", trail=" + trail +
                '}';
    }
}
