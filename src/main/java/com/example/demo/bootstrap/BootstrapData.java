package com.example.demo.bootstrap;

import com.example.demo.domain.Customer;
import com.example.demo.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {
	private final CustomerRepository customerRepository;
	
	public BootstrapData(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	@Override
	public void run(String... args) throws Exception {
			System.out.println("✨ Populating Customers...");
			customerRepository.save(Customer.builder().firstName("Claudia").lastName("Newman").build());
			customerRepository.save(Customer.builder().firstName("Wilbur").lastName("Patrick").build());
			customerRepository.save(Customer.builder().firstName("Tanya").lastName("Ward").build());
			System.out.println("✔ Populating Customers is done.");
	}
}
