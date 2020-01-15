package com.example.demo.controllers;

import com.example.demo.domain.Customer;
import com.example.demo.services.CustomerService;
import org.springframework.data.history.Revisions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	private final CustomerService customerService;
	
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@GetMapping({"", "/"})
	List<Customer> findAll() {
		return customerService.findAll();
	}
	
	@GetMapping({"/{id}"})
	Customer findById(@PathVariable Long id) {
		return customerService.findById(id);
	}
	
	@GetMapping({"/{id}/audit"})
	Revisions<Integer, Customer> getRevisionsById(@PathVariable Long id) {
		return customerService.getRevisionsById(id);
	}
	
	@PostMapping({"", "/"})
	@ResponseStatus(HttpStatus.CREATED)
	Customer save(@RequestBody Customer customer) {
		return customerService.save(customer);
	}
	
}
