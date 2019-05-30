package com.a2.springboot.web.Assignment2.Services.Command;

import com.a2.springboot.web.Assignment2.Model.DAO.SessionUtil;
import com.a2.springboot.web.Assignment2.Model.DAO.impl.UserDAO;
import com.a2.springboot.web.Assignment2.Model.Entities.User;

public class UserCommandService {


    public static void addUser(User user){
        new UserDAO(SessionUtil.getSessionFactory()).save(user);
    }

    public static void update(User user){
        new UserDAO(SessionUtil.getSessionFactory()).update(user);
    }


}
