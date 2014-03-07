package entity;

import java.io.*;
import java.util.*;
import javax.persistence.*;

/**
 * @author Bram
 */
@javax.persistence.Entity
public class ResearchDomain implements Serializable {

	@javax.persistence.Transient
	private Collection<Suggestion> suggestions;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;

	@javax.persistence.Id
	@javax.persistence.GeneratedValue(strategy=GenerationType.IDENTITY)
	@javax.persistence.Column(name="id")
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@javax.persistence.Column(name="name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}