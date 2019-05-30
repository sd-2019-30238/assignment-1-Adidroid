package com.a2.springboot.web.Assignment2.Services.Query;

import com.a2.springboot.web.Assignment2.Model.DAO.SessionUtil;
import com.a2.springboot.web.Assignment2.Model.DAO.impl.StaffDAO;
import com.a2.springboot.web.Assignment2.Model.Entities.Staff;

public class StaffQueryService {

    public static boolean checkStaff(String username,String password) {

        Staff staff = new StaffDAO(SessionUtil.getSessionFactory()).findByUsername(username);
        if (staff == null)
            return false;

        if (!staff.getPassword().equals(password))
            return false;
        return true;
    }


}
