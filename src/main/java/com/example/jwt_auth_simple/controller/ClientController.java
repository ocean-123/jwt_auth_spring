package com.example.jwt_auth_simple.controller;


import com.example.jwt_auth_simple.entity.Client;
import com.example.jwt_auth_simple.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ClientController {
@Autowired
private ClientService clientService;




@PostMapping("/")
  public ResponseEntity<Client> registerClient(@RequestBody Client client){

      Client newCLient = clientService.saveRegister(client);

      return new ResponseEntity<>(newCLient, HttpStatus.CREATED);
  }




}
