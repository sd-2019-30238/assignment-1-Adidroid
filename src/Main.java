import Model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Main {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            //User u=new User("Adi2348","12345");
           // session.beginTransaction();
            //session.save(u);

           // User user=session.get(User.class,"Adi2348");
            //session.getTransaction().commit();

           // System.out.println(user.getUsername());


        } finally {
            session.close();

        }

    }


}
