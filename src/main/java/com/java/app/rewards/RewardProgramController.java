package com.java.app.rewards;

import com.java.app.model.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class RewardProgramController {
	
	@Autowired
	private RewardProgramService rewardProgramService;

	//Calculate the reward points earned for each customer per month and total.
	@GetMapping("/calculaterewards/customers/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable Integer id) {
		Customer customer = rewardProgramService.getCustomerRewardById(id);
		return Optional.ofNullable(customer).map(cust -> {
			return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		}).orElse(new ResponseEntity<Customer>(HttpStatus.NOT_FOUND));
	}
	
	//Calculate the reward points earned for all customers per month and total.
	@GetMapping("/calculaterewards/customers")
	public List<Customer> findCustomerAll() {
		return rewardProgramService.getAllCustomerRewards();
	}

}
