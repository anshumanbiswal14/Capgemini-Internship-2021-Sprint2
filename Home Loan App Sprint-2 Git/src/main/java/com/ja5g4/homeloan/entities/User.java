package com.ja5g4.homeloan.entities;


import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@Table(name = "user_data")
@Entity
@ApiModel(value = "User Bean Class")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	
	@ApiModelProperty(name = "User Name", value = "It holds only alphabets and accepts minimum 3 Chars", required = true)
	@NotEmpty(message = "User Name can't be empty!")
	@Size(min = 3, max = 25, message = "Invalid Admin Name please enter a vaild Admin Name!")
	@Pattern(regexp = "^[a-zA-Z]*$", message = "Accepts only alphabets! re-enter the admin name")
	private String username;
	
	@ApiModelProperty(name = "Password", value = "It holds only alphabets and accepts maximun 6 Chars", required = true)
	@NotEmpty(message = "Password can't be empty!")
	@Size(min = 8, max = 20, message = "Password has to be of minimum 8 chars!")
	@Column(unique = true)
	private String password;
	

	public User() {
		super();
	}
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public User(int userId, String username, String password) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + userId;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userId != other.userId)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}
// By Blesy Helen