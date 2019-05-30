package com.a2.springboot.web.Assignment2.Model.Services.DBAccess;



import com.a2.springboot.web.Assignment2.Model.DAO.SessionUtil;
import com.a2.springboot.web.Assignment2.Model.DAO.impl.BookDAO;
import com.a2.springboot.web.Assignment2.Model.Data.Book;

import java.util.List;

public class BookService {


    public static void addBook(Book book){
        new BookDAO(SessionUtil.getSessionFactory()).save(book);

    }

    public static Book get(int id){
        return new BookDAO(SessionUtil.getSessionFactory()).get(id);
    }

    public static List<Book> getAll(){
        return new BookDAO(SessionUtil.getSessionFactory()).getAll();
    }

    public static void deleteById(int id){
        new BookDAO(SessionUtil.getSessionFactory()).deleteById(id);
    }

    public static void update(Book book){
        new BookDAO(SessionUtil.getSessionFactory()).update(book);
    }

    public static List<Book> getAllGenre(String genre){
        return new BookDAO(SessionUtil.getSessionFactory()).getAllGenre(genre);


    }

    public static void addQuantity(int id){
        Book book=get(id);
        book.setQuantity(1);
        update(book);

    }

    public static void decreaseQuantity(int id){
        Book book=get(id);
        book.setQuantity(0);
        update(book);

    }
}
