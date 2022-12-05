package com.example.selfproject.repository;

import com.example.selfproject.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

    @Modifying
    @Query("DELETE FROM Account a WHERE a.userName = ?1")
    void deleteAccountByUserName(String username);

    Account getAccountByUserName(String username);
}
