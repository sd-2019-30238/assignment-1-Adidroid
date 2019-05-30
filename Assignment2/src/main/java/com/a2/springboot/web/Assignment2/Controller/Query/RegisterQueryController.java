package com.a2.springboot.web.Assignment2.Controller.Query;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterQueryController {

    @RequestMapping(value="/register")
    public String registerPage(){
        return "register";
    }
}
