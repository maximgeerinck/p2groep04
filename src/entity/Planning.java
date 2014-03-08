package entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;


@Entity
public class Planning implements Serializable 
{
    @Transient
    private Collection<Presentation> presentation;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @Column(name="visible")
    private boolean visible;
    
    @Column(name="start_time")
    private Timestamp startTime;
    
    @Column(name="end_time")
    private Timestamp endTime;
    
    @Column(name="allowed_to_view")
    private String allowedToView;

    public Planning() 
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

    public Collection<Presentation> getPresentation() {
        return this.presentation;
    }

    public void setPresentation(Collection<Presentation> presentation) {
        this.presentation = presentation;
    }
}