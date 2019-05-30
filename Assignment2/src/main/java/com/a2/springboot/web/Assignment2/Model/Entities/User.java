package com.a2.springboot.web.Assignment2.Model.Entities;

import com.a2.springboot.web.Assignment2.Model.Entities.Observer.Observer;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User extends Account implements Observer {

    @OneToMany(fetch = FetchType.LAZY,cascade= CascadeType.ALL,mappedBy = "user")
    private Set<Book> booksBucket;


    @Column
    @ColumnDefault("0")
    private int money;

    public User(String username, String password, Set<Book> booksBucket) {
        super(username, password);
        this.booksBucket=booksBucket;
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

    @Override
    public void update(String book) {
        System.out.println(this.getUsername()+": Book " +book+" is available!");
    }
}
