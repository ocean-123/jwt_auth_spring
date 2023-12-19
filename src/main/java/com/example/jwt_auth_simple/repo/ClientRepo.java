package com.example.jwt_auth_simple.repo;

import com.example.jwt_auth_simple.entity.Client;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<Client,Long> {

}
