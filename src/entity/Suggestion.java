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
    private int id;

    @ManyToOne(optional=false)
    @JoinColumn(name="user_id", referencedColumnName="id")
    private User user;
    
    @Column(name="subject")
    private String subject;
    
    @ManyToOne(optional=false)
    @JoinColumn(name="research_domain_id", referencedColumnName="id")
    private ResearchDomain researchDomain;

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

    public Suggestion() 
    {
    }	

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}