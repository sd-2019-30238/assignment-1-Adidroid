package com.a2.springboot.web.Assignment2.Controller;

import com.a2.springboot.web.Assignment2.Model.Data.Book;
import com.a2.springboot.web.Assignment2.Model.Data.User;
import com.a2.springboot.web.Assignment2.Model.Services.DBAccess.BookService;
import com.a2.springboot.web.Assignment2.Model.Services.DBAccess.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class UserController {

    @RequestMapping("/user")
    public String userPage(ModelMap model){
        model.put("books", BookService.getAll());
        model.put("myBooks",UserService.getUserBooksByUsername((String)model.get("name")));
        return "user";
    }

    @RequestMapping("/buyBook")
    public String buyBook(@RequestParam int id,ModelMap model){

        Book book=BookService.get(id);

        if(book.getQuantity()!=0){
            User user= UserService.get((String)model.get("name"));

            book.setUser(user);
            BookService.update(book);
            BookService.decreaseQuantity(id);

        }

        else {
            User user= UserService.get((String)model.get("name"));
            book.register(user);

        }

        return "redirect:/user";

    }

    @RequestMapping("/returnBook")
    public String returnBook(@RequestParam int id){

        Book book=BookService.get(id);

        if(book.getQuantity()!=1){

            book.setUser(null);
            BookService.update(book);
            BookService.addQuantity(id);

        }

        book.notifyAllObservers();

        return "redirect:/user";

    }
}
