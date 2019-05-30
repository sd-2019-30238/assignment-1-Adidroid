package com.a2.springboot.web.Assignment2.Services.Command;

import com.a2.springboot.web.Assignment2.Model.DAO.SessionUtil;
import com.a2.springboot.web.Assignment2.Model.DAO.impl.BookDAO;
import com.a2.springboot.web.Assignment2.Model.Entities.Book;
import com.a2.springboot.web.Assignment2.Services.Query.BookQueryService;

public class BookCommandService {

    public static void addBook(Book book){
        new BookDAO(SessionUtil.getSessionFactory()).save(book);

    }



    public static void deleteById(int id){
        new BookDAO(SessionUtil.getSessionFactory()).deleteById(id);
    }

    public static void update(Book book){
        new BookDAO(SessionUtil.getSessionFactory()).update(book);
    }


    public static void addQuantity(int id){
        Book book= BookQueryService.get(id);
        book.setQuantity(1);
        update(book);

    }

    public static void decreaseQuantity(int id){
        Book book=BookQueryService.get(id);
        book.setQuantity(0);
        update(book);

    }
}

