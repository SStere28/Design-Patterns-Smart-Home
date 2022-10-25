package com.epam.training.smarthome.domain.devices;

import com.epam.training.smarthome.domain.observer.Observable;

public class AlarmSystem extends Observable {
    private boolean isTurnedOn;

    public AlarmSystem(boolean isTurnedOn) {
        this.isTurnedOn = isTurnedOn;
    }

    public boolean isTurnedOn() {
        return isTurnedOn;
    }

    public void turnOff() {
        isTurnedOn = false;
        notifyObservers("[AlarmSystem] turn off");

    }

    public void turnOn() {
        isTurnedOn = true;
        notifyObservers("[AlarmSystem] turn on");

    }

    public void alarm() {
        isTurnedOn = true;
        notifyObservers("[AlarmSystem] alarm");
    }

}
