package com.a2.springboot.web.Assignment2.Model.Services.DBAccess;



import com.a2.springboot.web.Assignment2.Model.DAO.SessionUtil;
import com.a2.springboot.web.Assignment2.Model.DAO.impl.UserDAO;
import com.a2.springboot.web.Assignment2.Model.Data.Book;
import com.a2.springboot.web.Assignment2.Model.Data.User;

import java.util.List;

public class UserService {

    public static void addUser(User user){
        new UserDAO(SessionUtil.getSessionFactory()).save(user);
    }

    public static boolean checkUser(String username,String password){

            User user=new UserDAO(SessionUtil.getSessionFactory()).findByUsername(username);
            if(user == null)
                return false;

            if(!user.getPassword().equals(password))
                return false;
            return true;

    }

    public static User get(String username){
        return new UserDAO(SessionUtil.getSessionFactory()).findByUsername(username);
    }

    public static void update(User user){
        new UserDAO(SessionUtil.getSessionFactory()).update(user);
    }

    public static List<Book> getUserBooks(User user){
        return new UserDAO(SessionUtil.getSessionFactory()).getUserBooks(user);

    }

    public static List<Book> getUserBooksByUsername(String username){
        return new UserDAO(SessionUtil.getSessionFactory()).getUsernameBooks(username);
    }
}
