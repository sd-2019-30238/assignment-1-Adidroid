package BusinessLogic.Model;

import javax.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    @Column
    private String title;
    @Column
    private String author;
    @Column
    private String genre;
    @Column
    private int price;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @Column(name = "user_id", insertable = false, updatable = false)
    private String user_id;

    public Book() {

    }

    public Book(String title, String author, String genre, int price) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.price = price;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id= user_id;
    }
}
