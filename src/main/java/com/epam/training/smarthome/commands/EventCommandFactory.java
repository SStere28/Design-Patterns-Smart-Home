package com.epam.training.smarthome.commands;

import com.epam.training.smarthome.controller.HomeController;

public class EventCommandFactory {
    private HomeController homeController;

    public EventCommandFactory(HomeController homeController) {
        this.homeController = homeController;
    }

    public EventCommand createEventCommand(EventCommandType type) {
        switch (type) {
            case ARRIVES_HOME -> {
                return new ArrivesHome(homeController);
            }
            case GOING_HOME -> {
                return new GoingHome(homeController);
            }
            case MOVEMENT -> {
                return new Movement(homeController);
            }
            case CHANGE_TO_HOLIDAY -> {
                return new ChangeToHoliday(homeController);
            }
            case CHANGE_TO_WORKING_DAY -> {
                return new ChangeToWorkingDay(homeController);
            }
        }
        return null;
    }
}
