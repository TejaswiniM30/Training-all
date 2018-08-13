package com.ticketbooking.airticket.AirTicketBooking.dal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.ticketbooking.airticket.AirTicketBooking.model.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAL{

	@Autowired
	private MongoTemplate MongoTemplate;
	
	@Override
	public Customer updateCustomer(String userID) {
		Customer c =MongoTemplate.findById(userID, Customer.class);
		c.setStatus(false);
		MongoTemplate.save(c);
		return c;
	}
	@Override
	public Customer getCustomer(String userID) {
		
		return MongoTemplate.findById(userID, Customer.class);
	}
	@Override
	public List<Customer> getAllCustomers() {
		
		return MongoTemplate.findAll(Customer.class);
	}
	@Override
	public Customer createCustomer(Customer customer) {
		MongoTemplate.save(customer);
		return customer;
	}

}
