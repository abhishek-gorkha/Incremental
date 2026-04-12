package com.edutech.progressive.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.edutech.progressive.entity.Accounts;

public class AccountServiceImplArraylist {

private static List<Accounts> accountList = new ArrayList<>();
    public List<Accounts> getAllAccounts() throws SQLException {
        
    return accountList;
    }

    public int addAccount(Accounts accounts) throws SQLException {
        accountList.add(accounts);
    return accountList.size();
    }

    public List<Accounts> getAllAccountsSortedByBalance() throws SQLException {

        List<Accounts> list = new ArrayList<>(accountList);
    Collections.sort(list);
    return list;
    }

public Accounts getAccountById(int accountId) throws SQLException {
        for (Accounts acc : accountList) {
            if (acc.getAccountId() == accountId) {
                return acc;
            }
        }
        return null;
    }

    public void emptyArrayList() {
        accountList.clear();
    }
}