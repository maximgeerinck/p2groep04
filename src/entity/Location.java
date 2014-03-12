package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



/**
 * @author Maxim
 */
@Entity
public class Location implements Serializable 
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name="classroom")
    private String classroom;
    
    @javax.persistence.ManyToOne(optional=false)
	@javax.persistence.JoinColumn(name="campus_id", referencedColumnName="id")
    private Campus campus;

    public Location() 
    {
    }

    public Location(Campus campus, String classroom)
    {
        setCampus(campus);
        setClassroom(classroom);
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

    @Override
    public String toString() {
        return classroom;
    }
        
}