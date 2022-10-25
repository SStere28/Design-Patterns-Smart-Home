package com.epam.training.smarthome.domain.devices.heatingsystem;

import com.epam.training.smarthome.domain.observer.Observable;

public class HeatingSystem extends Observable implements HeatingSystemAdapter {
    private LegacyHeatingSystem legacyHeatingSystem;

    public HeatingSystem(LegacyHeatingSystem legacyHeatingSystem) {
        this.legacyHeatingSystem = legacyHeatingSystem;
    }

    @Override
    public void turnOn() {
        legacyHeatingSystem.operate(true);
        notifyObservers("[HeatingSystem] turn on");
    }

    @Override
    public void turnOff() {
        legacyHeatingSystem.operate(false);
        notifyObservers("[HeatingSystem] turn off");
    }

    @Override
    public boolean isTurnedOn() {
        return legacyHeatingSystem.isTurnedOn();
    }
}
