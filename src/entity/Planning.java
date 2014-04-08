package entity;

import java.io.*;
import java.util.*;
import javax.persistence.*;

@javax.persistence.Entity
public class Planning implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "visible")
    private boolean visible = false;

    @Column(name = "start_time")
    private java.sql.Timestamp startTime;

    @Column(name = "end_time")
    private java.sql.Timestamp endTime;

    @Column(name = "allowed_to_view")
    private String allowedToView;

    @ManyToOne
    @JoinColumn(name = "bpcoordinator_id", referencedColumnName = "id")
    private BPCoordinator bpcoordinator;
    
    @OneToMany(mappedBy = "planning", targetEntity = Presentation.class)
    private List<Presentation> presentations;

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

    public java.sql.Timestamp getStartTime() {
        return this.startTime;
    }

    public void setStartTime(java.sql.Timestamp startTime) {
        this.startTime = startTime;
    }

    public java.sql.Timestamp getEndTime() {
        return this.endTime;
    }

    public void setEndTime(java.sql.Timestamp endTime) {
        this.endTime = endTime;
    }

    public String getAllowedToView() {
        return this.allowedToView;
    }

    public void setAllowedToView(String allowedToView) {
        this.allowedToView = allowedToView;
    }

    public List<Presentation> getPresentations() {
        return presentations;
    }

    public void setPresentations(List<Presentation> presentations) {
        this.presentations = presentations;
    }

    public BPCoordinator getBpcoordinator() {
        return bpcoordinator;
    }

    public void setBpcoordinator(BPCoordinator bpcoordinator) {
        this.bpcoordinator = bpcoordinator;
    }

    public Planning() {
    }

}
