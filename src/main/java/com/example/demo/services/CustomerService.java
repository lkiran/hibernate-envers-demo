package com.example.demo.services;

import com.example.demo.domain.Customer;
import org.springframework.data.history.Revisions;

import java.util.List;

public interface CustomerService {
	Customer findById(Long id);
	
	List<Customer> findAll();
	
	Customer save(Customer customer);
	
	Revisions<Integer, Customer> getRevisionsById(Long id);
}