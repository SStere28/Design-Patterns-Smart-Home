package com.epam.training.smarthome.domain.observer;

import java.util.ArrayList;

public class MessageObserver implements Observer {

    private ArrayList<String> messages = new ArrayList<>();

    public ArrayList<String> getMessages() {
        return messages;
    }


    public void update(String message) {
        System.out.println(message);
        messages.add(message);
    }
}
