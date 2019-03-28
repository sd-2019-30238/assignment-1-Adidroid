package Model;


import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;

    @OneToMany(cascade=CascadeType.ALL)
    @MapKey(name = "id")
    private Map<Integer, Book> books;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "LibraryID")
    private List<Staff> libraryStaff;

    public Library() {
    }

    public Library(String name, Map<Integer, Book> books, List<Staff> libraryStaff) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Integer, Book> getBooks() {
        return books;
    }

    public void setBooks(Map<Integer, Book> books) {
        this.books = books;
    }

    public List<Staff> getLibraryStaff() {
        return libraryStaff;
    }

    public void setLibraryStaff(List<Staff> libraryStaff) {
        this.libraryStaff = libraryStaff;
    }
}
