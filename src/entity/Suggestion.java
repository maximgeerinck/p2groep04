package entity;

import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "suggestion_researchdomain",
            joinColumns = {@JoinColumn(name = "suggestion_id")},
            inverseJoinColumns = {@JoinColumn(name = "researchdomain_id")})
    private Set<ResearchDomain> researchDomains = new HashSet<>();

    @Column(name = "subject")
    private String subject;
    
    @Column(name = "active")
    private Boolean active;

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

    public Set<ResearchDomain> getResearchDomains() {
        return researchDomains;
    }

    public void setResearchDomains(Set<ResearchDomain> researchDomains) {
        this.researchDomains = researchDomains;
    }
    
    public Suggestion() {
    }
    
    public Boolean isActive() {
        return active;
    }

    @Override
    public String toString() {
        return subject;
    }

}
