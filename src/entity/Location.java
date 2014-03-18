package entity;

import java.io.*;
import javax.persistence.*;

/**
 * @author Maxim
 */
@javax.persistence.Entity
public class Location implements Serializable 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "classroom")
    private String classroom;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "campus_id", referencedColumnName = "id")
    private Campus campus;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "classroom")
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

    public Location(Campus campus, String classroom) {
        setCampus(campus);
        setClassroom(classroom);
    }

    public Location() {
    }

    @Override
    public String toString() {
        return classroom;
    }

    /**
     *
     * @param campus
     * @param classroom
     */
	

}