package com.a2.springboot.web.Assignment2.Services.Query;

import com.a2.springboot.web.Assignment2.Model.DAO.SessionUtil;
import com.a2.springboot.web.Assignment2.Model.DAO.impl.BookDAO;
import com.a2.springboot.web.Assignment2.Model.Entities.Book;

import java.util.List;

public class BookQueryService {



    public static Book get(int id){
        return new BookDAO(SessionUtil.getSessionFactory()).get(id);
    }

    public static List<Book> getAll(){
        return new BookDAO(SessionUtil.getSessionFactory()).getAll();
    }


    public static List<Book> getAllGenre(String genre){
        return new BookDAO(SessionUtil.getSessionFactory()).getAllGenre(genre);


    }


}
