package PersistenceLayer.impl;

import BusinessLogic.Model.Book;
import BusinessLogic.Model.User;
import PersistenceLayer.UserDAOInterface;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.transaction.Transactional;
import java.util.List;

public class UserDAO extends AbstractDAO<User> implements UserDAOInterface {
    public UserDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
        setClazz(User.class);
    }

    @Override

    @Transactional()
    public User findByUsername(String username) {
        beginTransaction();
        User user= sessionFactory.getCurrentSession().get(User.class,username);
        //Hibernate.initialize(user.getBooksBucket());

        commitTransaction();
        return user;
    }

    @SuppressWarnings("unchecked")
    public List<Book> getUserBooks(User user){
        beginTransaction();

        Session session=sessionFactory.getCurrentSession();
        List<Book> userBooks= session.createQuery("from Book b where b.user=" + "\'" +user.getUsername() + "\'").list();
        commitTransaction();

        return userBooks;
    }
}
