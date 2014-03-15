package entity;

import java.io.*;
import javax.persistence.*;

/**
 * @author Bram
 */
@javax.persistence.Entity
public class Suggestion implements Serializable {

	private Student student;
	private ResearchDomain researchDomain;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="subject")
	private String subject;
	private User user;

	@javax.persistence.Id
	@javax.persistence.GeneratedValue(strategy=GenerationType.IDENTITY)
	@javax.persistence.Column(name="id")
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@javax.persistence.Column(name="subject")
	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Suggestion() {
		// TODO - implement Suggestion.Suggestion
		throw new UnsupportedOperationException();
	}

	@Override
	public String toString() {
		// TODO - implement Suggestion.toString
		throw new UnsupportedOperationException();
	}

}