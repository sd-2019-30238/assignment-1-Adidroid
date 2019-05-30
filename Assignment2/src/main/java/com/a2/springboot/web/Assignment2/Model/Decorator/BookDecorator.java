package com.a2.springboot.web.Assignment2.Model.Decorator;

import com.a2.springboot.web.Assignment2.Model.Entities.Book;
import com.a2.springboot.web.Assignment2.Model.Entities.User;

public abstract class BookDecorator implements BookInterface {

    protected Book decoratedBook;

    public BookDecorator(Book decoratedBook){
        this.decoratedBook=decoratedBook;
    }

    @Override
    public void setQuantity(int quantity){
        decoratedBook.setQuantity(quantity);
    }


    @Override
    public  void setUser(User user){
        decoratedBook.setUser(user);
    }



}
