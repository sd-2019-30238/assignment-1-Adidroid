package com.a2.springboot.web.Assignment2.Model.DAO.impl;


import com.a2.springboot.web.Assignment2.Model.Data.Book;
import com.a2.springboot.web.Assignment2.Model.DAO.BookDAOInterface;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class BookDAO extends AbstractDAO<Book> implements BookDAOInterface {

    public BookDAO(SessionFactory sessionFactory){
        super(sessionFactory);
        setClazz(Book.class);

    }

    public List<Book> getAllGenre(String genre){
        beginTransaction();

        Session session=sessionFactory.getCurrentSession();
        List<Book> books= session.createQuery("from Book b where b.genre=" + "\'" +genre + "\'").list();
        commitTransaction();

        return books;
    }


}
