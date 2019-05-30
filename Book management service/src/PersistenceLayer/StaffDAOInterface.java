package PersistenceLayer;

import BusinessLogic.Model.Staff;

public interface StaffDAOInterface extends CRUD<Staff> {
    Staff findByUsername(String username);


}
