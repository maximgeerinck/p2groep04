/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Maxim
 */
@Entity
public class GuestRequest 
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ïd")
    private int id;
    
    @Column(name="approved")
    private boolean approved;
        
    @javax.persistence.ManyToOne(optional=false)
    @JoinColumn(name = "guest_id", referencedColumnName = "id")
    private User guest;
        
    @javax.persistence.ManyToOne(optional=false)
    @JoinColumn(name = "presentation_id", referencedColumnName = "id")
    private Presentation presentation;

    public GuestRequest() 
    {
    }
    
    public boolean isApproved() {
        return this.approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }
}