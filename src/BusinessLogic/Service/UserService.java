package BusinessLogic.Service;

import PersistenceLayer.SessionUtil;
import BusinessLogic.Model.Book;
import BusinessLogic.Model.User;
import PersistenceLayer.impl.UserDAO;

import java.util.List;

public class UserService {

    public static void addUser(User user){
        new UserDAO(SessionUtil.getSessionFactory()).save(user);
    }

    public static boolean checkUser(String username,String password){

            User user=new UserDAO(SessionUtil.getSessionFactory()).findByUsername(username);
            if(user == null)
                return false;

            if(!user.getPassword().equals(password))
                return false;
            return true;

    }

    public static User get(String username){
        return new UserDAO(SessionUtil.getSessionFactory()).findByUsername(username);
    }

    public static void update(User user){
        new UserDAO(SessionUtil.getSessionFactory()).update(user);
    }

    public static List<Book> getUserBooks(User user){
        return new UserDAO(SessionUtil.getSessionFactory()).getUserBooks(user);

    }
}
