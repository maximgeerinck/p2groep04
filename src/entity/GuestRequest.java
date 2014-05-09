package entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * @author Maxim
 */
@Entity
public class GuestRequest implements Serializable 
{    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "presentation_id")
    private Presentation presentation;
    
    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;
    
    @Column(name="approved")
    private boolean approved;
    
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    
    public boolean isApproved() {
            return this.approved;
    }

    public void setApproved(boolean approved) {
            this.approved = approved;
    }

    public int getId() {
            return this.id;
    }

    public void setId(int id) {
            this.id = id;
    }
    
    public Presentation getPresentation() {
        return presentation;
    }

    public void setPresentation(Presentation presentation) {
        this.presentation = presentation;
    }
    
    public GuestRequest() {}

}