/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import org.joda.time.DateTime;
import java.util.*;

@javax.persistence.Entity 
public class Presentation implements Serializable
{
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@javax.persistence.Column(name="id", nullable=false)
    private int id;
    
    @Column(name = "start_time")
    private Timestamp startTime;
    
    @Column(name = "end_time")
    private Timestamp endTime;
    
    @javax.persistence.ManyToOne(fetch=FetchType.LAZY, optional=false)
	@javax.persistence.JoinColumn(name="Presentationid", referencedColumnName="id")
    private Location location;
    
    @javax.persistence.Transient
    private List<User> users;
    
    @javax.persistence.Transient
    private List<Planning> plannings;
    
    private transient boolean editable;
	@javax.persistence.Transient
	private User user;
	@javax.persistence.Transient
	private Planning planning;
	@javax.persistence.Transient
	private Collection<GuestRequest> guestRequests;
	@javax.persistence.Transient
	private Collection<User> guests;

    public Presentation() {
    }

    public Presentation(Timestamp startTime, Timestamp endTime, Location location) 
    {
        setStartTime(startTime);
        setEndTime(endTime);
        setLocation(location);
        //changed();
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;        
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Planning> getPlannings() {
        return plannings;
    }

    public void setPlannings(List<Planning> plannings) {
        this.plannings = plannings;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }
    
    public String toDisplayString() 
    {
        // convert to datetime 
        DateTime start = new DateTime(getStartTime());
        DateTime end = new DateTime(getEndTime());
        
        return start.toString("HH:mm") + " - " + end.toString("HH:mm");
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }   
}
