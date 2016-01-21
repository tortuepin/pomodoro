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
                break;
            case "timer":
                System.out.print("timer");
                break;
            case "pomodoro":
                System.out.print("pomodoro");
                break;
            default:
                System.out.print("default");
                break;
        }

    }


}
