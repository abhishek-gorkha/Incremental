package com.edutech.progressive.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.edutech.progressive.dao.CustomerDAO;
import com.edutech.progressive.dao.CustomerDAOImpl;
import com.edutech.progressive.entity.Customers;

public class CustomerServiceImpl {


private CustomerDAO customerDAO;
public CustomerServiceImpl(CustomerDAOImpl customerDAO) {
    this.customerDAO = customerDAO;
}
public List<Customers> getAllCustomers() throws SQLException {

    return customerDAO.getAllCustomers();
}
public int addCustomer(Customers customers) throws SQLException{
    return  customerDAO.addCustomer(customers);
} 
public List<Customers> getAllCustomersSortedByName() throws SQLException{
     List<Customers> list = new ArrayList<>(customerDAO.getAllCustomers());
    Collections.sort(list);
    return list;
} 
public void updateCustomer(Customers customers) throws SQLException {
   customerDAO.updateCustomer(customers);   
}
public void deleteCustomer(int customerld) throws SQLException {
    customerDAO.deleteCustomer(customerld);
}
public Customers getCustomerById(int customerld) throws SQLException {
    return customerDAO.getCustomerById(customerld);
}

}