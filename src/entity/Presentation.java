package entity;

import java.io.*;
import java.util.*;
import javax.persistence.*;

@Entity
public class Presentation implements Serializable {

	private Collection<GuestRequest> guestRequests;
	private TimeFrame timeFrame;
	private Planning planning;
	private Student presentator;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="editable")
	private transient boolean editable;
	private Location location;
	@OneToOne(optional=false)
	@JoinColumn(name="user_id", referencedColumnName="id")
	private User user;
	@ManyToMany(mappedBy="presentationsAttending", cascade=CascadeType.PERSIST)
	private Collection<User> guests;
	@Column(name="date")
	private java.sql.Date date;
	private boolean changed = false;

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
	@javax.persistence.JoinColumn(name="location_id", referencedColumnName="id")
	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@javax.persistence.Transient
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@javax.persistence.Transient
	public Collection<User> getGuests() {
		return this.guests;
	}

	public void setGuests(Collection<User> guests) {
		this.guests = guests;
	}

	@javax.persistence.Column(name="\"date\"")
	public java.sql.Date getDate() {
		return this.date;
	}

	public void setDate(java.sql.Date date) {
		this.date = date;
	}

	@javax.persistence.Column(name="changed")
	public boolean isChanged() {
		return this.changed;
	}

	public void setChanged(boolean changed) {
		this.changed = changed;
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

	/**
	 * 
	 * @param timeFrame
	 * @param location
	 */
	public Presentation(entity.TimeFrame timeFrame, entity.Location location) {
		// TODO - implement Presentation.Presentation
		throw new UnsupportedOperationException();
	}

	public void notifyStakeholders() {
		// TODO - implement Presentation.notifyStakeholders
		throw new UnsupportedOperationException();
	}

}