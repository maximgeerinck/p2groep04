package entity;

import java.io.*;
import java.util.*;
import javax.persistence.*;

/**
 * @author Bram
 */
@javax.persistence.Entity
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