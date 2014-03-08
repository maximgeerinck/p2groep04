/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Maxim
 */
@Entity
public class GuestRequest 
{
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private boolean approved;
        
    private User guest;
        
    private Presentation presentation;

	@javax.persistence.Column(name="approved")
	public boolean isApproved() {
		return this.approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public GuestRequest() {
		// TODO - implement GuestRequest.GuestRequest
		throw new UnsupportedOperationException();
	}
    
}
