package com.example.selfproject.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class AccountRepositoryTest {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountRepositoryTest(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

//    @Test
//    @Transactional
//    public void deleteUserAccount() {
//        String username = "tranhaioiga";
//        accountRepository.deleteAccountByUserName(username);
//    }
}
