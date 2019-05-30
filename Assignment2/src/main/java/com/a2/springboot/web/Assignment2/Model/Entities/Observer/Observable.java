package com.a2.springboot.web.Assignment2.Model.Entities.Observer;

public interface Observable {

    void notifyAllObservers();
    void register(Observer observer);

}
