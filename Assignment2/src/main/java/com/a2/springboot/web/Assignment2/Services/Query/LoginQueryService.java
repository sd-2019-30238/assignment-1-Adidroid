package com.a2.springboot.web.Assignment2.Services.Query;

import org.springframework.stereotype.Service;

@Service
public class LoginQueryService {

    public boolean userIsValid(String username, String password){
        return UserQueryService.checkUser(username,password);

    }


    public boolean staffIsValid(String username, String password){
        return StaffQueryService.checkStaff(username,password);
    }
}
