package PersistenceLayer.impl;

import Model.User;
import PersistenceLayer.UserDAOInterface;
import org.hibernate.SessionFactory;

public class UserDAO extends AbstractDAO<User> implements UserDAOInterface {
    public UserDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
        setClazz(User.class);
    }

    @Override
    public User findByUsername(String username) {
        return  sessionFactory.getCurrentSession().get(User.class,username);
    }
}
