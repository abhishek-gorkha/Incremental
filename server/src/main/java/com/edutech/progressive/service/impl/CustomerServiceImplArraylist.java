package com.edutech.progressive.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.edutech.progressive.entity.Customers;
import com.edutech.progressive.service.CustomerService;

@Service
public class CustomerServiceImplArraylist implements CustomerService {

    private List<Customers> customerList = new ArrayList<>();

    @Override
    public List<Customers> getAllCustomers() throws SQLException {
        return customerList;
    }

    @Override
    public int addCustomer(Customers customers) throws SQLException {
        customerList.add(customers);
        return customerList.size();
    }

    @Override
    public List<Customers> getAllCustomersSortedByName() throws SQLException {
        List<Customers> sortedList = new ArrayList<>(customerList);
        Collections.sort(sortedList); // Uses Comparable<Customers>
        return sortedList;
    }

    public void emptyArrayList() {
        customerList.clear();
    }

    // ✅ FIXED: REQUIRED FOR DAY‑2
    @Override
    public Customers getCustomerById(int customerId) throws SQLException {
        for (Customers customer : customerList) {
            if (customer.getCustomerId() == customerId) {
                return customer;
            }
        }
        return null; // ✅ IMPORTANT for non‑existent customer
    }

    // ✅ Safe update (no exception)
    @Override
    public void updateCustomer(Customers customers) throws SQLException {
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getCustomerId() == customers.getCustomerId()) {
                customerList.set(i, customers);
                return;
            }
        }
    }

    // ✅ Safe delete
    @Override
    public void deleteCustomer(int customerId) throws SQLException {
        customerList.removeIf(c -> c.getCustomerId() == customerId);
    }
}