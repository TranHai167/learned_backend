package com.example.selfproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// This is for Spring Security
@Service
public class ApplicationUserService implements UserDetailsService {

    private final AccountServiceImpl accountService;

    @Autowired
    public ApplicationUserService(AccountServiceImpl accountService) {
        this.accountService = accountService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = accountService.getAccountByUserName(username);
        if (userDetails == null) {
            System.out.println("Password is incorrect!");
            throw new UsernameNotFoundException("Invalid credentials");
        }

        return userDetails;
    }

    public String[] getAuthentication() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Login information: " + auth.getName() + ", " + auth.getAuthorities());
        String roll = auth.getAuthorities().toString();
        String link = "";
        if (roll.contains("ADMIN")) {
            link = "library_management";
        } else if (roll.contains("CLIENT")) {
            link = "library";
        }

        return new String[]{link, auth.getName()};
    }
}
