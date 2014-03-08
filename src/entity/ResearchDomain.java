package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;


/**
 * @author Bram
 */

@Entity
public class ResearchDomain implements Serializable {

    @Transient
    private Collection<Suggestion> suggestions;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    
    @Column(name="name")
    private String name;

    public ResearchDomain() 
    {
    }
        
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Suggestion> getSuggestions() {
        return this.suggestions;
    }

    public void setSuggestions(Collection<Suggestion> suggestions) {
        this.suggestions = suggestions;
    }
}