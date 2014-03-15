package entity;

import java.io.*;
import java.util.*;
import javax.persistence.*;

@javax.persistence.Entity
public class Planning implements Serializable {

	private Collection<Presentation> presentations;
	private BPCoordinator bpCoordinator;
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	@Column(name="id")
	private int id;
	@Column(name="visible")
	private boolean visible;
	@Column(name="start_time")
	private java.sql.Timestamp startTime;
	@Column(name="end_time")
	private java.sql.Timestamp endTime;
	@Column(name="allowed_to_view")
	private String allowedToView;
	@ManyToOne
	@JoinColumn(name="user_id", referencedColumnName="id")
	private User user;
	private java.sql.Timestamp visibleStart;
	private java.sql.Timestamp visibleEnd;

	@javax.persistence.Id
	@javax.persistence.GeneratedValue(strategy=GenerationType.IDENTITY)
	@javax.persistence.Column(name="id")
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@javax.persistence.Column(name="visible")
	public boolean isVisible() {
		return this.visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	@javax.persistence.Column(name="start_time")
	public java.sql.Timestamp getStartTime() {
		return this.startTime;
	}

	public void setStartTime(java.sql.Timestamp startTime) {
		this.startTime = startTime;
	}

	@javax.persistence.Column(name="end_time")
	public java.sql.Timestamp getEndTime() {
		return this.endTime;
	}

	public void setEndTime(java.sql.Timestamp endTime) {
		this.endTime = endTime;
	}

	@javax.persistence.Column(name="allowed_to_view")
	public String getAllowedToView() {
		return this.allowedToView;
	}

	public void setAllowedToView(String allowedToView) {
		this.allowedToView = allowedToView;
	}

	@javax.persistence.Transient
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@javax.persistence.Column(name="visibleStart")
	public java.sql.Timestamp getVisibleStart() {
		return this.visibleStart;
	}

	public void setVisibleStart(java.sql.Timestamp visibleStart) {
		this.visibleStart = visibleStart;
	}

	@javax.persistence.Column(name="visibleEnd")
	public java.sql.Timestamp getVisibleEnd() {
		return this.visibleEnd;
	}

	public void setVisibleEnd(java.sql.Timestamp visibleEnd) {
		this.visibleEnd = visibleEnd;
	}

	public Planning() {}

}