package com.CAT.Testcases;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.CAT.Model.Account;
import com.CAT.Model.Customer;
import com.CAT.Repository.CustomerRepository;

@DataJpaTest
public class CustomerRepositoryTests {

	@Autowired
	private CustomerRepository customerRepository;

	@BeforeEach
	public void setup() {
		customerRepository.deleteAll(); // Clear any existing data
	}

	@Test
	public void testFindAllCustomersEmpty() {
		List<Customer> customers = customerRepository.findAll();

		assertThat(customers).isEmpty();
	}

	@Test
	public void testCreateCustomer() {
		Customer customer = new Customer();
		customer.setName("John Doe");
		customer.setAddress("TPT");

		Customer savedCustomer = customerRepository.save(customer);

		System.out.println("Customer saved with ID: " + savedCustomer.getCustId());
		assertThat(savedCustomer).isNotNull();
		assertThat(savedCustomer.getCustId()).isGreaterThan(0);
	}

	@Test
	public void testFindCustomerById() {
		Customer customer = new Customer();
		customer.setName("Jane Doe");
		customerRepository.save(customer);

		Optional<Customer> retrievedCustomer = customerRepository.findById(customer.getCustId());
		assertThat(retrievedCustomer).isPresent();
		assertThat(retrievedCustomer.get().getName()).isEqualTo("Jane Doe");
	}

	@Test
	public void testFindByName() {
		Customer customer = new Customer();
		customer.setName("John Doe");
		customer.setAddress("123 Main St");
		customerRepository.save(customer);

		Optional<Customer> retrievedCustomer = customerRepository.findByName("John Doe");
		assertThat(retrievedCustomer).isPresent();
		assertThat(retrievedCustomer.get().getName()).isEqualTo("John Doe");
	}

	
	@Test
	public void testUpdateCustomer() {
		Customer customer = new Customer();
		// Set initial properties of customer
		customer.setName("Initial Name");
		customerRepository.save(customer);

		// Change properties of customer and save again
		customer.setName("Updated Name");
		customerRepository.save(customer);

		Customer updatedCustomer = customerRepository.findById(customer.getCustId()).orElse(null);
		assertNotNull(updatedCustomer);
		assertEquals("Updated Name", updatedCustomer.getName());
	}

	@Test
	public void testFindAllCustomers() {
		Customer customer1 = new Customer();
		customer1.setName("John Doe");
		customer1.setAddress("123 Main St");
		customerRepository.save(customer1);

		Customer customer2 = new Customer();
		customer2.setName("Jane Doe");
		customer2.setAddress("456 Elm St");
		customerRepository.save(customer2);

		List<Customer> customers = customerRepository.findAll();

		assertThat(customers).isNotEmpty();
		assertThat(customers.size()).isEqualTo(2);
		assertThat(customers).contains(customer1, customer2);
	}

	@Test
	public void testDeleteCustomer() {
		Customer customer = new Customer();
		customer.setName("Jane Doe");
		customerRepository.save(customer);
		customerRepository.deleteById(customer.getCustId());
		Optional<Customer> deletedCustomer = customerRepository.findById(customer.getCustId());

		assertThat(deletedCustomer).isNotPresent();
	}

	@Test
	public void testDeleteAllCustomers() {
		Customer customer1 = new Customer();
		customer1.setName("John Doe");
		customer1.setAddress("123 Main St");
		customerRepository.save(customer1);

		Customer customer2 = new Customer();
		customer2.setName("Jane Doe");
		customer2.setAddress("456 Elm St");
		customerRepository.save(customer2);

		customerRepository.deleteAll();

		List<Customer> allCustomers = customerRepository.findAll();
		assertThat(allCustomers).isEmpty();
	}

}
