package com.a2.springboot.web.Assignment2.Model.DAO.impl;


import com.a2.springboot.web.Assignment2.Model.Entities.Book;
import com.a2.springboot.web.Assignment2.Model.Entities.User;
import com.a2.springboot.web.Assignment2.Model.DAO.UserDAOInterface;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.transaction.Transactional;
import java.util.List;

public class UserDAO extends AbstractDAO<User> implements UserDAOInterface {
    public UserDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
        setClazz(User.class);
    }

    @Override

    @Transactional()
    public User findByUsername(String username) {
        beginTransaction();
        User user= sessionFactory.getCurrentSession().get(User.class,username);
        //Hibernate.initialize(user.getBooksBucket());

        commitTransaction();
        return user;
    }

    @SuppressWarnings("unchecked")
    public List<Book> getUserBooks(User user){
        beginTransaction();

        Session session=sessionFactory.getCurrentSession();
        List<Book> userBooks= session.createQuery("from Book b where b.user=" + "\'" +user.getUsername() + "\'").list();
        commitTransaction();

        return userBooks;
    }

    public List<Book> getUsernameBooks(String username){
        User user=findByUsername(username);
        return getUserBooks(user);
    }
}
