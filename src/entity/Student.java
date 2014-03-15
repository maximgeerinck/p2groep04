/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.util.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

/**
 *
 * @author Bram
 */
@Entity
public class Student extends User{

	private Presentation presentation;
	private Collection<Suggestion> suggestion;
	@ManyToMany(mappedBy="students", cascade=CascadeType.PERSIST)
	private Collection<User> promotors;

	public Collection<User> getPromotors() {
		return this.promotors;
	}

	public void setPromotors(Collection<User> promotors) {
		this.promotors = promotors;
	}

	public Student() {
		// TODO - implement Student.Student
		throw new UnsupportedOperationException();
	}
    
}
