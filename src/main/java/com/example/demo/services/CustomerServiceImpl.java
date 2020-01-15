package com.example.demo.services;

import com.example.demo.domain.Customer;
import com.example.demo.repositories.CustomerRepository;
import org.springframework.data.history.Revisions;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
	private final CustomerRepository customerRepository;
	
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	@Override
	public Customer findById(Long id) {
		return customerRepository.findById(id).orElse(null);
	}
	
	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}
	
	@Override
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}
	
	@Override
	public Revisions<Integer, Customer> getRevisionsById(Long id) {
		return customerRepository.findRevisions(id);
	}
}
