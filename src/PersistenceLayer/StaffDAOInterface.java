package PersistenceLayer;

import Model.Staff;

public interface StaffDAOInterface extends CRUD<Staff> {
    Staff findByUsername(String username);


}
