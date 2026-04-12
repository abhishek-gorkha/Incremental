package com.edutech.progressive.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.edutech.progressive.dao.TransactionDAO;
import com.edutech.progressive.entity.Transactions;

public class TransactionServiceImpl {
    private TransactionDAO transactionDAO;
    
    public TransactionServiceImpl() {
    }
    public TransactionServiceImpl(TransactionDAO transactionDAO) {
        this.transactionDAO = transactionDAO;
    }
    public List<Transactions> getAllTransactions() throws SQLException{
        return transactionDAO.getAllTransactions();
    }
public Transactions getTransactionByld(int transactionld) throws SQLException{
    return transactionDAO.getTransactionById(transactionld);
}
public int addTransaction(Transactions transaction) throws SQLException {
    return transactionDAO.addTransaction(transaction);
}
public void updateTransaction(Transactions transaction) throws SQLException {
    transactionDAO.updateTransaction(transaction);
}
public void deleteTransaction(int transactionld) throws SQLException {
    transactionDAO.deleteTransaction(transactionld);
}
public List<Transactions> getTransactionsByCustomerld(int customerld) throws SQLException {
List<Transactions> list = new ArrayList<>(transactionDAO.getAllTransactions());
    Collections.sort(list);
    return list;
}}