package com.infy.service;

import com.infy.dto.CustomerDTO;
import com.infy.entity.Customer;
import com.infy.exception.InfyBankException;
import com.infy.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Create Operation
@Service(value = "customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void addCustomer(CustomerDTO customerDTO) throws InfyBankException{
        Optional<Customer> optional = customerRepository.findById(customerDTO.getCustomerId());
        if(optional.isPresent())
            throw new InfyBankException("Service.CUSTOMER_FOUND");

        Customer customer = new Customer();
        customer.setCustomerId(customerDTO.getCustomerId());
        customer.setName(customerDTO.getName());
        customer.setEmailId(customerDTO.getEmailId());
        customer.setDateOfBirth(customerDTO.getDateOfBirth());

        customerRepository.save(customer);
    }

    // READ Operation
    @Override
    public CustomerDTO getCustomer(Integer customerId) throws  InfyBankException{
        Optional<Customer> optional = customerRepository.findById(customerId);
        Customer customer = optional.orElseThrow(() -> new InfyBankException("Service.CUSTOMER_NOT_FOUND"));
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustomerId(customer.getCustomerId());
        customerDTO.setName(customer.getName());
        customerDTO.setEmailId(customer.getEmailId());
        customerDTO.setDateOfBirth(customer.getDateOfBirth());
        return customerDTO;
    }

    @Override
    public List<CustomerDTO> findAll() throws InfyBankException{
        Iterable<Customer> customers = customerRepository.findAll();
        List<CustomerDTO> customerDTOS = new ArrayList<>();
        customers.forEach(customer -> {
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setCustomerId(customer.getCustomerId());
            customerDTO.setName(customer.getName());
            customerDTO.setEmailId(customer.getEmailId());
            customerDTO.setDateOfBirth(customer.getDateOfBirth());
        });

        if (customerDTOS.isEmpty())
            throw new InfyBankException("Service.CUSTOMERS_NOT_FOUND");
        return customerDTOS;
    }

    // UPDATE Operation
    @Override
    public void updateCustomer(Integer customerId, String emailId) throws InfyBankException{
        Optional<Customer> optional = customerRepository.findById(customerId);
        Customer customer = optional.orElseThrow(() -> new InfyBankException("Service.CUSTOMER_NOT_FOUND"));
        customer.setEmailId(emailId);
    }

    //DELETE Operation
    @Override
    public void deleteCustomer(Integer customerId) throws InfyBankException {
        Optional<Customer> optional = customerRepository.findById(customerId);
        optional.orElseThrow(() -> new InfyBankException("Service.CUSTOMER_NOT_FOUND"));
        customerRepository.deleteById(customerId);
    }

}
