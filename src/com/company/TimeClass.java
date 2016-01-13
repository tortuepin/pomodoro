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
        //秒数を表示する
        second++;
        if(second != 1) System.out.print("\r");
        System.out.print(second);
    }

    public int getSecond(){
        return second;
    }

}

class RunTimer{
    //タイマー本体
    public void time(){
        Timer timer = new Timer();
        TimeClass timeClass = new TimeClass();

        System.out.println("Key Press End Timer");

        //1000秒おきにtimeClassを呼び出す
        timer.scheduleAtFixedRate(timeClass,0,1000);

        try {
            System.in.read();
            timer.cancel();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class TimeUnit{

    public int getSecondsfromSeconds(int sec){
        return sec%60;
    }

    public int getMinutesfromSeconds(int sec){
        return (sec/60)%60;
    }

    public int getHourfromSeconds(int sec){
        return (sec/60)/60;
    }



}