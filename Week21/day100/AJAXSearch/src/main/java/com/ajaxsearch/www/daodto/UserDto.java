package com.ajaxsearch.www.daodto;

import java.io.Serializable;

public class UserDto implements Serializable{
	private static final long serialVersionUID = 238821521672429462L;
	private String userName;
	private int userAge;
	private String userGender;
	private String userEmail;
	public UserDto() {
		super();
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
