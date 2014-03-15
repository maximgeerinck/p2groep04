package entity;

import java.io.*;
import javax.persistence.*;

/**
 * @author Maxim
 */
@javax.persistence.Entity
public class Location implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="classroom")
	private String classroom;
	private Campus campus;

	@javax.persistence.Id
	@javax.persistence.GeneratedValue(strategy=GenerationType.IDENTITY)
	@javax.persistence.Column(name="id")
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@javax.persistence.Column(name="classroom")
	public String getClassroom() {
		return this.classroom;
	}

	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}

	@javax.persistence.ManyToOne(optional=false)
	@javax.persistence.JoinColumn(name="campus_id", referencedColumnName="id")
	public Campus getCampus() {
		return this.campus;
	}

	public void setCampus(Campus campus) {
		this.campus = campus;
	}

	public Location() {
		// TODO - implement Location.Location
		throw new UnsupportedOperationException();
	}

	@Override
	public String toString() {
		// TODO - implement Location.toString
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param campus
	 * @param classroom
	 */
	public Location(entity.Campus campus, String classroom) {
		// TODO - implement Location.Location
		throw new UnsupportedOperationException();
	}

}