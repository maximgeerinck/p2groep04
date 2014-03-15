package entity;

import java.io.*;
import java.util.*;
import javax.persistence.*;

/**
 * @author Bram
 */
@javax.persistence.Entity
public class TimeFrame implements Serializable {

    private Collection<Presentation> presentations;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "start_time")
    private java.sql.Time startTime;
    @Column(name = "end_time")
    private java.sql.Time endTime;

    @javax.persistence.Id
    @javax.persistence.GeneratedValue(strategy = GenerationType.IDENTITY)
    @javax.persistence.Column(name = "id")
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @javax.persistence.Column(name = "start_time")
    public java.sql.Time getStartTime() {
        return this.startTime;
    }

    public void setStartTime(java.sql.Time startTime) {
        this.startTime = startTime;
    }

    @javax.persistence.Column(name = "end_time")
    public java.sql.Time getEndTime() {
        return this.endTime;
    }

    public void setEndTime(java.sql.Time endTime) {
        this.endTime = endTime;
    }

    public TimeFrame() {
    }

    @Override
    public String toString() {
        return startTime + " - " + endTime;
    }

}
