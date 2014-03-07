/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.sql.Timestamp;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Entity;
import java.util.*;


@Entity
public class Planning 
{
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	@javax.persistence.Column(name="id", nullable=false)
    private int id;
    
    private int visible;
    
    @Column(name = "start_time")
    private Timestamp startTime;
    
    @Column(name = "end_time")
    private Timestamp endTime;
    
    @Column(name = "allowed_to_view")
    private String allowedToView;
    
    @Column(name = "created_by")
    private int createdBy;
    
    @javax.persistence.Transient
    private List<Presentation> presentations;
    
    @javax.persistence.OneToOne(optional=false)
	@javax.persistence.JoinColumn(name="Planningid4", referencedColumnName="id", nullable=false)
    private User user;
	@javax.persistence.Transient
	private Collection<Presentation> presentation;
    
        
}
