package com.epam.training.smarthome.domain.devices.coffeemaker;

import com.epam.training.smarthome.domain.observer.Observable;

public class CoffeeMaker extends Observable {
    private CoffeeCreationStrategy coffeeCreationStrategy;

    public CoffeeMaker(CoffeeCreationStrategy coffeeCreationStrategy) {
        this.coffeeCreationStrategy = coffeeCreationStrategy;
    }

    public void setCoffeeCreationStrategy(CoffeeCreationStrategy coffeeCreationStrategy) {
        if(!this.coffeeCreationStrategy.equals(coffeeCreationStrategy)){
        notifyObservers("[CoffeeMaker] change the type of coffee");
        this.coffeeCreationStrategy = coffeeCreationStrategy;}


    }

    public void createCoffee() {
        if (coffeeCreationStrategy.getCaffeineMg() == 20) {
            notifyObservers("[CoffeeMaker] create coffee with 20mg caffeine");
        } else if (coffeeCreationStrategy.getCaffeineMg() == 40) {
            notifyObservers("[CoffeeMaker] create coffee with 40mg caffeine");
        }

    }
}
