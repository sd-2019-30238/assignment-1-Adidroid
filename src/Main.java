import Model.*;
import PersistenceLayer.impl.LibraryDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class Main {



    public static void main(String[] args) {

        SessionFactory factory= new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Book.class)
                .addAnnotatedClass(Staff.class)
                .addAnnotatedClass(Library.class)
                .addAnnotatedClass(PaymentPlan.class)
                .buildSessionFactory();


        Session session = factory.getCurrentSession();

        try {

           //new LibraryDAO(factory).save(new Library("test2",new HashMap<Integer, Book>(),new ArrayList<Staff>()));
            LibraryDAO libDao=new LibraryDAO(factory);

            List<Library> list =libDao.getAll();
            for(Library l:list)
                System.out.println(l.getName());





        } finally {
            session.close();

        }

    }


}
