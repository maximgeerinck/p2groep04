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

    @OneToOne
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;

    @ManyToMany(mappedBy = "presentationsAttending", cascade = CascadeType.PERSIST)
    private Collection<Student> guests;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    
    @OneToMany
    private Collection<GuestRequest> guestRequests;
    
    @OneToOne
    @JoinColumn(name = "timeframe_id", referencedColumnName = "id")
    private TimeFrame timeFrame;
    
    @ManyToOne
    @JoinColumn(name = "planning_id", referencedColumnName = "id")
    private Planning planning;

    @OneToOne(optional = false)
    @JoinColumn(name = "presentator_id", referencedColumnName = "id")
    private Student presentator;

    @Column(name = "end_time")
    private Timestamp endTime;
    
    @Column(name = "start_time")
    private Timestamp startTime;
    
    @OneToOne
    @JoinColumn(name = "promotor_id", referencedColumnName = "id")
    private Promotor promotor;
    
    @OneToOne
    @JoinColumn(name = "copromotor_id", referencedColumnName = "id")
    private Promotor coPromotor;

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

    public Collection<Student> getGuests() {
        return guests;
    }

    public void setGuests(Collection<Student> guests) {
        this.guests = guests;
    }

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

    public Promotor getPromotor() {
        return promotor;
    }

    public void setPromotor(Promotor promotor) {
        this.promotor = promotor;
    }

    public Promotor getCoPromotor() {
        return coPromotor;
    }

    public void setCoPromotor(Promotor coPromotor) {
        this.coPromotor = coPromotor;
    }    
/**
    public String toDisplayString() {
        // TODO - implement Presentation.toDisplayString
        throw new UnsupportedOperationException();
    }
*/
    /**
     *
     * @param timeFrame
     * @param location
     */
    public Presentation(TimeFrame timeFrame, Location location) {
        setTimeFrame(timeFrame);
        setLocation(location);
    }
    public void notifyStakeHolders(Planning planning){
       
         List<Presentation> presentations = new ArrayList<>();
         List<User> users = new ArrayList<>();
         
         presentations.addAll(planning.getPresentations());
         
         for(Presentation p: presentations)
         {
            
            users.add(p.getPresentator());
            users.addAll(p.getGuests()); 
            
         }
         
         for(User u: users)
         {
             u.sendMail();
         }
         
             
     }

}
