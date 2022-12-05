package com.example.selfproject.entity;

import com.example.selfproject.model.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {

    @Id
    private String userKey;

    @Column(unique = true)
    private String userName;

    @Column(unique = true)
    private String passWord;
    private UserRole role;
}
