package entity;


import java.util.Collection;
import javax.persistence.CascadeType;
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
import model.AbstractUser;

/**
 * @author Maxim
 */

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "user")
public class User extends AbstractUser 
{

    @ManyToMany(mappedBy = "promotors", cascade = CascadeType.PERSIST)
    @JoinTable(name = "user_student",
        joinColumns=@JoinColumn(name="promotor_id", referencedColumnName="id"),
        inverseJoinColumns=@JoinColumn(name="student_id", referencedColumnName="id")        
    )
    private Collection<User> students;
    
    private Collection<User> promotors;
    
    @ManyToMany(mappedBy="guests", cascade = CascadeType.PERSIST)
    @JoinTable(name = "presentation_guest",
        joinColumns=@JoinColumn(name="guest_id", referencedColumnName="id"),
        inverseJoinColumns=@JoinColumn(name="presentation_id", referencedColumnName="id")
    )
    private Collection<Presentation> presentationsAttending;   
    
    @ManyToOne(optional=false)
    @JoinColumn(name="presentation_id", referencedColumnName="id")
    private Presentation presentation;
    
    @Column(name="amount_of_students")
    private int amountOfStudents = 0;
    
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
    
    public Collection<Presentation> getPresentationsAttending() {
        return this.presentationsAttending;
    }

    public void setPresentationsAttending(Collection<Presentation> presentationsAttending) {
        this.presentationsAttending = presentationsAttending;
    }

}