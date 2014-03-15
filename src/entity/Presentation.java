package entity;

import java.io.*;
import java.sql.Timestamp;
import java.util.*;
import javax.persistence.*;

@Entity
public class Presentation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "editable")
    private transient boolean editable;
    private Location location;
    @OneToOne(optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @ManyToMany(mappedBy = "presentationsAttending", cascade = CascadeType.PERSIST)
    private Collection<User> guests;
    @Column(name = "date")
    private java.sql.Date date;
    private boolean changed = false;

    private Collection<GuestRequest> guestRequests;
    private TimeFrame timeFrame;
    private Planning planning;
    private Student presentator;
    private Timestamp endTime;
    private Timestamp startTime;

    @javax.persistence.Id
    @javax.persistence.GeneratedValue(strategy = GenerationType.IDENTITY)
    @javax.persistence.Column(name = "id")
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @javax.persistence.Column(name = "editable")
    public boolean isEditable() {
        return this.editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    @javax.persistence.ManyToOne(fetch = FetchType.LAZY, optional = false)
    @javax.persistence.JoinColumn(name = "location_id", referencedColumnName = "id")
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

    @javax.persistence.Column(name = "\"date\"")
    public Date getDate() {
        return this.date;
    }

    public void setDate(java.sql.Date date) {
        this.date = date;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    @Column(name = "changed")
    public boolean isChanged() {
        return this.changed;
    }

    public void setChanged(boolean changed) {
        this.changed = changed;
    }

    public Collection<GuestRequest> getGuestRequests() {
        return guestRequests;
    }

    public void setGuestRequests(Collection<GuestRequest> guestRequests) {
        this.guestRequests = guestRequests;
    }

    public TimeFrame getTimeFrame() {
        return timeFrame;
    }

    public void setTimeFrame(TimeFrame timeFrame) {
        this.timeFrame = timeFrame;
    }

    public Planning getPlanning() {
        return planning;
    }

    public void setPlanning(Planning planning) {
        this.planning = planning;
    }

    public Student getPresentator() {
        return presentator;
    }

    public void setPresentator(Student presentator) {
        this.presentator = presentator;
    }

    public Presentation() {
    }

    /**
     *
     * @param startTime
     * @param endTime
     * @param location
     */
    public Presentation(Timestamp startTime, Timestamp endTime, Location location) {
        setLocation(location);
        setEndTime(endTime);
        setStartTime(startTime);

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
    public Presentation(TimeFrame timeFrame, Location location) {
        setTimeFrame(timeFrame);
        setLocation(location);
    }

    public void notifyStakeholders() {
        /*
         this.getUser().addNotification("There has been a change in the planning, please check the planning for more information.");
         for (User us : this.getPromotors()) {
         us.addNotification("There has been a change in the planning, please check the planning for more information.");
         }
         for (User u : this.getGuests()) {
         u.addNotification("There has been a change in the planning, please check the planning for more information.");
         }
         */
    }

}
