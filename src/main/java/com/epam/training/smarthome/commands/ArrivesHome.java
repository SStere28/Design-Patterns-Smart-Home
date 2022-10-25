package com.epam.training.smarthome.commands;

import com.epam.training.smarthome.controller.HomeController;

public class ArrivesHome extends EventCommand {

    HomeController homeController;

    public ArrivesHome(HomeController homeController) {
        super(homeController);

        this.homeController = homeController;

    }

    @Override
    public void execute() {
        homeController.onArriveHome();

    }
}