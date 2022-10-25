package com.epam.training.smarthome.commands;

import com.epam.training.smarthome.controller.HomeController;

public class ChangeToWorkingDay extends EventCommand {

    private HomeController homeController;

    public ChangeToWorkingDay(HomeController homeController) {
        super(homeController);
        this.homeController = homeController;

    }

    @Override
    public void execute() {
        homeController.onChangeToWorkingDay();

    }
}