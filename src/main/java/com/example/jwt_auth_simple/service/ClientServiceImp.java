package com.example.jwt_auth_simple.service;


import com.example.jwt_auth_simple.entity.Client;
import com.example.jwt_auth_simple.repo.ClientRepo;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;



@Repository
@Transactional
@Service
public class ClientServiceImp implements ClientService{

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;




    @Override
    public Client saveRegister(Client client) {
         Session session = sessionFactory.getCurrentSession();

         String password = bCryptPasswordEncoder.encode(client.getUsername());
         client.setPassword(password);

         Long clientID = (Long) session.save(client);


 return session.get(Client.class,clientID);
    }


    @Override
    public Client getGetClientById(Long id) {
        
        Session session= sessionFactory.getCurrentSession();
        return session.get(Client.class,id);
    }
}
