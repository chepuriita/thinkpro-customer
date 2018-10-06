package com.thinkpro.customer.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thinkpro.customer.domain.Address;
import com.thinkpro.customer.domain.Customer;
import com.thinkpro.customer.service.CustomerService;

@RestController
@RequestMapping("/")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	
	Address address = new Address();
	
	@GetMapping(path = "get/{customerNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<Customer> getCustomer(@PathVariable("customerNumber") int customerNumber) {
		System.out.println("customerNumber ----->:"+customerNumber);
		System.out.println("AddressId-------->"+ address.getAddressId() +"   "+ 
				"Address1-------->" + address.getAddress1());
		Customer customer = customerService.getById(customerNumber);	
		HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "CustomerController");
        
        return ResponseEntity.accepted().headers(headers).body(customer);		
	}
	
	
	@PostMapping(value = "create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createCustomer(@RequestBody Customer customer) {
		System.out.println("customerNumber ----->:"+customer.getCustomerNumber());
		customerService.create(customer);
		return ResponseEntity.status(HttpStatus.CREATED).build();		
	}
	
	@PutMapping(value = "update", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<String> updateCustomer(@RequestBody Customer customer) {
		System.out.println("customerNumber ----->:"+customer.getCustomerNumber());
		customerService.update(customer);				
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}
	
	@DeleteMapping(value = "remove/{customerNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> removeCustomer(@PathVariable("customerNumber") int customerNumber) {
		System.out.println("customerNumber ----->:"+customerNumber);				
		customerService.deleteById(customerNumber);		
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}

	
}
