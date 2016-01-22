package com.company;

import java.io.IOException;

/**
 * Created by suzukikohei on 2016/01/21.
 */
public class Command {
    public void CheckCommand() throws IOException {
        StringUtil su = new StringUtil();
        String CommandCheck = su.InputLine();

        switch(CommandCheck) {
            case "stopwatch":
                System.out.print("stopwatch");
                comStopwatch();
                break;
            case "timer":
                System.out.print("timer");
                comTimer();
                break;
            case "pomodoro":
                System.out.print("pomodoro");
                comPomodoro();
                break;
            default:
                System.out.print("default");
                break;
        }

    }

    public void comStopwatch() throws IOException {
        RunTimer runtimer = new RunTimer(0);
        runtimer.time();
    }

    public void comTimer() throws IOException {
        RunTimer runtimer = new RunTimer(1);
        runtimer.time();
    }

    public void comPomodoro(){

    }


}
