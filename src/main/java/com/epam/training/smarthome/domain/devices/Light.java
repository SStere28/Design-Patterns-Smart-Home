package com.epam.training.smarthome.domain.devices;

import com.epam.training.smarthome.domain.observer.Observable;

public class Light extends Observable {
    private boolean isTurnedOn;

    public Light(boolean isTurnedOn) {
        this.isTurnedOn = isTurnedOn;
    }

    public boolean isTurnedOn() {
        return isTurnedOn;
    }

    public void turnOn() {
        isTurnedOn = true;
        notifyObservers("[Light] turn on");

    }

    public void turnOff() {
        isTurnedOn = false;
        notifyObservers("[Light] turn off");

    }
}
