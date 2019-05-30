package com.a2.springboot.web.Assignment2.Services.Command;

import com.a2.springboot.web.Assignment2.Model.DAO.SessionUtil;
import com.a2.springboot.web.Assignment2.Model.DAO.impl.StaffDAO;
import com.a2.springboot.web.Assignment2.Model.Entities.Staff;

public class StaffCommandService {



    public static void addStaff(Staff staff){
        new StaffDAO(SessionUtil.getSessionFactory()).save(staff);
    }
}


