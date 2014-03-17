package entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * @author Maxim
 */
@Entity
public class GuestRequest implements Serializable {

    private Presentation presentation;
    
    @OneToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;
    
    @Column(name="approved")
    private boolean approved;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ïd")
    private int id;

    public Student getStudent() {
        return this.student;
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

    public GuestRequest() {}

}