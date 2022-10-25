package com.epam.training.smarthome.commands;

import com.epam.training.smarthome.controller.HomeController;

public class Movement extends EventCommand {

    private HomeController homeController;

    public Movement(HomeController homeController) {
        super(homeController);
        this.homeController = homeController;

    }

    @Override
    public void execute() {
        homeController.onMovement();

    }
}