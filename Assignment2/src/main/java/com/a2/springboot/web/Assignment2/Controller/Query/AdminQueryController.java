package com.a2.springboot.web.Assignment2.Controller.Query;

import com.a2.springboot.web.Assignment2.Model.Entities.Book;
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
public class AdminQueryController {

    @Autowired
    LoginQueryService loginQueryService;

    @RequestMapping("/admin")
    public String adminPageGET(ModelMap model) {

        model.put("books", BookQueryService.getAll());
        return "admin";
    }


    @RequestMapping("/adminLogin")
    public String adminLoginGET(ModelMap model) {


        return "adminLogin";

    }

    @RequestMapping(value = "/adminLogin", method = RequestMethod.POST)
    public String adminLoginPOST(@RequestParam String username, @RequestParam String password, ModelMap model) {

        if (!loginQueryService.staffIsValid(username, password)) {
            model.put("errorMessage", "Invalid Credentials\n");
            return "adminLogin";
        }


        return "redirect:/admin";

    }
}
