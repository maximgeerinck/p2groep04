/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Entity;

/**
 *
 * @author Bram
 */
@Entity
public class Location implements Serializable
{   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @javax.persistence.ManyToOne(optional=false)
	@javax.persistence.JoinColumn(name="Locationid", referencedColumnName="id")
    private Campus campus;
    
    private String classroom;
    
}