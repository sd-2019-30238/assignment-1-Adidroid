package PersistenceLayer;

import BusinessLogic.Model.User;

public interface UserDAOInterface extends CRUD<User> {

    User findByUsername(String username);
}
