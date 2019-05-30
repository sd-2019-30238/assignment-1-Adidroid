package com.a2.springboot.web.Assignment2.Services.Command;

import com.a2.springboot.web.Assignment2.Model.Entities.Book;
import com.a2.springboot.web.Assignment2.Model.Entities.User;

import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class RegisterCommandService {

    public void register(String username,String password){
       User user=new User(username,password,new HashSet<Book>());
        UserCommandService.addUser(user);

    }
}
