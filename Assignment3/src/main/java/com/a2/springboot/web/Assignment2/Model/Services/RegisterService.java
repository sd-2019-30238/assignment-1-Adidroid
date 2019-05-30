package com.a2.springboot.web.Assignment2.Model.Services;

import com.a2.springboot.web.Assignment2.Model.Data.Book;
import com.a2.springboot.web.Assignment2.Model.Data.User;
import com.a2.springboot.web.Assignment2.Model.Services.DBAccess.UserService;

import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class RegisterService {

    public void register(String username,String password){
       User user=new User(username,password,new HashSet<Book>());
        UserService.addUser(user);

    }
}
