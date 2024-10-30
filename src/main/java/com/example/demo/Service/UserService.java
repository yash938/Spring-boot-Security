package com.example.demo.Service;

import com.example.demo.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
public class UserService {

   public List<User> store = new ArrayList<>();

    public UserService() {
        store.add(new User(UUID.randomUUID().toString(),"yash sharma","yash@gmail.com"));
        store.add(new User(UUID.randomUUID().toString(),"vaibhav sharma","vaibhav@gmail.com"));
        store.add(new User(UUID.randomUUID().toString(),"sarthak sharma","sarthak@gmail.com"));
        store.add(new User(UUID.randomUUID().toString(),"nikhil sharma","nikhil@gmail.com"));
    }

    public List<User> getUser(){
       return this.store;
    }

}
