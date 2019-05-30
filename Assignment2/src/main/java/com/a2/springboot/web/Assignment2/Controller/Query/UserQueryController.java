package com.a2.springboot.web.Assignment2.Controller.Query;

import com.a2.springboot.web.Assignment2.Services.Query.BookQueryService;
import com.a2.springboot.web.Assignment2.Services.Query.UserQueryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class UserQueryController {

    @RequestMapping("/user")
    public String userPage(ModelMap model){
        model.put("books", BookQueryService.getAll());
        model.put("myBooks", UserQueryService.getUserBooksByUsername((String)model.get("name")));
        return "user";
    }


}
