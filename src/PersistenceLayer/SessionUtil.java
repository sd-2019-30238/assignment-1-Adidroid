package PersistenceLayer;

import BusinessLogic.Model.Book;
import BusinessLogic.Model.PaymentPlan;
import BusinessLogic.Model.Staff;
import BusinessLogic.Model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionUtil {
    private static SessionFactory sessionFactory;

    private static SessionFactory buildSessionFactory() {
        return new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Book.class)
                .addAnnotatedClass(Staff.class)
                .addAnnotatedClass(PaymentPlan.class)
                .buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) sessionFactory = buildSessionFactory();
        return sessionFactory;
    }
}
