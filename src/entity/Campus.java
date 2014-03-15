package entity;

import javax.persistence.*;

/**
 * @author Bram
 */
@javax.persistence.Entity
public class Campus {

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="address")
	private String address;

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

	@javax.persistence.Column(name="address")
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Campus() {
		// TODO - implement Campus.Campus
		throw new UnsupportedOperationException();
	}

	public String toString() {
		// TODO - implement Campus.toString
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param name
	 */
	public Campus(String name) {
		// TODO - implement Campus.Campus
		throw new UnsupportedOperationException();
	}

}