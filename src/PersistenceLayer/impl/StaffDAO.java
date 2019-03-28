package PersistenceLayer.impl;

import Model.Staff;
import PersistenceLayer.StaffDAOInterface;
import org.hibernate.SessionFactory;

public class StaffDAO extends AbstractDAO<Staff> implements StaffDAOInterface {
    public StaffDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
        setClazz(Staff.class);
    }

    @Override
    public Staff findByUsername(String username) {
        return sessionFactory.getCurrentSession().get(Staff.class, username);

    }
}
