package com.thinkpro.customer.service;

import com.thinkpro.customer.domain.Customer;

public interface CustomerService {
	public Customer create(Customer customer);
	public String update(Customer customer);
	public Customer getById(int bankId);
	public void deleteById(int bankId);
}
