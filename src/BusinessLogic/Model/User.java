package BusinessLogic.Model;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User extends Account {

    @OneToMany(fetch = FetchType.LAZY,cascade=CascadeType.ALL,mappedBy = "user")
    private Set<Book> booksBucket;

    @Enumerated
    private PaymentPlan paymentPlan;

    @Column
    @ColumnDefault("0")
    private int money;

    public User(String username, String password, Set<Book> booksBucket, PaymentPlan paymentPlan) {
        super(username, password);
        this.booksBucket=booksBucket;
        this.paymentPlan=paymentPlan;
    }

    public User(){

    }

    public void addBookToBucket(Book book) {
        booksBucket.add(book);
    }
    public void removeBookFromBucket(Book book) {
        booksBucket.remove(book);
    }

    public Set<Book> getBooksBucket() {
        return booksBucket;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
