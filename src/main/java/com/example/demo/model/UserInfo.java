package com.example.demo.model;

import org.hibernate.id.factory.spi.GenerationTypeStrategy;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class UserInfo {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String first_name;
    private String last_name;
    private String email;
    private AuthSocial type;
}
