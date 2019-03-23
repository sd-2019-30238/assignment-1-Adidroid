package Model;

import java.util.Map;

public class User extends Account {

    private Map<Integer, Book> booksBucket;
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
