package com.epam.training.smarthome.domain.observer;

import java.util.ArrayList;

public class Observable {

    private Observer observer1;

    public void addObserver(Observer observer) {
        this.observer1 = observer;
    }

    public void notifyObservers(String message) {
        observer1.update(message);
    }
}
