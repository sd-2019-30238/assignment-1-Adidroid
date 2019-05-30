package com.a2.springboot.web.Assignment2.Controller.Query;

import com.a2.springboot.web.Assignment2.Services.Query.LoginQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginQueryController {

    @Autowired
    LoginQueryService loginQueryService;



    @RequestMapping(value="/login",method = RequestMethod.POST)
    public String welcomePage(@RequestParam String name, @RequestParam String password, ModelMap model){
        if(!loginQueryService.userIsValid(name,password)){
            model.put("errorMessage","Invalid Credentials\n");
            return "login";
        }

        model.put("name",name);
        return "welcome";

    }
}
