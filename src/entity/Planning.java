package entity;

import java.util.*;
import javax.persistence.*;

@javax.persistence.Entity
public class Planning {

	@javax.persistence.Transient
	private Collection<Presentation> presentation;
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int id;
	private boolean visible;
	@Column(name="start_time")
	private java.sql.Timestamp startTime;
	@Column(name="end_time")
	private java.sql.Timestamp endTime;
	@Column(name="allowed_to_view")
	private String allowedToView;

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

}