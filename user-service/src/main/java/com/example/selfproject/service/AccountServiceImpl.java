package com.example.selfproject.service;

import com.example.selfproject.entity.Account;
import com.example.selfproject.model.UserAccountDetails;
import com.example.selfproject.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// This is for working with DataBase
@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepo;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepo) {
        this.accountRepo = accountRepo;
    }

    @Override
    public UserAccountDetails getAccountByUserName(String username) {
        Account account = accountRepo.getAccountByUserName(username);
        if (account == null) {
            return null;
        }

        return new UserAccountDetails(account.getRole(), account.getUserName(), account.getPassWord()
                , true, true, true, true);
    }
}
