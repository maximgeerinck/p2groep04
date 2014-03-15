package entity;

import javax.persistence.*;

/**
 * @author Maxim
 */
@Entity
public class GuestRequest {

	private Presentation presentation;
	private User user;
	@Column(name="approved")
	private boolean approved;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ïd")
	private int id;

	@javax.persistence.ManyToOne(optional=false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@javax.persistence.Column(name="approved")
	public boolean isApproved() {
		return this.approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	@javax.persistence.Id
	@javax.persistence.GeneratedValue(strategy=GenerationType.IDENTITY)
	@javax.persistence.Column(name="ïd")
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public GuestRequest() {
		// TODO - implement GuestRequest.GuestRequest
		throw new UnsupportedOperationException();
	}

}