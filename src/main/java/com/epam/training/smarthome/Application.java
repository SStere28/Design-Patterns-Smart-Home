package com.epam.training.smarthome;

import com.epam.training.smarthome.commands.EventCommand;
import com.epam.training.smarthome.commands.EventCommandFactory;
import com.epam.training.smarthome.commands.EventCommandType;
import com.epam.training.smarthome.controller.HomeController;
import com.epam.training.smarthome.domain.devices.AlarmSystem;
import com.epam.training.smarthome.domain.observer.MessageObserver;

public class Application {
    public static void main(String[] args) {
        Application application = new Application();
        application.run();
    }

    private void run() {

       MessageObserver messageObserver = new MessageObserver();
//
//        HomeController homeController = new HomeController.HomeControllerBuilder(messageObserver).
//                build();
//
//        EventCommandFactory eventCommandFactory = new EventCommandFactory(homeController);
//        eventCommandFactory.createEventCommand(EventCommandType.CHANGE_TO_HOLIDAY).execute();
//        eventCommandFactory.createEventCommand(EventCommandType.GOING_HOME).execute();
//        eventCommandFactory.createEventCommand(EventCommandType.MOVEMENT).execute();
//        eventCommandFactory.createEventCommand(EventCommandType.ARRIVES_HOME).execute();
//        eventCommandFactory.createEventCommand(EventCommandType.MOVEMENT).execute();
//        eventCommandFactory.createEventCommand(EventCommandType.CHANGE_TO_WORKING_DAY).execute();
//        eventCommandFactory.createEventCommand(EventCommandType.GOING_HOME).execute();
//        eventCommandFactory.createEventCommand(EventCommandType.ARRIVES_HOME).execute();
//        eventCommandFactory.createEventCommand(EventCommandType.MOVEMENT).execute();
//
//


        HomeController homeController = new HomeController.HomeControllerBuilder(messageObserver)
                .alarmSystem(new AlarmSystem(true)).build();
        EventCommand eventCommand = new EventCommandFactory(homeController).createEventCommand(EventCommandType.ARRIVES_HOME);
        eventCommand.execute();

        System.out.println("\n" + messageObserver.getMessages());

    }
}
