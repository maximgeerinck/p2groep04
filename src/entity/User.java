package entity;

import model.*;
import java.util.*;
import javax.persistence.PrePersist;

/**
 * @author Bram
 */
@javax.persistence.Entity
public class User extends AbstractUser {

	private Collection<User> students;
	private Collection<Presentation> presentationsAttending;
	private Collection<GuestRequest> guestRequests;
	private Presentation presentation;
	private int amountOfStudents = 0;
	private Collection<Suggestion> suggestion;

	public User() {
		// TODO - implement User.User
		throw new UnsupportedOperationException();
	}

	@PrePersist
	public void onCreate() {
		// TODO - implement User.onCreate
		throw new UnsupportedOperationException();
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

}