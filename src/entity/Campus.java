package entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * @author Bram
 */
@Entity
public class Campus implements Serializable 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

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

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Campus() {
    }

    public Campus(String name) {
        setName(name);
    }

    public String toString() {
        return this.name;
    }
}
