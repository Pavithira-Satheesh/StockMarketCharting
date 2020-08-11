package com.example.stock.examplestock;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserSample {
	@Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  public Integer id;
	public String name;
	public String password;
	public String type;
	public String email;
	public Integer mnumber;
	public Integer confirmation;
	  
	  public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getMnumber() {
		return mnumber;
	}
	public void setMnumber(Integer mnumber) {
		this.mnumber = mnumber;
	}
	
	public Integer getConfirmation() {
		return confirmation;
	}
	public void setConfirmation(Integer confirmation) {
		this.confirmation = confirmation;
	}
}
