package com.edutech.progressive.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.edutech.progressive.entity.Accounts;
import com.edutech.progressive.service.AccountService;

@Service
public class AccountServiceImplArraylist implements AccountService {

    private List<Accounts> accountsList = new ArrayList<>();

    @Override
    public List<Accounts> getAllAccounts() throws SQLException {
        return accountsList;
    }

    @Override
    public int addAccount(Accounts accounts) throws SQLException {
        accountsList.add(accounts);
        return accountsList.size();
    }

    @Override
    public List<Accounts> getAllAccountsSortedByBalance() throws SQLException {
        List<Accounts> sortedList = new ArrayList<>(accountsList);
        Collections.sort(sortedList); // Uses Comparable<Accounts>
        return sortedList;
    }

    public void emptyArrayList() {
        accountsList.clear();
    }

    @Override
    public Accounts getAccountById(int accountId) throws SQLException {
        for (Accounts account : accountsList) {
            if (account.getAccountId() == accountId) {
                return account;
            }
        }
        return null; 
    }

    @Override
    public void updateAccount(Accounts accounts) throws SQLException {
        for (int i = 0; i < accountsList.size(); i++) {
            if (accountsList.get(i).getAccountId() == accounts.getAccountId()) {
                accountsList.set(i, accounts);
                return;
            }
        }
    }

    @Override
    public void deleteAccount(int accountId) throws SQLException {
        accountsList.removeIf(acc -> acc.getAccountId() == accountId);
    }

    @Override
    public List<Accounts> getAccountsByUser(int userId) throws SQLException {
        List<Accounts> result = new ArrayList<>();
        for (Accounts account : accountsList) {
            if (account.getAccountId() == userId) {
                result.add(account);
            }
        }
        return result;
    }
}