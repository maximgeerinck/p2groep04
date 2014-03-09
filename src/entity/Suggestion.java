package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;



/**
 * @author Bram
 */

@Entity
public class Suggestion implements Serializable 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @javax.persistence.ManyToOne(optional=false)
    @javax.persistence.JoinColumn(name="user_id", referencedColumnName="id")
    private User user;
    
    @Column(name="subject")
    private String subject;
    
    @javax.persistence.ManyToOne(optional=false)
    @javax.persistence.JoinColumn(name="research_domain_id", referencedColumnName="id")
    private ResearchDomain researchDomain;

    public Suggestion() 
    {
    }
    
    @Transient
    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public ResearchDomain getResearchDomain() {
        return this.researchDomain;
    }

    public void setResearchDomain(ResearchDomain researchDomain) {
        this.researchDomain = researchDomain;
    }	

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return subject;
    }
}