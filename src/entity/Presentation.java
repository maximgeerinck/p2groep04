package entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



@Entity
public class Presentation implements Serializable 
{

    @OneToOne(optional=false)
    @JoinColumn(name="user_id", referencedColumnName="id")
    private User user;
    
    @ManyToOne(optional=false)
    @JoinColumn(name="planning_id", referencedColumnName="id")
    private Planning planning;
    
    @OneToMany(mappedBy="presentation")
    private Collection<GuestRequest> guestRequests;
    
    @ManyToMany(mappedBy="presentationsAttending", cascade = CascadeType.PERSIST)
    private Collection<User> guests;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="editable")
    private transient boolean editable;
    
    @javax.persistence.ManyToOne(fetch=FetchType.LAZY, optional=false)
    @javax.persistence.JoinColumn(name="location_id", referencedColumnName="id")
    private Location location;

    @javax.persistence.OneToOne(optional=false)
    @javax.persistence.JoinColumn(name="timeframe_id", referencedColumnName="id")
    private TimeFrame timeFrame;
    
    @Column(name = "date")
    private Date date;
    
    private boolean changed = false;
    
    private List<User> promotors;
    
    public Presentation() 
    {
    }
    
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isEditable() {
        return this.editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * 
     * @param startTime
     * @param endTime
     * @param location
     */
    public Presentation(TimeFrame timeFrame, Location location) {
        setTimeFrame(timeFrame);
        setLocation(location);
    }

    public void notifyStakeholders()
    {
        this.getUser().addNotification("There has been a change in the planning, please check the planning for more information.");
        for(User us: this.getPromotors())
        {
            us.addNotification("There has been a change in the planning, please check the planning for more information.");
        }
        for(User u: this.getGuests())
        {
            u.addNotification("There has been a change in the planning, please check the planning for more information.");
        }
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isChanged() {
        return changed;
    }

    public void setChanged(boolean changed) {
        this.changed = changed;
    }

    public List<User> getPromotors() {
        return promotors;
    }

    public void setPromotors(List<User> promotors) {
        this.promotors = promotors;
    }
    
    
    
    
}