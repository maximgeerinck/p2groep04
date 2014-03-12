package entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Planning implements Serializable 
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name="visible")
    private boolean visible;
    
    @Column(name="start_time")
    private Timestamp startTime;
    
    @Column(name="end_time")
    private Timestamp endTime;
    
    @Column(name="allowed_to_view")
    private String allowedToView;
    
    @javax.persistence.OneToMany(mappedBy = "planning")
    @JoinColumn(name = "planning_id")
    private Collection<Presentation> presentations;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    
    private Timestamp visibleStart;
    
    private Timestamp visibleEnd;
    
    private Planning() 
    {
    }
    
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isVisible() {
        return this.visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public Timestamp getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return this.endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public String getAllowedToView() {
        return this.allowedToView;
    }

    public void setAllowedToView(String allowedToView) {
        this.allowedToView = allowedToView;
    }

    public Collection<Presentation> getPresentations() {
        return presentations;
    }

    public void setPresentations(Collection<Presentation> presentations) {
        this.presentations = presentations;
    }     

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    } 

    public void setVisibleStart(Timestamp visibleStart) {
        this.visibleStart = visibleStart;
    }

    public void setVisibleEnd(Timestamp visibleEnd) {
        this.visibleEnd = visibleEnd;
    }

    public Timestamp getVisibleStart() {
        return visibleStart;
    }

    public Timestamp getVisibleEnd() {
        return visibleEnd;
    }
    
    
}