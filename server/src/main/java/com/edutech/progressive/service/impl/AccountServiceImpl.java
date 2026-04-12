package com.edutech.progressive.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.edutech.progressive.dao.AccountDAO;
import com.edutech.progressive.dao.AccountDAOImpl;
import com.edutech.progressive.entity.Accounts;

public class AccountServiceImpl  {


    private AccountDAO accountDAO;
public AccountServiceImpl(AccountDAOImpl accountDAO) {
this.accountDAO = accountDAO;
}
public List<Accounts> getAllAccounts() throws SQLException{
   return accountDAO.getAllAccounts();
}
public int addAccount(Accounts accounts) throws SQLException {

    return accountDAO.addAccount(accounts);
}
public List<Accounts> getAllAccountsSortedByBalance() throws SQLException {
     List<Accounts> list = new ArrayList<>(accountDAO.getAllAccounts());
    Collections.sort(list);
    return list;
    //test
}
public List<Accounts> getAccountsByUser(int userld) throws SQLException {

return accountDAO.getAllAccounts();
    
}
public Accounts getAccountById(int accountld) throws SQLException {
return accountDAO.getAccountById(accountld);
    
}
public void updateAccount(Accounts accounts) throws SQLException {
     accountDAO.updateAccount(accounts);
}
public void deleteAccount(int accountld) throws SQLException {
    accountDAO.deleteAccount(accountld);
}
}