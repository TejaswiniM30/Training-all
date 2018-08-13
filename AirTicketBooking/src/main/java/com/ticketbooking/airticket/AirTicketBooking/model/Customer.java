package com.ticketbooking.airticket.AirTicketBooking.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
public class Customer {
	@Id
private String customerId;
private String customerName;
private String from;
private String to;
private String flightNo;
private Date arivalTime;
private Date departureTime;
private String classLevel;
private int noOfPassengers;
private double price;
private double discount;

public String getCustomerName() {
	return customerName;
}
public void setCustomerName(String customerName) {
	this.customerName = customerName;
}
public String getFrom() {
	return from;
}
public void setFrom(String from) {
	this.from = from;
}
public String getTo() {
	return to;
}
public void setTo(String to) {
	this.to = to;
}
public String getFlightNo() {
	return flightNo;
}
public void setFlightNo(String flightNo) {
	this.flightNo = flightNo;
}
public Date getArivalTime() {
	return arivalTime;
}
public void setArivalTime(Date arivalTime) {
	this.arivalTime = arivalTime;
}
public Date getDepartureTime() {
return departureTime;
}
public void setDepartureTime(Date departureTime) {
	this.departureTime = departureTime;
}
public String getClassLevel() {
	return classLevel;
}
public void setClassLevel(String classLevel) {
	this.classLevel = classLevel;
}
public int getNoOfPassengers() {
	return noOfPassengers;
}
public void setNoOfPassengers(int noOfPassengers) {
	this.noOfPassengers = noOfPassengers;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public double getDiscount() {
	return discount;
}
public void setDiscount(double discount) {
	this.discount = discount;
}
public boolean isStatus() {
	return status;
}
public void setStatus(boolean status) {
	this.status = status;
}
public String getCustomerId() {
	return customerId;
}
public void setCustomerId(String customerId) {
	this.customerId = customerId;
}
private boolean status;

}
