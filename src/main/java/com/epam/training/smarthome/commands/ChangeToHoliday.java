package com.epam.training.smarthome.commands;

import com.epam.training.smarthome.controller.HomeController;

public class ChangeToHoliday extends EventCommand {

    private HomeController homeController;

    public ChangeToHoliday(HomeController homeController) {
        super(homeController);
        this.homeController = homeController;

    }

    @Override
    public void execute() {
        homeController.onChangeToHoliday();

    }
}