package com.example.libraryservice.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class JunkService {

    // {"name":"The sky is blue","act":"borrow"}
    public String[] convertJsonToString(String json) {
        String [] words = json.split("[:,\",]+");
        return new String[]{words[2], words[4]};
    }
}
