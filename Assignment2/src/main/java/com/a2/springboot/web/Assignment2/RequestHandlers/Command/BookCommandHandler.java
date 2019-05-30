package com.a2.springboot.web.Assignment2.RequestHandlers.Command;

import com.a2.springboot.web.Assignment2.Model.Entities.Book;
import com.a2.springboot.web.Assignment2.Request.Request;
import com.a2.springboot.web.Assignment2.RequestHandlers.RequestHandlerInterface;
import com.a2.springboot.web.Assignment2.Services.Command.BookCommandService;

public class BookCommandHandler implements RequestHandlerInterface {



    @Override
    public void handle(Request request) {

        if(request.getRequest().equals("addBook")){
            Book book=(Book)request.getParameter();
            BookCommandService.addBook(book);
        }

        else if(request.getRequest().equals("deleteBook")){
            int id=(int)request.getParameter();
            BookCommandService.deleteById(id);
        }

        else if(request.getRequest().equals("borrowBook")){
            Book book=(Book)request.getParameter();
            BookCommandService.update(book);
            BookCommandService.decreaseQuantity(book.getId());
        }

        else if(request.getRequest().equals("returnBook")){
            Book book=(Book)request.getParameter();
            BookCommandService.update(book);
            BookCommandService.addQuantity(book.getId());
        }



    }
}
