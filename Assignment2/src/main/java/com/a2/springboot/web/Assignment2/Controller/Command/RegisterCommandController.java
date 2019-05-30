package com.a2.springboot.web.Assignment2.Controller.Command;

import com.a2.springboot.web.Assignment2.Mediator.Mediator;
import com.a2.springboot.web.Assignment2.Model.Entities.User;
import com.a2.springboot.web.Assignment2.Request.Request;
import com.a2.springboot.web.Assignment2.Request.RequestType;
import com.a2.springboot.web.Assignment2.Services.Command.RegisterCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;

@Controller
public class RegisterCommandController {

    @Autowired
    Mediator requestHandler;

    @RequestMapping(value="/registerConfirmation")
    public String registerConfirmationPage(@RequestParam String name, @RequestParam String password, ModelMap model){
        model.put("name",name);

        User user=new User(name,password,new HashSet<>());
        requestHandler.handle(new Request("register",user, RequestType.REGISTER_COMMAND));

        return "registerConfirmation";
    }
}
