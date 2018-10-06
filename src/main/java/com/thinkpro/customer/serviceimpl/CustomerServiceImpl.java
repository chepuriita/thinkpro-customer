package com.thinkpro.customer.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.thinkpro.customer.domain.Address;
import com.thinkpro.customer.domain.Customer;
import com.thinkpro.customer.repository.AddressRepository;
import com.thinkpro.customer.repository.CustomerRepository;
import com.thinkpro.customer.service.CustomerService;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private AddressRepository addressRepository;

	@Override
	public Customer create(Customer customer) {		
		customerRepository.save(customer);		
		return customer;
	}

	@Override
	public String update(Customer customer) {
		customerRepository.save(customer);
		return customer.getName();
	}

	@Override
	public Customer getById(int customerNumber) {
		System.out.println("Id from service ----->:"+customerNumber);		
		Customer customer = customerRepository.getOne(customerNumber);
		System.out.println("Name from service ----->:"+customer.getName());
		return customer;		
	}

	@Override
	public void deleteById(int customerNumber) {
		Customer customer = customerRepository.getOne(customerNumber);
		List<Address> addressList  = customer.getAddressList();
		if(addressList!=null && addressList.isEmpty()) {
			addressList.stream().forEach(address ->{
				Long addressId = address.getAddressId();
				addressRepository.deleteById(addressId.intValue());
			});
		}
		
		customerRepository.deleteById(customerNumber);		
	}

}
