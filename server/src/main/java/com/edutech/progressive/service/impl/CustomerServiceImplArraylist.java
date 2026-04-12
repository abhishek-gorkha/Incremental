package com.edutech.progressive.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.edutech.progressive.entity.Customers;

public class CustomerServiceImplArraylist {
private static List<Customers> customersList = new ArrayList<>();
public List<Customers> getAllCustomers() throws SQLException{
    return customersList;
} 
public int addCustomer(Customers customers) throws SQLException {
    customersList.add(customers);
    return customersList.size();
}
public List<Customers> getAllCustomersSortedByName() throws SQLException {
      
List<Customers> list = new ArrayList<>(customersList);
    Collections.sort(list);
    return list;
}

public Customers getCustomerById(int customerId) throws SQLException {
        for (Customers cust : customersList) {
            if (cust.getCustomerId() == customerId) {
                return cust;
            }
        }
        return null; 
    }

public void emptyArrayList() {
     customersList.clear();
}}