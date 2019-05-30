package com.a2.springboot.web.Assignment2.Controller.Command;

import com.a2.springboot.web.Assignment2.Mediator.Mediator;
import com.a2.springboot.web.Assignment2.Model.Entities.Book;
import com.a2.springboot.web.Assignment2.Model.Entities.User;
import com.a2.springboot.web.Assignment2.Request.Request;
import com.a2.springboot.web.Assignment2.Request.RequestType;
import com.a2.springboot.web.Assignment2.Services.Command.BookCommandService;
import com.a2.springboot.web.Assignment2.Services.Query.BookQueryService;
import com.a2.springboot.web.Assignment2.Services.Query.UserQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class UserCommandController {

    @Autowired
    Mediator requestHandler;

    @RequestMapping("/buyBook")
    public String buyBook(@RequestParam int id, ModelMap model) {

        Book book = BookQueryService.get(id);

        if (book.getQuantity() != 0) {
            User user = UserQueryService.get((String) model.get("name"));
            book.setUser(user);

            requestHandler.handle(new Request("borrowBook",book, RequestType.BOOK_COMMAND));


        } else {
            User user = UserQueryService.get((String) model.get("name"));
            book.register(user);

        }

        return "redirect:/user";
    }

    @RequestMapping("/returnBook")
    public String returnBook(@RequestParam int id){

        Book book=BookQueryService.get(id);

        if(book.getQuantity()!=1){

            book.setUser(null);
            requestHandler.handle(new Request("returnBook",book, RequestType.BOOK_COMMAND));

        }

        book.notifyAllObservers();

        return "redirect:/user";

    }


}
