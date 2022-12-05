package com.example.selfproject.repository;

import com.example.selfproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Modifying
    @Query(value = "DELETE from user a where a.key_account=?1",
            nativeQuery = true)
    void deleteUserByAccountKey(String accountKey);

    @Modifying
    void deleteUserByFirstName(String name);
}
