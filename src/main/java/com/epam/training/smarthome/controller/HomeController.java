package com.epam.training.smarthome.controller;

import com.epam.training.smarthome.domain.devices.AlarmSystem;
import com.epam.training.smarthome.domain.devices.FrontDoor;
import com.epam.training.smarthome.domain.devices.Light;
import com.epam.training.smarthome.domain.devices.coffeemaker.CoffeeMaker;
import com.epam.training.smarthome.domain.devices.coffeemaker.StrongCoffeeCreationStrategy;
import com.epam.training.smarthome.domain.devices.coffeemaker.WeakCoffeeCreationStrategy;
import com.epam.training.smarthome.domain.devices.heatingsystem.HeatingSystem;
import com.epam.training.smarthome.domain.devices.heatingsystem.HeatingSystemAdapter;
import com.epam.training.smarthome.domain.devices.heatingsystem.LegacyHeatingSystem;
import com.epam.training.smarthome.domain.observer.Observer;


public class HomeController {
    private AlarmSystem alarmSystem;
    private FrontDoor frontDoor;
    private HeatingSystemAdapter heatingSystemAdapter;
    private Light light;
    private CoffeeMaker coffeeMaker;

    public HomeController(HomeControllerBuilder homeControllerBuilder) {
        this.alarmSystem = homeControllerBuilder.alarmSystem;
        this.frontDoor = homeControllerBuilder.frontDoor;
        this.heatingSystemAdapter = homeControllerBuilder.heatingSystem;
        this.light = homeControllerBuilder.light;
        this.coffeeMaker = homeControllerBuilder.coffeeMaker;
    }

    public void onMovement() {
        System.out.println("\n--> Movement event");
        if (alarmSystem.isTurnedOn()) {
            alarmSystem.alarm();
        }

        if (!light.isTurnedOn()) {
            light.turnOn();
        } else System.out.println("[HomeController] nothing to do (light is already turned on)");

    }

    public void onGoingHome() {
        System.out.println("\n--> Going home event");
        if (!heatingSystemAdapter.isTurnedOn()) {
            heatingSystemAdapter.turnOn();
        } else System.out.println("[HomeController] nothing to do (heating system is already turned on)");

    }

    public void onArriveHome() {
        System.out.println("\n--> Arrive home even");
        if (alarmSystem.isTurnedOn()) {
            alarmSystem.turnOff();
        } else System.out.println("[HomeController] nothing to do (alarm system is already turned off)");

        if (!frontDoor.isOpen()) {
            frontDoor.open();
        } else System.out.println("[HomeController] nothing to do (front door is already opened");

        coffeeMaker.createCoffee();

    }

    public void onChangeToHoliday() {
        System.out.println("\n--> Change to holiday event");
        coffeeMaker.setCoffeeCreationStrategy(new WeakCoffeeCreationStrategy());
    }

    public void onChangeToWorkingDay() {
        System.out.println("\n--> Change to working day event");
        coffeeMaker.setCoffeeCreationStrategy(new StrongCoffeeCreationStrategy());
    }


    public static class HomeControllerBuilder {
        private AlarmSystem alarmSystem = new AlarmSystem(false);
        private FrontDoor frontDoor = new FrontDoor(false);
        private HeatingSystem heatingSystem = new HeatingSystem(new LegacyHeatingSystem(false));
        private Light light = new Light(false);
        private CoffeeMaker coffeeMaker = new CoffeeMaker(new StrongCoffeeCreationStrategy());
        private Observer messageObserver;


        public HomeControllerBuilder(Observer messageObserver) {
            this.messageObserver = messageObserver;
            this.frontDoor.addObserver(messageObserver);
            this.alarmSystem.addObserver(messageObserver);
            this.heatingSystem.addObserver(messageObserver);
            this.light.addObserver(messageObserver);
            this.coffeeMaker.addObserver(messageObserver);
        }

        public HomeControllerBuilder alarmSystem(AlarmSystem alarmSystem) {
            this.alarmSystem = alarmSystem;
            this.alarmSystem.addObserver(messageObserver);
            return this;
        }

        public HomeControllerBuilder frontDoor(FrontDoor frontDoor) {
            this.frontDoor = frontDoor;
            this.frontDoor.addObserver(messageObserver);
            return this;
        }

        public HomeControllerBuilder heatingSystem(HeatingSystem heatingSystem) {
            this.heatingSystem = heatingSystem;
            this.heatingSystem.addObserver(messageObserver);
            return this;
        }

        public HomeControllerBuilder light(Light light) {
            this.light = light;
            this.light.addObserver(messageObserver);
            return this;
        }

        public HomeControllerBuilder coffeeMaker(CoffeeMaker coffeeMaker) {
            this.coffeeMaker = coffeeMaker;
            this.coffeeMaker.addObserver(messageObserver);
            return this;
        }

        public HomeController build() {

            return new HomeController(this);
        }
    }


}
