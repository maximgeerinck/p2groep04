package entity;

import java.io.*;
import java.sql.Timestamp;
import javax.persistence.*;

/**
 * @author Bram
 */
@javax.persistence.Entity
public class TimeFrame implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Timestamp startTime;
    private Timestamp endTime;

    public int getId() {
        return id;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

	public TimeFrame() {
		// TODO - implement TimeFrame.TimeFrame
		throw new UnsupportedOperationException();
	}

}
