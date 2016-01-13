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
    TimeUnit tu = new TimeUnit();

    public TimeClass(){
        super();
        second = 0;

    }
    //Timer.schedule()が呼び出された時にすること。
    public void run(){
        //秒数を表示する
        second++;
        if(second != 1) System.out.print("\r");
        System.out.print(tu.getTime(second));
    }

    public int getSecond(){
        return second;
    }

    public void setSecond(int sec){
        second = sec;
    }

}







class RunTimer{
    //タイマー本体
    public void time(){
        Timer timer = new Timer();
        TimeClass timeClass = new TimeClass();

        System.out.println("Key Press End Timer");

        //1000ミリ秒おきにtimeClassを呼び出す
        timer.scheduleAtFixedRate(timeClass, 0, 1000);

        try {
            System.in.read();
            //timer.cancel();
            int a = StopTimer(timeClass,timer);
            System.out.print(a);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //タイマーをキャンセルして、現在の時間を保存
    public int StopTimer(TimeClass timeclass, Timer timer){
        int second = timeclass.getSecond();
        timer.cancel();
        return second;
    }

    //指定した時間からタイマーをリスタート
    public void RestartTimer(TimeClass timeclass, Timer timer, int second){
        timeclass.setSecond(second);
        timer.scheduleAtFixedRate(timeclass, 0, 1000);
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

    public String getTime(int sec){
        return getHourfromSeconds(sec) + "時間" + getMinutesfromSeconds(sec) + "分" + getSecondsfromSeconds(sec) + "秒";
    }

}