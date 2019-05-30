package com.a2.springboot.web.Assignment2.Model.DAO;


import com.a2.springboot.web.Assignment2.Model.Data.Book;
import com.a2.springboot.web.Assignment2.Model.Data.Staff;
import com.a2.springboot.web.Assignment2.Model.Data.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionUtil {
    private static SessionFactory sessionFactory;

    private static SessionFactory buildSessionFactory() {
        return new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Book.class)
                .addAnnotatedClass(Staff.class)
                .buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) sessionFactory = buildSessionFactory();
        return sessionFactory;
    }
}
