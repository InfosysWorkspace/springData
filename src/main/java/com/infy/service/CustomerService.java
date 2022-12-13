package com.infy.service;

import com.infy.dto.CustomerDTO;
import com.infy.exception.InfyBankException;

import java.util.List;

// Create Operation
public interface CustomerService {
    public void addCustomer(CustomerDTO customer) throws InfyBankException;

    // Read Operation
    public CustomerDTO getCustomer(Integer customerId) throws InfyBankException;
    public List<CustomerDTO> findAll() throws InfyBankException;

    // UPDATE Operation
    public void updateCustomer(Integer customerId, String email) throws InfyBankException;

    //DELETE Operation
    public void deleteCustomer(Integer customerId) throws InfyBankException;

}
