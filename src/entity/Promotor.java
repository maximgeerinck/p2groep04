/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.util.*;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author Bram
 */
@Entity
@DiscriminatorValue("Promotor")
public class Promotor extends User
{
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
