package com.company;

import java.io.IOException;

/**
 * Created by suzukikohei on 2016/01/21.
 */
public class Command {
    public void CheckCommand() throws IOException, InterruptedException {
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

    public void comStopwatch() throws IOException, InterruptedException {
        Watch wt = new Watch(0);
        int ch = 1;

        while(ch > 0) {
            wt.start();
            System.in.read();
            wt.stop();
            char swcom = (char)System.in.read();

            if(swcom != 10)System.in.skip(256);

            if (swcom == 'q') ch = -1;
            else if (swcom == 'r') {
                wt.shutdown();
                wt = new Watch(0);
            }
        }

        wt.shutdown();

    }

    public void comTimer() throws IOException, InterruptedException {
        Watch wt = new Watch(1);
        wt.start();
        Thread.sleep(10 * 1000);
        wt.stop();
        wt.shutdown();
    }

    public void comPomodoro() throws InterruptedException {
        Watch wt = new Watch(2);
        wt.start();
        Thread.sleep(10 * 1000);
        wt.stop();
        wt.shutdown();
    }


}
