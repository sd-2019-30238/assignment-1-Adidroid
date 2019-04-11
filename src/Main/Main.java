package Main;

import PersistenceLayer.SessionUtil;

import Presentation.Login;
import org.hibernate.Session;


public class Main {

    public static void main(String[] args) {



        Login login=new Login();
        login.setVisible(true);

       Session session= SessionUtil.getSessionFactory().getCurrentSession();



//       session.beginTransaction();
//
//       Book book=new Book("test23","sdg","dsf",56);
//       User user=new User("adi34","asf",new HashSet<Book>(),PaymentPlan.MONTH);
//
//
//       user.addBookToBucket(book);
//
//        session.save(book);
//       session.save(user);
//
//
//       session.getTransaction().commit();


    }


}



