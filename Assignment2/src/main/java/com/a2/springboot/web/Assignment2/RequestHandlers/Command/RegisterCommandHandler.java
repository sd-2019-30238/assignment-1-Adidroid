package com.a2.springboot.web.Assignment2.RequestHandlers.Command;

import com.a2.springboot.web.Assignment2.Model.Entities.User;
import com.a2.springboot.web.Assignment2.Request.Request;
import com.a2.springboot.web.Assignment2.RequestHandlers.RequestHandlerInterface;
import com.a2.springboot.web.Assignment2.Services.Command.RegisterCommandService;
import org.springframework.beans.factory.annotation.Autowired;

public class RegisterCommandHandler implements RequestHandlerInterface {


    private RegisterCommandService registerCommandService=new RegisterCommandService();

    @Override
    public void handle(Request request) {
        if(request.getRequest().equals("register")){
            User user=(User)request.getParameter();

            registerCommandService.register(user.getUsername(),user.getPassword());
        }

    }
}
