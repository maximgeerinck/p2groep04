package entity;

import java.io.*;
import javax.persistence.*;

/**
 * @author Maxim
 */
@Entity
public class Location implements Serializable 
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @Column(name="classroom")
    private String classroom;
    
    @ManyToOne(optional=false)
    @JoinColumn(name="campus_id", referencedColumnName="id")
    private Campus campus;

    public Location() 
    {
    }
    
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassroom() {
        return this.classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public Campus getCampus() {
        return this.campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }
}