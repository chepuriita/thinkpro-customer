package com.thinkpro.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thinkpro.customer.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{

}
