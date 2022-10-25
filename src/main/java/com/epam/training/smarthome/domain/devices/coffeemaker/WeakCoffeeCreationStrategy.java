package com.epam.training.smarthome.domain.devices.coffeemaker;

public class WeakCoffeeCreationStrategy implements CoffeeCreationStrategy {

    private final Integer CAFFEINE_IN_MG = 20;

    @Override
    public Integer getCaffeineMg() {
        return CAFFEINE_IN_MG;
    }
}
