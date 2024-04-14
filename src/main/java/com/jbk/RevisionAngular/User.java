package com.jbk.RevisionAngular;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
@Id
	String username;
	String password;
	long number;
	String emailid;
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
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", number=" + number + ", emailid=" + emailid
				+ "]";
	}
	
	
}
