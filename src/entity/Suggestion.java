package entity;

import java.io.*;
import javax.persistence.*;

@Entity
public class Suggestion implements Serializable 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
     
    @ManyToOne(optional = false)
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "researchdomain_id", referencedColumnName = "id")
    private ResearchDomain researchDomain;

    @Column(name = "subject")
    private String subject;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Suggestion() {
    }

    @Override
    public String toString() {
        return subject;
    }

}
