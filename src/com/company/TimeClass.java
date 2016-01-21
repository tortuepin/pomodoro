package com.company;

import javafx.scene.paint.Stop;

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

    Timer timer;
    StringUtil su;
    int checkcom;
    /*
        timer       0
        stopwatch   1
        pomodoro    2
     */

    public RunTimer(int x){
        timer = new Timer(true);
        checkcom = x;
        su = new StringUtil();
    }


    public void time() throws IOException {

        int pretime = 0;
        int x = 1;
        String checktimecom;

        System.out.println("Key Press End Timer");

        switch (checkcom){
            case 0:
                //timer
                break;


            case 1:
                //stopwatch
                while(x > 0) {
                    TimeClass timeClass = RestartTimer(pretime);
                    pretime = StopTimer(timeClass);
                    System.out.println("「q」で終了。他で再開。");
                    checktimecom = su.InputLine();

                    //qが入力されたら終了。
                    if(checktimecom.equals("q")) x = -1;
                }
                break;


            case 2:
                //pomodoro
                break;

        }


        while(x > 0) {
            TimeClass timeClass = RestartTimer(pretime);
            pretime = StopTimer(timeClass);
            System.in.read();
        }
        System.out.print("end");



    }

    //タイマーをキャンセルして、現在の時間を保存
    public int StopTimer(TimeClass timeclass){
        int second = timeclass.getSecond();
        timeclass.cancel();
        return second;
    }

    //指定した時間からタイマーをスタート
    public TimeClass RestartTimer(int second) throws IOException {
        TimeClass timeClass = new TimeClass();

        timeClass.setSecond(second);
        timer.scheduleAtFixedRate(timeClass, 0, 1000);

        System.in.read();
        return timeClass;
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

    //ストップウォッチ用getTime
    public String reverseTime(int sec, int marksec){
        int ret = marksec - sec;
        if(ret < 0){
            ret = 0;
        }
        return getTime(ret);
    }
}