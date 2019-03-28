package PersistenceLayer.impl;

import Model.Library;
import PersistenceLayer.LibraryDAOInterface;
import org.hibernate.SessionFactory;

public class LibraryDAO extends AbstractDAO<Library> implements LibraryDAOInterface {

    public LibraryDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
        setClazz(Library.class);
    }
}
