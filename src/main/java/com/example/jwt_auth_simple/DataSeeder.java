package com.example.jwt_auth_simple;

import com.example.jwt_auth_simple.entity.Client;
import com.example.jwt_auth_simple.repo.ClientRepo;
import com.example.jwt_auth_simple.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;


@Component
public class DataSeeder implements CommandLineRunner {

    @Autowired
    private  ClientService clientService;
    @Override
    public void run(String... args) throws Exception {
        Client user1 = new Client();
        user1.setUsername("user1");
        user1.setPassword("password1");
        user1.setEmail("user1@example.com");

        Client user2 = new Client();
        user2.setUsername("user2");
        user2.setPassword("password2");
        user2.setEmail("user2@example.com");

        clientService.saveRegister((Client) Arrays.asList(user1, user2));
    }
}

