package com.a2.springboot.web.Assignment2.Controller.Command;

import com.a2.springboot.web.Assignment2.Mediator.Mediator;
import com.a2.springboot.web.Assignment2.Model.Entities.Book;
import com.a2.springboot.web.Assignment2.Request.Request;
import com.a2.springboot.web.Assignment2.Request.RequestType;
import com.a2.springboot.web.Assignment2.Services.Command.BookCommandService;
import com.a2.springboot.web.Assignment2.Services.Query.BookQueryService;
import com.a2.springboot.web.Assignment2.Services.Query.LoginQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminCommandController {

    @Autowired
    Mediator requestHandler;


    @RequestMapping(value="/admin",method= RequestMethod.POST)
    public  String adminPagePOST(@RequestParam String title,@RequestParam String author,@RequestParam String genre,@RequestParam String price,@RequestParam String quantity,ModelMap model){
        Book book=new Book(title,author,genre,Integer.parseInt(price),Integer.parseInt(quantity));
        requestHandler.handle(new Request("addBook",book, RequestType.BOOK_COMMAND));

        model.put("books", BookQueryService.getAll());

        return "admin";
    }




    @RequestMapping("/deleteBook")
    public String deleteBook(@RequestParam int id){
       requestHandler.handle(new Request("deleteBook",id,RequestType.BOOK_COMMAND));
        return "redirect:/admin";
    }


}
