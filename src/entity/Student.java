/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.util.*;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Bram
 */
@Entity
@Table(name = "student")
public class Student extends User{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected int id;
    
    @OneToOne
    @JoinColumn(name = "presentation_id", referencedColumnName = "id")
    private Presentation presentation;
    
    @OneToMany
    private Collection<Suggestion> suggestions;
    
    @ManyToMany(mappedBy="students", cascade=CascadeType.PERSIST)
    private Collection<Promotor> promotors;

    public Collection<Promotor> getPromotors() {
        return this.promotors;
    }

    public void setPromotors(Collection<Promotor> promotors) {
        this.promotors = promotors;
    }

    public Student() {
    }
}
