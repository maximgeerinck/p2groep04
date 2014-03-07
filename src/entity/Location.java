package entity;

import java.io.*;
import javax.persistence.*;

/**
 * @author Bram
 */
@javax.persistence.Entity
public class Location implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String classroom;
	@javax.persistence.ManyToOne(optional=false)
	@javax.persistence.JoinColumn(name="Locationid", referencedColumnName="id")
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
	@javax.persistence.JoinColumn(name="Locationid", referencedColumnName="id")
	public Campus getCampus() {
		return this.campus;
	}

	public void setCampus(Campus campus) {
		this.campus = campus;
	}

}