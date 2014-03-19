/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.util.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author Bram
 */
@Entity
@Table(name = "promotor")
public class Promotor extends User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected int id;
    
    @Column(name="amount_of_students")
    private int amountOfStudents = 0;
    
    @ManyToMany()
    @JoinTable(name="user_student", joinColumns={@JoinColumn(name="promotor_id", referencedColumnName="id")}, inverseJoinColumns={@JoinColumn(name="student_id", referencedColumnName="id")})
    private List<Student> students;

    public int getAmountOfStudents() {
        return this.amountOfStudents;
    }

    public void setAmountOfStudents(int amountOfStudents) {
        this.amountOfStudents = amountOfStudents;
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Promotor() {

    }
    
}
