package com.example.billingserviceprod.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @ToString @AllArgsConstructor @NoArgsConstructor
public class Customer {
    private Long id;
    private String name;
    private String email;
}
