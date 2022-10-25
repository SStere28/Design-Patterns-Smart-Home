package com.epam.training.smarthome.domain.devices.heatingsystem;

public interface HeatingSystemAdapter {
    void turnOn();

    void turnOff();

    boolean isTurnedOn();
}
