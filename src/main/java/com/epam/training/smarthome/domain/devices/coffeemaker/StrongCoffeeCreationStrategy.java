package com.epam.training.smarthome.domain.devices.coffeemaker;

public class StrongCoffeeCreationStrategy implements CoffeeCreationStrategy {

    private final Integer CAFFEINE_IN_MG = 40;

    @Override
    public Integer getCaffeineMg() {
        return CAFFEINE_IN_MG;
    }
}
