package jbc.oct21;


import jbc.oct21.controller.MainController;

// Runnable as single-thread or multi-thread (Runnable)
public class RoboResumeApplication implements Runnable {

    @Override
    public void run() {
        // Call the controller entry point
        // See MainController.mainMenu() in package jbc.oct21.controller
        MainController mainController = new MainController();
        mainController.mainMenu();

    }
}
