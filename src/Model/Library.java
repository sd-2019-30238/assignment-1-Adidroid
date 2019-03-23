package Model;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Library {

    private String name;
    private Map<Integer, Book> books;
    private List<Staff> libraryStaff;

    public Library(String name,  Map<Integer, Book> books, List<Staff> libraryStaff) {
        this.name = name;
        this.books = books;
        this.libraryStaff = libraryStaff;
    }

    public void addBook(Book book) {
        books.put(book.getId(),book);
    }

    public void removeBook(int bookId) {
      books.remove(bookId);
    }


}
