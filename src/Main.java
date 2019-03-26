import Model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.HashMap;


public class Main {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Book.class)
                .addAnnotatedClass(Staff.class)
                .addAnnotatedClass(Library.class)
                .addAnnotatedClass(PaymentPlan.class)
                .buildSessionFactory();


        Session session = factory.getCurrentSession();

        try {
            //Book book=new Book("test","Adi",15);
           // User u=new User("Adi","12345",new HashMap<Integer, Book>(), PaymentPlan.MONTH);
           // session.beginTransaction();
           // session.save(book);
           // session.save(u);

           // User user=session.get(User.class,"Adi2348");
          //  session.getTransaction().commit();

           // System.out.println(user.getUsername());


        } finally {
            session.close();

        }

    }


}
