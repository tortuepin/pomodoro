package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by suzukikohei on 2016/01/21.
 */
public class Command {
    StringUtil su = new StringUtil();

    public void CheckCommand() throws IOException, InterruptedException {

        int endflag = 1;

        while (endflag > 0) {
            System.out.println("Input command");
            System.out.println("stopwatch timer pomodoro or end");
            String CommandCheck = su.InputLine();


            switch (CommandCheck) {
                case "stopwatch":
                    System.out.println("Run stopwatch");
                    comStopwatch();
                    break;
                case "timer":
                    System.out.println("Run timer");
                    comTimer();
                    break;
                case "pomodoro":
                    System.out.print("Run pomodoro");
                    comPomodoro();
                    break;
                case "end":
                    System.out.println("Bye");
                    endflag = -1;
                    break;
                default:
                    //System.out.println("default");
                    break;
            }
        }

    }

    public void comStopwatch() throws IOException, InterruptedException {
        Watch wt = new Watch(0);
        int endFlag = 1;

        while(endFlag > 0) {
            wt.start();
            if(System.in.read() != 10)System.in.skip(256);
            wt.stop();

            //入力を促すyo
            char swcom = (char)System.in.read();
            //余計な文字をスキップする
            if(swcom != 10)System.in.skip(256);
            //qなら終了rなら最初からスタート
            if (swcom == 'q') endFlag = -1;
            else if (swcom == 'r') {
                wt.shutdown();
                wt = new Watch(0);
            }
        }

        wt.shutdown();

    }

    public void comTimer() throws IOException, InterruptedException {
        Watch wt = new Watch(1);
        timerFunc(wt);
    }

    public void comPomodoro() throws InterruptedException, IOException {
        Watch wt = new Watch(2);
        timerFunc(wt);
    }

    public void timerFunc(Watch wt) throws InterruptedException, IOException {
        int endFlag = 1;


        wt.start();
        while(endFlag > 0){
            //もしバッファになんかあったら
            if(su.input.ready()){
                su.input.skip(1);
                endFlag = -1;
                break;
            }
            if(wt.task.time.getSecond() <= 0){
                endFlag = -1;
                System.out.println('\n' + "owari");
                break;
            }
            Thread.sleep(100);
        }
        wt.stop();
        wt.shutdown();

        while(su.input.ready()){
            su.input.skip(1);
        }
    }


}
