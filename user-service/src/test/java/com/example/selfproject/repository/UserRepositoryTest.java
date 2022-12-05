package com.example.selfproject.repository;

import com.example.selfproject.entity.Account;
import com.example.selfproject.entity.User;
import com.example.selfproject.model.UserPermission;
import com.example.selfproject.model.UserRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@SpringBootTest
class UserRepositoryTest {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserRepositoryTest(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Test
    public void saveNewUser() {
        UserRole role = UserRole.CLIENT;
        role.setPermissions(Set.of(UserPermission.READ));

        Account account = Account.builder()
                .role(role)
                .userName("superclient")
                .passWord(passwordEncoder.encode("123456"))
                .build();

        User user = User.builder()
                .firstName("duy")
                .lastName("ngu")
                .age(17)
                .ticketNumber(1)
                .build();

        String key = passwordEncoder.encode(user.getFirstName() + account.getUserName());
        account.setUserKey(key);
        user.setAccountKey(account);
        userRepository.save(user);
    }

    @Test
    @Transactional
    public void deleteByKeyAccount() {
        String key = "$2a$10$Qi7QCrugvzEHmKEL3F6ZEeiKrPf2ERAhVDXasfVKw4qI1FHr3oS7e";
        userRepository.deleteUserByAccountKey(key);
    }

    @Test
    @Transactional
    public void deleteByFirstName() {
        String name = "Tran";
        userRepository.deleteUserByFirstName(name);
    }
}