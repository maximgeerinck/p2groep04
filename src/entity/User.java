package entity;


import java.util.Collection;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import model.AbstractUser;

/**
 * @author Maxim
 */

@Entity
@Table(name = "user")
public class User extends AbstractUser 
{
    
    public static final String ROLE_PROMOTOR = "ROLE_PROMOTOR";
    public static final String ROLE_BPC = "ROLE_BPC";
    public static final String ROLE_STUDENT = "ROLE_STUDENT";
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected int id;

    @ManyToMany
    @JoinTable(name = "user_student",
        joinColumns={@JoinColumn(name="promotor_id", referencedColumnName="id")},
        inverseJoinColumns={@JoinColumn(name="student_id", referencedColumnName="id")}        
    )
    private Collection<User> students;
    
    @ManyToMany(mappedBy = "students", cascade = CascadeType.PERSIST)
    private Collection<User> promotors;
    
    @ManyToMany
    @JoinTable(name = "presentation_guest",
        joinColumns=@JoinColumn(name="guest_id", referencedColumnName="id"),
        inverseJoinColumns=@JoinColumn(name="presentation_id", referencedColumnName="id")
    )
    private Collection<Presentation> presentationsAttending;   
    
    @javax.persistence.OneToMany
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    protected Collection<Planning> plannings;

    @ManyToOne(optional=false)
    @JoinColumn(name="presentation_id", referencedColumnName="id")
    private Presentation presentation;
    
    @ManyToMany
    @JoinTable(name = "user_role",
        joinColumns={@JoinColumn(name="user_id", referencedColumnName="id")},
        inverseJoinColumns={@JoinColumn(name="role_id", referencedColumnName="id")}        
    )
    protected List<Role> roles;
    
    private List<String> notifications;
    
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
    
    public void addNotification(String notification)
    {
        this.notifications.add(notification);
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
    
    public Collection<Presentation> getPresentationsAttending() {
        return this.presentationsAttending;
    }

    public void setPresentationsAttending(Collection<Presentation> presentationsAttending) {
        this.presentationsAttending = presentationsAttending;
    }

    public Collection<User> getPromotors() {
        return promotors;
    }

    public void setPromotors(Collection<User> promotors) {
        this.promotors = promotors;
    }

    public Collection<Planning> getPlannings() {
        return plannings;
    }

    public void setPlannings(Collection<Planning> plannings) {
        this.plannings = plannings;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
    

    @Override
    public String toString() {
        return String.format("%s %s", this.firstName, this.lastName); 
    }
    
}