package entity;

import java.util.*;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

/**
 * @author Maxim
 */
@MappedSuperclass
public class User {

    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected int id;

    @Column(name = "email")
    protected String email;

    @Column(name = "first_name")
    protected String firstName;

    @Column(name = "last_name")
    protected String lastName;

    @Column(name = "password")
    protected String password;

    @Column(name = "salt")
    protected String salt;

    @Column(name = "last_login")
    protected java.sql.Timestamp lastLogin;

    @Column(name = "last_ip")
    protected String lastIp;

    @Column(name = "created_on")
    protected java.sql.Timestamp createdOn;

    @Column(name = "updated_on")
    protected java.sql.Timestamp updatedOn;

    @Column(name = "enabled")
    protected int enabled;

    @ManyToMany
    @JoinTable(name = "presentation_guest", joinColumns = @JoinColumn(name = "guest_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "presentation_id", referencedColumnName = "id"))
    protected Collection<Presentation> presentationsAttending;

    @OneToMany
    @JoinColumn(name = "bpcoordinator_id", referencedColumnName = "id")
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

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public Collection<Presentation> getPresentationsAttending() {
        return this.presentationsAttending;
    }

    public void setPresentationsAttending(Collection<Presentation> presentationsAttending) {
        this.presentationsAttending = presentationsAttending;
    }

    public Collection<Planning> getPlannings() {
        return this.plannings;
    }

    public void setPlannings(Collection<Planning> plannings) {
        this.plannings = plannings;
    }

    public User() {
    }

    @PrePersist()
    public void onCreate() {

    }

    @Override()
    public String toString() {
        return this.lastName + " " + this.firstName;
    }
    
    public void sendMail(){
       
    }

}
