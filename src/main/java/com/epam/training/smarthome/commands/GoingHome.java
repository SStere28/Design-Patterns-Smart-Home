package com.epam.training.smarthome.commands;

import com.epam.training.smarthome.controller.HomeController;

public class GoingHome extends EventCommand {

    private HomeController homeController;

    public GoingHome(HomeController homeController) {
        super(homeController);
        this.homeController = homeController;

    }

    @Override
    public void execute() {
        homeController.onGoingHome();
    }
}
