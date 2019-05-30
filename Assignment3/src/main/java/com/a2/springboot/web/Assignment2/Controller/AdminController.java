package com.a2.springboot.web.Assignment2.Controller;

import com.a2.springboot.web.Assignment2.Model.Data.Book;
import com.a2.springboot.web.Assignment2.Model.Services.DBAccess.BookService;
import com.a2.springboot.web.Assignment2.Model.Services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

    @Autowired
    LoginService loginService;

    @RequestMapping("/admin")
    public String adminPageGET(ModelMap model) {

        model.put("books",BookService.getAll());
        return "admin";
    }

    @RequestMapping(value="/admin",method=RequestMethod.POST)
    public  String adminPagePOST(@RequestParam String title,@RequestParam String author,@RequestParam String genre,@RequestParam String price,@RequestParam String quantity,ModelMap model){
        Book book=new Book(title,author,genre,Integer.parseInt(price),Integer.parseInt(quantity));
        BookService.addBook(book);
        model.put("books",BookService.getAll());

        return "admin";
    }

    @RequestMapping("/adminLogin")
    public String adminLoginGET(ModelMap model){


        return "adminLogin";

    }

    @RequestMapping(value="/adminLogin", method= RequestMethod.POST)
    public String adminLoginPOST(@RequestParam String username,@RequestParam String password, ModelMap model){

        if(!loginService.staffIsValid(username,password)){
            model.put("errorMessage","Invalid Credentials\n");
            return "adminLogin";
        }


        return "redirect:/admin";

    }

    @RequestMapping("/deleteBook")
    public String deleteBook(@RequestParam int id){
        BookService.deleteById(id);
        return "redirect:/admin";
    }

    @RequestMapping("/addBook")
    public String addBook(@RequestParam int id){
        BookService.addQuantity(id);
        return "redirect:/admin";
    }
}

