package com.infy;

import com.infy.dto.CustomerDTO;
import com.infy.entity.Customer;
import com.infy.repository.CustomerRepository;
import com.infy.service.CustomerServiceImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.time.LocalDate;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private static final Log LOGGER = LogFactory.getLog(SpringDataApplication.class);

	@Autowired
	CustomerRepository customerRepository;

	// Create Operation
	@Autowired
	CustomerServiceImpl customerService;

	@Autowired
	Environment environment;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

//	public void run(String... args) {
//
//
//
//		Customer customer1 = new Customer(2, "nasir@infosys.com", "Nasir", LocalDate.of(1987, 4, 2));
//		Customer customer2 = new Customer(2, "aisha@infosys.com", "Aisha", LocalDate.of(1980, 11, 1));
//
//		//save customers
//		customerRepository.save(customer1);
//		customerRepository.save(customer2);
//
//		//fetch customer by id
//		LOGGER.info("Customer Ferched by findById(1)");
//		LOGGER.info("--------------------------------");
//		Customer customer3 = customerRepository.findById(1).get();
//		LOGGER.info(customer3);
//
//		//fetching all customers
//		LOGGER.info("Customers fetched by findAll()");
//		LOGGER.info("--------------------------------");
//		Iterable<Customer> customers = customerRepository.findAll();
//		customers.forEach(LOGGER::info);
//	}

	public void run(String... args) throws Exception{
//		addCustomer();
//		getCustomer();
//		findAllCustomers();
//		updateCustomer();
		deleteCustomer();
	}

	public void addCustomer(){
		CustomerDTO customer = new CustomerDTO();
		customer.setCustomerId(4);
		customer.setName("Fatima");
		customer.setEmailId("fatima@infy.com");
		customer.setDateOfBirth(LocalDate.now());

		try{
			customerService.addCustomer(customer);
			LOGGER.info(environment.getProperty("UserInterface.INSERT_SUCCESS"));
		}catch (Exception e){
			if(e.getMessage() != null)
				LOGGER.info(environment.getProperty(e.getMessage(),
						"Something went wrong. Please check log file for more details."));
		}
	}

	// READ Operation
	public void getCustomer(){
		try {
			CustomerDTO customer = customerService.getCustomer(1);
			LOGGER.info(customer);
		} catch (Exception e){
			if(e.getMessage() != null )
			LOGGER.info(environment.getProperty(e.getMessage(),
					"Something went wrong. Please check log file for more details."));
		}
	}

	public void findAllCustomers(){
		try{
			customerService.findAll().forEach(LOGGER::info);
		} catch (Exception e){
			if (e.getMessage() != null)
				LOGGER.info(environment.getProperty(e.getMessage(),
					"Something went wrong. Please check log file for more details."));
		}
	}

	// UPDATE Operation
	public void updateCustomer(){
		try{
			customerService.updateCustomer(2, "nasir02@infy.com");
			LOGGER.info(environment.getProperty("UserInterface.UPDATE_SUCCESS"));
		} catch (Exception e){
			if(e.getMessage() != null)
				LOGGER.info(environment.getProperty(e.getMessage(), "Something went wrong. Please check log file for more details."));
		}
	}

	// DELETE Operation
	public void deleteCustomer(){
		try{
			customerService.deleteCustomer(3);
			LOGGER.info(environment.getProperty("UserInterface.DELETE_SUCCESS"));
		} catch (Exception e){
			if(e.getMessage() != null)
				LOGGER.info(environment.getProperty(e.getMessage(),
						"Something went wrong. Please check log file for more details."));
		}
	}

}
