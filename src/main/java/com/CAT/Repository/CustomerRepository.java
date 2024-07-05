package com.CAT.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.CAT.Model.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	Optional<Customer> findByName(String string);
	
}