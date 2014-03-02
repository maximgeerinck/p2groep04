/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import de.jaret.util.date.IntervalImpl;
import de.jaret.util.date.JaretDate;
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
import model.CalendarModel;
import org.joda.time.DateTime;

@Entity
@Table(name = "Presentation") 
public class Presentation extends IntervalImpl implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "start_time")
    private Timestamp startTime;
    
    @Column(name = "end_time")
    private Timestamp endTime;
    
    @ManyToOne(targetEntity = Location.class, fetch = FetchType.LAZY)
    private Location location;
    
    @ManyToMany
    private List<User> users;
    
    @ManyToMany(mappedBy = "presentations")
    private List<Planning> plannings;
    
    private transient boolean editable;

    public Presentation() 
    {
        
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
    
    private JaretDate correct(JaretDate realBegin) {
        return CalendarModel.BASEDATE.copy().setTime(realBegin.getHours(), realBegin.getMinutes(), realBegin.getSeconds());
    }
    
    protected void changed() {
        // set the last changed date to now
        // if the last change date is already in the future (that may happen when synchronizing with
        // external systems) set is to be after that date in the future
        /*JaretDate d = new JaretDate();
        if (_lastChangeDate == null || d.compareTo(_lastChangeDate) > 0) {
            _lastChangeDate = d;
        } else {
            _lastChangeDate.advanceMinutes(1);
        }*/

    }
    
    @Override
    public JaretDate getBegin() {
        return new JaretDate(this.startTime);
    }
    
    @Override
    public JaretDate getEnd() {
        return new JaretDate(this.endTime);
    }
    
}
