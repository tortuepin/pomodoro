package com.company;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by suzukikohei on 2016/01/11.
 *
 *
 *
 */


class TimeClass extends TimerTask{

    private int second;

    public TimeClass(){
        super();
        second = 0;
    }
    //Timer.schedule()が呼び出された時にすること。
    public void run(){
        second++;
        System.out.println("time" + second);
    }

}

class RunTimer{
    //タイマー本体
    public void time() {
        Timer timer = new Timer();
        TimeClass timeClass = new TimeClass();
        //1000秒おきにtimeClassを呼び出す
        timer.scheduleAtFixedRate(timeClass,0,1000);

        try {
            System.out.println("Key Press End Timer");
            System.in.read();
            timer.cancel();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}