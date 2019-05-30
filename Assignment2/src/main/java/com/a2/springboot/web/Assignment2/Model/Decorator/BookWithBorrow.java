package com.a2.springboot.web.Assignment2.Model.Decorator;

import com.a2.springboot.web.Assignment2.Model.Entities.Book;
import com.a2.springboot.web.Assignment2.Model.Entities.User;

public class BookWithBorrow extends BookDecorator {


    public BookWithBorrow(Book decoratedBook) {
        super(decoratedBook);
    }

    @Override
    public void setQuantity(int quantity) {
        decoratedBook.setQuantity(quantity);

        if(quantity==0)
            System.out.println("Book unavailable");
        else
            System.out.println("Book quantity: "+quantity);

    }

    @Override
    public void setUser(User user){
        decoratedBook.setUser(user);
        if(user!=null)
            System.out.println("Book borrowed");
    }


}
