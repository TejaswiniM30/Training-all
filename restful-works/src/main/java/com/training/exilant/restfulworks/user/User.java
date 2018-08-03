package com.training.exilant.restfulworks.user;

import java.util.Date;

public class User {
 private Integer userId;
 private String userName;
 private Date birthDate;
public Integer getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getUserName() {
	return userName;
}
public Date getBirthDate() {
	return birthDate;
}
public void setBirthDate(Date birthDate) {
	this.birthDate = birthDate;
}
public void setUserId(Integer userId) {
	this.userId = userId;
}
public void setUserName(String userName) {
	this.userName = userName;
}

@Override
public String toString() {
	return "User [userId=" + userId + ", userName=" + userName + ", userDate=" + birthDate + "]";
}
public User(int userId, String userName, Date userDate) {
	super();
	this.userId = userId;
	this.userName = userName;
	this.birthDate = userDate;
}
public User() {
	super();
}

 
}
