package model;


import entity.Planning;
import entity.Presentation;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.persistence.*;

/**
 * @author Maxim
 */
@MappedSuperclass
public abstract class AbstractUser implements Serializable 
{

    @Column(name="id", nullable=true)
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    protected int id;

    @Column(name="email")
    protected String email;

    @Column(name="first_name")
    protected String fistName;

    @Column(name="last_name")
    protected String lastName;

    @Column(name="password")
    protected String password;

    @Column(name="salt")
    protected String salt;

    @Column(name="last_login")
    protected Timestamp lastLogin;

    @Column(name="last_ip")
    protected String lastIp;

    @Column(name="created_on")
    protected Timestamp createdOn;

    @Column(name="updated_on")
    protected Timestamp updatedOn;

    @Column(name="enabled")
    protected int enabled;

    @Column(name="amount_students")
    protected int amountStudents;

    @Column(name="roles")
    protected String[] roles;
    
    public AbstractUser()
    {        
    }

    /**
     * De lijst van presentaties waar de gebruiker naar toe gaat, deze presentaties zijn al in een planning opgenomen
     */
    @javax.persistence.OneToMany
	@javax.persistence.JoinColumn(name="AbstractUserid", referencedColumnName="id")
    protected Collection<Presentation> presentations;

    @javax.persistence.OneToMany
	@javax.persistence.JoinColumn(name="AbstractUserid", referencedColumnName="id", nullable=false)
    protected Collection<Planning> plannings;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
            this.email = email;
    }

    public String getFistName() {
            return this.fistName;
    }

    public void setFistName(String fistName) {
            this.fistName = fistName;
    }

    public String getLastName() {
            return this.lastName;
    }

    public void setLastName(String lastName) {
            this.lastName = lastName;
    }

    public String getPassword() {
            return this.password;
    }

    public void setPassword(String password) {
            this.password = password;
    }

    public String getSalt() {
        return this.salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public java.sql.Timestamp getLastLogin() {
        return this.lastLogin;
    }

    public void setLastLogin(java.sql.Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getLastIp() {
        return this.lastIp;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    public java.sql.Timestamp getCreatedOn() {
        return this.createdOn;
    }

    public void setCreatedOn(java.sql.Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    public java.sql.Timestamp getUpdatedOn() {
        return this.updatedOn;
    }

    public void setUpdatedOn(java.sql.Timestamp updatedOn) {
        this.updatedOn = updatedOn;
    }

    public int getEnabled() {
        return this.enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public int getAmountStudents() {
        return this.amountStudents;
    }

    public void setAmountStudents(int amountStudents) {
        this.amountStudents = amountStudents;
    }

    public String[] getRoles() {
        return this.roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    public Collection<Presentation> getPresentations() {
        return this.presentations;
    }

    public void setPresentations(Collection<Presentation> presentations) {
        this.presentations = presentations;
    }

    public Collection<Planning> getPlannings() {
        return this.plannings;
    }

    public void setPlannings(Collection<Planning> plannings) {
        this.plannings = plannings;
    }
}