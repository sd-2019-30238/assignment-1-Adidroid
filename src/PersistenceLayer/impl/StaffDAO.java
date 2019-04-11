package PersistenceLayer.impl;

import BusinessLogic.Model.Staff;
import PersistenceLayer.StaffDAOInterface;
import org.hibernate.SessionFactory;

public class StaffDAO extends AbstractDAO<Staff> implements StaffDAOInterface {
    public StaffDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
        setClazz(Staff.class);
    }

    @Override
    public Staff findByUsername(String username) {
        beginTransaction();
        Staff staff=sessionFactory.getCurrentSession().get(Staff.class, username);
        commitTransaction();
        return staff;

    }
}
