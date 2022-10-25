package com.epam.training.smarthome.domain.devices.heatingsystem;

public class LegacyHeatingSystem {
    private boolean isTurnedOn;

    public LegacyHeatingSystem(boolean isTurnedOn) {
        this.isTurnedOn = isTurnedOn;
    }

    public boolean isTurnedOn() {
        return isTurnedOn;
    }

    public void operate(boolean isTurnedOn) {
        this.isTurnedOn = isTurnedOn;
    }
}
