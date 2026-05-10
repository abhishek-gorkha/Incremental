package com.edutech.progressive.service.impl;


import com.edutech.progressive.entity.Customers;
import com.edutech.progressive.exception.CustomerAlreadyExistsException;
import com.edutech.progressive.repository.AccountRepository;
import com.edutech.progressive.repository.CustomerRepository;
import com.edutech.progressive.repository.TransactionRepository;
import com.edutech.progressive.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Service
public class CustomerServiceImplJpa implements CustomerService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired(required = false)
    PasswordEncoder passwordEncoder;

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImplJpa(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customers> getAllCustomers() throws SQLException {
        return customerRepository.findAll();
    }

    @Override
    public Customers getCustomerById(int customerId) throws SQLException {
        return customerRepository.findByCustomerId(customerId);
    }

    @Override
    public int addCustomer(Customers customers) throws SQLException {
        if (customerRepository.existsByEmail(customers.getEmail())) {
            throw new CustomerAlreadyExistsException("Customer with give email already exists : " + customers.getEmail());
        }
        if (customerRepository.existsByUsername(customers.getUsername())) {
            throw new CustomerAlreadyExistsException("Customer with given username already exists : " + customers.getUsername());
        }
        if (passwordEncoder != null && customers.getPassword() != null && !customers.getPassword().isBlank()) {
            customers.setPassword(passwordEncoder.encode(customers.getPassword()));
        }
        return customerRepository.save(customers).getCustomerId();
    }

    @Override
    public void updateCustomer(Customers customers) throws SQLException {
        Customers currentCustomer = customerRepository.findByCustomerId(customers.getCustomerId());
        Customers existingCustomer = customerRepository.findByEmail(customers.getEmail());
        if (existingCustomer != null && currentCustomer != null && customers.getCustomerId() != existingCustomer.getCustomerId()) {
            throw new CustomerAlreadyExistsException("Customer with give email already exists : " + customers.getEmail());
        }
        Customers existingUsername = customerRepository.findByUsername(customers.getUsername());
        if (existingUsername != null && currentCustomer != null && customers.getCustomerId() != existingUsername.getCustomerId()) {
            throw new CustomerAlreadyExistsException("Customer with given username already exists : " + customers.getUsername());
        }
        if (!customers.getRole().isBlank()) {
            customerRepository.save(customers);
        } else {
            throw new SQLException("Role for a customer cannot be empty");
        }
    }

    @Override
    @Transactional
    public void deleteCustomer(int customerId) throws SQLException {
        transactionRepository.deleteByCustomerId(customerId);
        accountRepository.deleteByCustomerId(customerId);
        customerRepository.deleteByCustomerId(customerId);
    }

    @Override
    public List<Customers> getAllCustomersSortedByName() throws SQLException {
        List<Customers> sortedCustomers = customerRepository.findAll();
        Collections.sort(sortedCustomers);
        return sortedCustomers;
    }
}