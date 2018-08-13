package com.ticketbooking.airticket.AirTicketBooking.dal;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ticketbooking.airticket.AirTicketBooking.model.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

}




