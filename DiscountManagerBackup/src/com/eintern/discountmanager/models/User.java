package com.eintern.discountmanager.models;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "role", discriminatorType = DiscriminatorType.STRING)
@GenericGenerator(strategy = "increment", name = "userInc")
public class User {

	@Id
	@GeneratedValue(generator = "userInc")
	@Column(name="user_id")
	private int id;

	@Column(length = 25)
	private String username;
	private String password;
	private String email;
	private String firstname;
	private String lastname;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getUserId() {
		return id;
	}

	public void setUserId(int userId) {
		this.id = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Transient
	public String getDecriminatorValue() {
	    return this.getClass().getSimpleName();
	}

}
