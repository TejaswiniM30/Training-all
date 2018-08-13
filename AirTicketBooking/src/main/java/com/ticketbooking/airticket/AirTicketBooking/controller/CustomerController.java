package com.ticketbooking.airticket.AirTicketBooking.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.mvc.ControllerLinkBuilderFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ticketbooking.airticket.AirTicketBooking.dal.CustomerDAL;

import com.ticketbooking.airticket.AirTicketBooking.model.Customer;

@RestController
public class CustomerController {
	private final Logger LOG = LoggerFactory.getLogger(getClass());

	@Autowired
	private CustomerDAL customerdao;

	@GetMapping("/customer")
	public List<Customer> getAllTicket() {
		return customerdao.getAllCustomers();

	}
	
	@PostMapping("/customer/book")
	public Resource<Customer> bookTicket(@RequestBody Customer customer) {
		customer.setPrice(600);
		if (customer.getNoOfPassengers() > 6) {
			System.out.println("Customer getting 6% Discount");
			customer.getPrice();
			customer.setPrice(customer.getPrice() - customer.getPrice() * 6 / 100);
		}
		Customer c = customerdao.createCustomer(customer);

		Resource<Customer> resource = new Resource<Customer>(c);
		ControllerLinkBuilder linkto = new ControllerLinkBuilderFactory()
				.linkTo(methodOn(this.getClass()).getTicket(c.getCustomerId()));
		resource.add(linkto.withRel("select-user"));

		return resource;
	}

	@GetMapping("/customer/cancel/{userId}")
	public Resource<Customer> cancelTicket(@PathVariable String userId) {

		Customer c = customerdao.updateCustomer(userId);
		Resource<Customer> resource = new Resource<Customer>(c);
		ControllerLinkBuilder linkto = new ControllerLinkBuilderFactory()
				.linkTo(methodOn(this.getClass()).getTicket(c.getCustomerId()));
		resource.add(linkto.withRel("select-user"));
		return resource;

	}

	@GetMapping("/customer/{userId}")
	public Resource<Customer> getTicket(@PathVariable String userId) {
		Resource<Customer> resource = new Resource<Customer>(customerdao.getCustomer(userId));
		ControllerLinkBuilder linkto = new ControllerLinkBuilderFactory()
				.linkTo(methodOn(this.getClass()).getAllTicket());
		resource.add(linkto.withRel("select-users"));
		return resource;

	}

	
}
