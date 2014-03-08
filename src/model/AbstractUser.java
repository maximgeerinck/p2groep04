package model;

import javax.persistence.*;
import java.io.*;
import java.util.*;
import entity.*;

/**
 * @author Maxim
 */
@MappedSuperclass
public abstract class AbstractUser implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@javax.persistence.Column(name="id", nullable=false)
	protected int id;
	protected String email;
	protected String fistName;
	protected String lastName;
	protected String password;
	protected String salt;
	protected java.sql.Timestamp lastLogin;
	protected String lastIp;
	protected java.sql.Timestamp createdOn;
	protected java.sql.Timestamp updatedOn;
	protected int enabled;
	protected int amountStudents;
	protected String[] roles;
        
	/**
	 * De lijst van presentaties waar de gebruiker naar toe gaat, deze presentaties zijn al in een planning opgenomen
	 */
	@javax.persistence.Transient
	protected Collection<Presentation> presentations;
	@javax.persistence.Transient
	protected Collection<Planning> plannings;

	@javax.persistence.Id
	@javax.persistence.GeneratedValue(strategy=GenerationType.IDENTITY)
	@javax.persistence.Column(name="id", nullable=false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@javax.persistence.Column(name="email")
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@javax.persistence.Column(name="fistName")
	public String getFistName() {
		return this.fistName;
	}

	public void setFistName(String fistName) {
		this.fistName = fistName;
	}

	@javax.persistence.Column(name="lastName")
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@javax.persistence.Column(name="password")
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@javax.persistence.Column(name="salt")
	public String getSalt() {
		return this.salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@javax.persistence.Column(name="lastLogin")
	public java.sql.Timestamp getLastLogin() {
		return this.lastLogin;
	}

	public void setLastLogin(java.sql.Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}

	@javax.persistence.Column(name="lastIp")
	public String getLastIp() {
		return this.lastIp;
	}

	public void setLastIp(String lastIp) {
		this.lastIp = lastIp;
	}

	@javax.persistence.Column(name="createdOn")
	public java.sql.Timestamp getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(java.sql.Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	@javax.persistence.Column(name="updatedOn")
	public java.sql.Timestamp getUpdatedOn() {
		return this.updatedOn;
	}

	public void setUpdatedOn(java.sql.Timestamp updatedOn) {
		this.updatedOn = updatedOn;
	}

	@javax.persistence.Column(name="enabled")
	public int getEnabled() {
		return this.enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	@javax.persistence.Column(name="amountStudents")
	public int getAmountStudents() {
		return this.amountStudents;
	}

	public void setAmountStudents(int amountStudents) {
		this.amountStudents = amountStudents;
	}

	@javax.persistence.Column(name="roles")
	public String[] getRoles() {
		return this.roles;
	}

	public void setRoles(String[] roles) {
		this.roles = roles;
	}

	@javax.persistence.Transient
	public Collection<Presentation> getPresentations() {
		return this.presentations;
	}

	public void setPresentations(Collection<Presentation> presentations) {
		this.presentations = presentations;
	}

	@javax.persistence.Transient
	public Collection<Planning> getPlannings() {
		return this.plannings;
	}

	public void setPlannings(Collection<Planning> plannings) {
		this.plannings = plannings;
	}

	public AbstractUser() {
		// TODO - implement AbstractUser.AbstractUser
		throw new UnsupportedOperationException();
	}

}