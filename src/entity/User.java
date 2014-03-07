/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.sql.Timestamp;
import model.AbstractUser;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import java.util.*;

/**
 *
 * @author Bram
 */
@Entity
public class User extends AbstractUser
{
    
    @PrePersist
    public void onCreate() 
    {
        java.util.Date date= new java.util.Date();
        this.createdOn = new Timestamp(date.getTime());
    }

	public boolean isPromotor() {
		// TODO - implement User.isPromotor
		throw new UnsupportedOperationException();
	}

	public boolean isBPC() {
		// TODO - implement User.isBPC
		throw new UnsupportedOperationException();
	}

	public boolean hasPromotor() {
		// TODO - implement User.hasPromotor
		throw new UnsupportedOperationException();
	}

	@javax.persistence.Transient
	private Collection<User> students;
	@javax.persistence.Transient
	private Collection<Presentation> presentationsAttending;
	@javax.persistence.Transient
	private Collection<GuestRequest> guestRequests;
	@javax.persistence.Transient
	private Presentation presentation;
	@javax.persistence.Transient
	private Suggestion suggestedBy;
	@javax.persistence.Transient
	private int amountOfStudents = 0;
}
