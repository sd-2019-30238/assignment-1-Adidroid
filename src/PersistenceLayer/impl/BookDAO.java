package PersistenceLayer.impl;

import Model.Book;
import PersistenceLayer.BookDAOInterface;
import org.hibernate.SessionFactory;

public class BookDAO extends AbstractDAO<Book> implements BookDAOInterface {

    public BookDAO(SessionFactory sessionFactory){
        super(sessionFactory);
        setClazz(Book.class);

    }
}
