package BusinessLogic.Service;


import PersistenceLayer.SessionUtil;
import BusinessLogic.Model.Book;
import PersistenceLayer.impl.BookDAO;

import java.util.List;

public class BookService {


    public static void addBook(Book book){
        new BookDAO(SessionUtil.getSessionFactory()).save(book);

    }

    public static Book get(int id){
        return new BookDAO(SessionUtil.getSessionFactory()).get(id);
    }

    public static List<Book> getAll(){
        return new BookDAO(SessionUtil.getSessionFactory()).getAll();
    }

    public static void deleteById(int id){
        new BookDAO(SessionUtil.getSessionFactory()).deleteById(id);
    }

    public static void update(Book book){
        new BookDAO(SessionUtil.getSessionFactory()).update(book);
    }

    public static List<Book> getAllGenre(String genre){
        return new BookDAO(SessionUtil.getSessionFactory()).getAllGenre(genre);


    }
}
