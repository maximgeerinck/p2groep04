package entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;



@Entity
public class Presentation implements Serializable 
{

    @ManyToOne(optional=false)
    @JoinColumn(name="user_id", referencedColumnName="id")
    private User user;
    
    @ManyToOne(optional=false)
    @JoinColumn(name="planning_id", referencedColumnName="id")
    private Planning planning;
    
    @OneToMany
    private Collection<GuestRequest> guestRequests;
    
    @ManyToMany
    @JoinTable(name = "PresentationGuest",
        inverseJoinColumns=@JoinColumn(name="presentation_id", referencedColumnName="id")        
    )
    private Collection<User> guests;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="editable")
    private transient boolean editable;
    
    @JoinColumn(name="location_id", referencedColumnName="id")
    @ManyToOne(fetch=FetchType.LAZY, optional=false)
    private Location location;

    @Transient
    private TimeFrame timeFrame;
    
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
    public Presentation(Timestamp startTime, Timestamp endTime, Location location) {
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