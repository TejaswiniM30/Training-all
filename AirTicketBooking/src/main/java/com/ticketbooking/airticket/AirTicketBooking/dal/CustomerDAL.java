package com.ticketbooking.airticket.AirTicketBooking.dal;

import java.util.List;

import com.ticketbooking.airticket.AirTicketBooking.model.Customer;

public interface CustomerDAL 
{
public Customer updateCustomer(String userID);
public Customer getCustomer(String userID);
public List<Customer> getAllCustomers();
public Customer createCustomer(Customer customer);
}
