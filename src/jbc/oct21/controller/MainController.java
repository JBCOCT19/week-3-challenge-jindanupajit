package jbc.oct21.controller;

import jbc.oct21.controller.builder.ResumeBuilder;

/**
 *
 */
public class MainController {
    /**
     * The entry-point of Controller
     * @see jbc.oct21.Main
     * @see jbc.oct21.RoboResumeApplication
     */
    public void mainMenu() {
        /**
         * ResumeBuilder
         * @see ResumeBuilder
         */
        ResumeBuilder resumeBuilder = new ResumeBuilder();

        resumeBuilder.auto(System.out, System.in);

        System.out.println(resumeBuilder.toResume());
    }
}
