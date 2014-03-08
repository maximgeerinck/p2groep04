package entity;

import model.*;
import java.util.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author Maxim
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "user")
public class User extends AbstractUser 
{

    @ManyToMany
    @JoinTable(name = "UserStudent",
        joinColumns=@JoinColumn(name="user_id", referencedColumnName="id"),
        inverseJoinColumns=@JoinColumn(name="student_id", referencedColumnName="id")        
    )
    private Collection<User> students;
    
    @ManyToMany
    @JoinTable(name = "PresentationGuest",
        joinColumns=@JoinColumn(name="guest_id", referencedColumnName="id")  
    )
    private Collection<Presentation> presentationsAttending;
    
    @OneToMany(targetEntity = GuestRequest.class)
    private Collection<GuestRequest> guestRequests;
    
    @ManyToOne(optional=false)
    @JoinColumn(name="presentation_id", referencedColumnName="id")
    private Presentation presentation;
    
    @Column(name="amount_of_students")
    private int amountOfStudents = 0;
    
    private Collection<Suggestion> suggestion;

    public User() 
    {
    }

    @PrePersist
    public void onCreate() {
        // TODO - implement User.onCreate
        throw new UnsupportedOperationException();
    }

    public boolean isPromotor() {
        // TODO - implement User.isPromotor
        throw new UnsupportedOperationException();
    }

    public boolean isBPC() {
        // TODO - implement User.isBPC
        throw new UnsupportedOperationException();
    }

    public boolean hasPromotor() {
        // TODO - implement User.hasPromotor
        throw new UnsupportedOperationException();
    }

    public Collection<User> getStudents() {
        return this.students;
    }

    public void setStudents(Collection<User> students) {
        this.students = students;
    }

    public Collection<GuestRequest> getGuestRequests() {
        return this.guestRequests;
    }

    public void setGuestRequests(Collection<GuestRequest> guestRequests) {
        this.guestRequests = guestRequests;
    }

    public Presentation getPresentation() {
        return this.presentation;
    }

    public void setPresentation(Presentation presentation) {
        this.presentation = presentation;
    }

    public int getAmountOfStudents() {
        return this.amountOfStudents;
    }

    public void setAmountOfStudents(int amountOfStudents) {
        this.amountOfStudents = amountOfStudents;
    }

    public Collection<Suggestion> getSuggestion() {
        return this.suggestion;
    }

    public void setSuggestion(Collection<Suggestion> suggestion) {
        this.suggestion = suggestion;
    }

    public Collection<Presentation> getPresentationsAttending() {
        return this.presentationsAttending;
    }

    public void setPresentationsAttending(Collection<Presentation> presentationsAttending) {
        this.presentationsAttending = presentationsAttending;
    }

}