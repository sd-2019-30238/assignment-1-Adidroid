package com.a2.springboot.web.Assignment2.Model.Entities;

import javax.persistence.Entity;

@Entity
public class Staff extends Account {

    public Staff(){
        super();

    }

    public Staff(String username, String password) {
        super(username, password);
    }
}
