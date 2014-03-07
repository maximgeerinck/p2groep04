/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.*;

/**
 *
 * @author Maxim
 */
@Entity
public class PlanningPresentation implements Serializable
{
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@javax.persistence.Column(name="id", nullable=false)
    private int id;
    
    @javax.persistence.ManyToOne(optional=false)
	@javax.persistence.JoinColumn(name="PlanningPresentationid4", referencedColumnName="id")
    private Planning attribute;
    
    @javax.persistence.OneToOne(optional=false)
	@javax.persistence.JoinColumn(name="PlanningPresentationid5", referencedColumnName="id")
    private Presentation attribute2;
    
    @javax.persistence.Transient
    private List<User> attribute3;
	@javax.persistence.Transient
	private Planning planning;
	@javax.persistence.Transient
	private Presentation presentation;
	@javax.persistence.Transient
	private Collection<User> users;
    
}
