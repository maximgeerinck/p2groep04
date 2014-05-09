package entity;

import java.io.*;
import java.util.*;
import javax.persistence.*;

@Entity
public class ResearchDomain implements Serializable 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    //@OneToMany(mappedBy = "researchDomain", targetEntity = Suggestion.class)
    //private List<Suggestion> suggestions;
    
    @ManyToMany(mappedBy = "researchDomains")
    private List<Suggestion> suggestions;
    
    @Column(name = "name")
    private String name;

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

    public ResearchDomain() {
    }

    @Override
    public String toString() {
        return name;
    }

}
