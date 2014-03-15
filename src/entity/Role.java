package entity;

import java.io.*;
import java.util.*;

/**
 * @author Maxim
 */
@Table(name="role")
@javax.persistence.Entity
public class Role implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	@Column(name="role_name")
	private String roleName;
	@ManyToMany(mappedBy="roles", cascade=CascadeType.PERSIST)
	private Collection<User> users;
	@ManyToMany(mappedBy="roles", cascade=CascadeType.PERSIST)
	private Collection<User> attribute;

	@javax.persistence.Id
	@javax.persistence.GeneratedValue
	@javax.persistence.Column(name="id")
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@javax.persistence.Column(name="role_name")
	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@javax.persistence.Transient
	public Collection<User> getUsers() {
		return this.users;
	}

	public void setUsers(Collection<User> users) {
		this.users = users;
	}

	@javax.persistence.Transient
	public Collection<User> getAttribute() {
		return this.attribute;
	}

	public void setAttribute(Collection<User> attribute) {
		this.attribute = attribute;
	}

	public Role() {
		// TODO - implement Role.Role
		throw new UnsupportedOperationException();
	}

}