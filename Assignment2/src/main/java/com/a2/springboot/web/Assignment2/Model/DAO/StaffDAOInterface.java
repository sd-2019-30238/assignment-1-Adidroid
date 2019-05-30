package com.a2.springboot.web.Assignment2.Model.DAO;


import com.a2.springboot.web.Assignment2.Model.Entities.Staff;

public interface StaffDAOInterface extends CRUD<Staff> {
    Staff findByUsername(String username);


}
