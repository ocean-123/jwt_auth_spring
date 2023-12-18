package com.example.jwt_auth_simple.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Client {


    @Id
    private Long id;

    private  String username;
    private  String  email;
     private String password;



}
