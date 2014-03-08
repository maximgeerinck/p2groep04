package entity;

import java.io.*;
import java.util.*;
import javax.persistence.*;

@javax.persistence.Entity
public class Presentation implements Serializable {

	@javax.persistence.Transient
	private User user;
	@javax.persistence.Transient
	private Planning planning;
	@javax.persistence.Transient
	private Collection<GuestRequest> guestRequests;
	@javax.persistence.Transient
	private Collection<User> guests;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private transient boolean editable;
	@javax.persistence.ManyToOne(fetch=FetchType.LAZY, optional=false)
	@javax.persistence.JoinColumn(name="Presentationid", referencedColumnName="id")
	private Location location;
        
        @javax.persistence.Transient
	private TimeFrame timeFrame;

	@javax.persistence.Id
	@javax.persistence.GeneratedValue(strategy=GenerationType.IDENTITY)
	@javax.persistence.Column(name="id")
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@javax.persistence.Column(name="editable")
	public boolean isEditable() {
		return this.editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	@javax.persistence.ManyToOne(fetch=FetchType.LAZY, optional=false)
	@javax.persistence.JoinColumn(name="Presentationid", referencedColumnName="id")
	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Presentation() {
		// TODO - implement Presentation.Presentation
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param startTime
	 * @param endTime
	 * @param location
	 */
	public Presentation(java.sql.Timestamp startTime, java.sql.Timestamp endTime, Location location) {
		// TODO - implement Presentation.Presentation
		throw new UnsupportedOperationException();
	}

	public String toDisplayString() {
		// TODO - implement Presentation.toDisplayString
		throw new UnsupportedOperationException();
	}

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Planning getPlanning() {
        return planning;
    }

    public void setPlanning(Planning planning) {
        this.planning = planning;
    }

    public Collection<GuestRequest> getGuestRequests() {
        return guestRequests;
    }

    public void setGuestRequests(Collection<GuestRequest> guestRequests) {
        this.guestRequests = guestRequests;
    }

    public Collection<User> getGuests() {
        return guests;
    }

    public void setGuests(Collection<User> guests) {
        this.guests = guests;
    }

    public TimeFrame getTimeFrame() {
        return timeFrame;
    }

    public void setTimeFrame(TimeFrame timeFrame) {
        this.timeFrame = timeFrame;
    }
        
        

}