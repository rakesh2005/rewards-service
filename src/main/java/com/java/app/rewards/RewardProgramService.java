package com.java.app.rewards;

import com.java.app.model.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RewardProgramService {
	
	@Autowired
	private RewardsRepository customerRepository;
	
	
	public Customer getCustomerRewardById(Integer customerId) {
		return customerRepository.findById(customerId).orElse(null);
	}

	public List<Customer> getAllCustomerRewards() {
		return customerRepository.findAll();
	}
	
}
