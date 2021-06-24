package com.ja5g4.homeloan.entities;

import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "admin")
@ApiModel(value = "Admin Bean Class")
public class Admin extends User {

	
	@ApiModelProperty(name = "Admin Name", value = "It holds only alphabets and accepts minimum 3 Chars", required = true)
	@NotEmpty(message = "Admin Name can't be empty!")
	@Size(min = 3, max = 25, message = "Invalid Admin Name please enter a vaild Admin Name!")
	@Pattern(regexp = "^[a-zA-Z]*$", message = "Accepts only alphabets! re-enter the admin name")
	@Column
	private String adminName;
	
	@ApiModelProperty(name = "Phone Number", value = "It holds phone number only 10 digits allowed", required = true)
	@NotEmpty(message = "Phone Number can't be empty!")
	@Size(min = 10, max = 10, message = "Invalid Phone Number please enter a vaild phone number minimum of 10 digits")
	@Pattern(regexp = "^\\d{10}$", message = "Invalid input:Enter numbers only")
	@Column(unique = true)
	private String adminContact;

	public Admin() {
		super();
	}

	public Admin(String adminContact,String adminName,String password,int userId, String userName) {
		super(userId,userName,password);
		this.adminName = adminName;
		this.adminContact = adminContact;
	}

	
	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminContact() {
		return adminContact;
	}

	public void setAdminContact(String adminContact) {
		this.adminContact = adminContact;
	}

	@Override
	public String toString() {
		return "Admin [ adminName=" + adminName + ", adminContact=" + adminContact + "]";
	}

}
// By Anshuman Biswal