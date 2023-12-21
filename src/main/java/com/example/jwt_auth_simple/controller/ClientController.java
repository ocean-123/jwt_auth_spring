package com.example.jwt_auth_simple.controller;


import com.example.jwt_auth_simple.dto.ClientDTO;
import com.example.jwt_auth_simple.entity.Client;
import com.example.jwt_auth_simple.service.ClientService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ClientController {
@Autowired
private ClientService clientService;






@PostMapping("/registerUser")
  public ResponseEntity<String> registerClient(@RequestBody ClientDTO clientDTO){

Client client= new Client();
    BeanUtils.copyProperties(clientDTO,client);

    clientService.saveRegister(client);



return ResponseEntity.ok("new client is created");
//      return new ResponseEntity<>(newCLient, HttpStatus.CREATED);
  }

  @GetMapping("/public{id}")
   public  ResponseEntity<ClientDTO> getUser(@PathVariable Long id){

    Client client = clientService.getGetClientById(id);
    ClientDTO clientDTO = new ClientDTO();

    BeanUtils.copyProperties(client,clientDTO);
    clientDTO.setPassword(null);

    return ResponseEntity.ok(clientDTO);





  }








}
