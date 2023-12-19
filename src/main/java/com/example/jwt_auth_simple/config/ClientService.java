package com.example.jwt_auth_simple.config;

import com.example.jwt_auth_simple.entity.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@Component
public class ClientService implements UserDetailsService {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Session session = sessionFactory.getCurrentSession();

        Client client = session
                .createQuery("from Client c where c.username=:username",Client.class)
                .setParameter("username",username)
                .uniqueResult();
        System.out.println(client);

        if (client==null){

            throw new UsernameNotFoundException("user name not found");

        }
        else {
            return  new ClientDetails(client);
        }




    }
}
