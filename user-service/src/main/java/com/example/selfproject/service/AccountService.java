package com.example.selfproject.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface AccountService {

    UserDetails getAccountByUserName(String username);
}
