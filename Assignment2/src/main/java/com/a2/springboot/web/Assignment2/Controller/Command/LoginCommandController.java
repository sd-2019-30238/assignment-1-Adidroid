package com.a2.springboot.web.Assignment2.Controller.Command;

import com.a2.springboot.web.Assignment2.Services.Query.LoginQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginCommandController {



    @RequestMapping(value="/login",method = RequestMethod.GET)
    public String loginPage(ModelMap model){

        return "login";

    }



}
