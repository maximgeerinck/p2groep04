package entity;

import java.io.*;
import java.sql.Time;
import javax.persistence.*;

/**
 * @author Bram
 */
@Entity
public class TimeFrame implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="start_time")
    private Time startTime;
    
    @Column(name="end_time")
    private Time endTime;

    public TimeFrame() 
    {
    }
        
    public int getId() {
        return id;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }
}
