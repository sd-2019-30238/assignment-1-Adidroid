package Model;

import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.Map;

@Entity
public class User extends Account {

    @ManyToMany(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
    private Map<Integer, Book> booksBucket;

    @Enumerated
    private PaymentPlan paymentPlan;

    public User(String username, String password, Map<Integer, Book> booksBucket, PaymentPlan paymentPlan) {
        super(username, password);
        this.booksBucket=booksBucket;
        this.paymentPlan=paymentPlan;
    }

    public void addBookToBucket(Book book) {
        booksBucket.put(book.getId(), book);
    }
    public void removeBookFromBucket(int bookId) {
        booksBucket.remove(bookId);
    }
}
