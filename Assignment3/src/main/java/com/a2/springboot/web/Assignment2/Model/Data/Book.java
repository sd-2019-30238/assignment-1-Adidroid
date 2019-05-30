package com.a2.springboot.web.Assignment2.Model.Data;

import com.a2.springboot.web.Assignment2.Model.Data.Observer.Observable;
import com.a2.springboot.web.Assignment2.Model.Data.Observer.Observer;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Book implements Observable {



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

    @Column
    private int quantity;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @Column(name = "user_id", insertable = false, updatable = false)
    private String user_id;

    @Transient
    private List<Observer> observers=new ArrayList<>();



    public Book() {

    }

    public Book(String title, String author, String genre, int price,int quantity) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.price = price;
        this.quantity=quantity;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public void notifyAllObservers() {
        for(Observer obs:observers)
            obs.update(title);
    }

    @Override
    public void register(Observer observer) {
        observers.add(observer);

    }


    public void unregister(Observer observer) {

    }
}
