package entity;

import java.io.*;
import java.util.*;
import javax.persistence.*;

/**
 * @author Bram
 */
@javax.persistence.Entity
public class Suggestion implements Serializable 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private User user;
	private String subject;
	private ResearchDomain researchDomain;

	@javax.persistence.Transient
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@javax.persistence.Column(name="subject")
	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@javax.persistence.Transient
	public ResearchDomain getResearchDomain() {
		return this.researchDomain;
	}

	public void setResearchDomain(ResearchDomain researchDomain) {
		this.researchDomain = researchDomain;
	}

	public Suggestion() {
		// TODO - implement Suggestion.Suggestion
		throw new UnsupportedOperationException();
	}

	
}