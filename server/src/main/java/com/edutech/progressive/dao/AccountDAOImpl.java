package com.edutech.progressive.dao;

import java.util.List;

import org.aspectj.apache.bcel.generic.RET;

import com.edutech.progressive.entity.Accounts;

public class AccountDAOImpl implements AccountDAO{

    @Override
    public int addAccount(Accounts accounts) {
        return -1;
    }

    @Override
    public Accounts getAccountById(int accountId) {
        return null;
    }

    @Override
    public void updateAccount(Accounts accounts) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateAccount'");
    }

    @Override
    public void deleteAccount(int accountId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAccount'");
    }

    @Override
    public List<Accounts> getAllAccounts() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllAccounts'");
    }


}
