package com.company;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by suzukikohei on 2016/01/11.
 *
 *
 *
 */


class TaskOfStopwatch extends TimerTask{

    protected int second;
    TimeUnit tu = new TimeUnit();

    public TaskOfStopwatch(){
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



class TaskOfTimer extends TaskOfStopwatch {

    int basesec;
    Timer timer;

    public TaskOfTimer(int x, Timer t){
        basesec = x;
        timer = t;
    }

    @Override
    public void run() {
        //秒数を表示する
        second++;
        int time = tu.reverseTime(second, basesec);
        if(second != 1) System.out.print("\r");
        System.out.print(tu.getTime(time));
        if(time == 0) {
            timer.cancel();
            System.out.print("canceled");
        }
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


    public void time() throws IOException, InterruptedException {



        System.out.println("Key Press End Timer");

        switch (checkcom){
            case 0:
                //stopwatch
                Stopwatch();
                break;


            case 1:
                //timer
                Timer(5);
                break;


            case 2:
                //pomodoro

                break;

        }


        /*
        while(x > 0) {
            TaskOfStopwatch taskOfStopwatch = RestartStopwatch(pretime);
            pretime = StopTimer(taskOfStopwatch);
            System.in.read();
        }
        */
        System.out.print("end");



    }

    //タイマーをキャンセルして、現在の時間を保存
    public int StopTimer(TaskOfStopwatch timeclass){
        //ストップウォッチ用
        int second = timeclass.getSecond();
        timeclass.cancel();
        return second;
    }
    public int StopTimer(TaskOfTimer timeclass){
        //タイマー用
        int second = timeclass.getSecond();
        timeclass.cancel();
        return second;
    }






    //指定した時間からタイマーをスタート
    public TaskOfStopwatch RestartStopwatch(int second) throws IOException {
        TaskOfStopwatch taskOfStopwatch = new TaskOfStopwatch();

        taskOfStopwatch.setSecond(second);
        timer.scheduleAtFixedRate(taskOfStopwatch, 0, 1000);

        System.in.read();
        return taskOfStopwatch;
    }
    public TaskOfTimer RestartTimer(int second, int basesec) throws IOException, InterruptedException {
        TaskOfTimer taskOfTimer = new TaskOfTimer(basesec, timer);

        taskOfTimer.setSecond(second);
        timer.scheduleAtFixedRate(taskOfTimer,0, 1000);
        Thread.sleep(5000);
        //System.in.read();
        return taskOfTimer;
    }


    public void Stopwatch() throws IOException {
        int pretime = 0;
        int x = 1;
        String checktimecom;

        while(x > 0) {
            TaskOfStopwatch taskOfStopwatch = RestartStopwatch(pretime);
            pretime = StopTimer(taskOfStopwatch);
            System.out.println("「q」で終了。他で再開。");
            checktimecom = su.InputLine();

            //qが入力されたら終了。
            if(checktimecom.equals("q")) x = -1;
        }
    }
    public void Timer(int sec) throws IOException, InterruptedException {
//タイマーコマンドが入力されたら
        int pretime = 0;
        int x = 1;
        String checktimecom;


        while(x > 0) {
            TaskOfTimer tot = RestartTimer(pretime, sec);
            pretime = StopTimer(tot);
            System.out.println("「q」で終了。他で再開。");
            checktimecom = su.InputLine();

            //qが入力されたら終了。
            if(checktimecom.equals("q")) x = -1;
        }
    }
    public void Pomodoro() throws IOException, InterruptedException {
        int x = 0;

        while(x > 0){
            for(int i=0;i<5;i++){

                Timer(1800);
                Timer(300);
            }
            Timer(900);
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

    public String getTime(int sec){
        return getHourfromSeconds(sec) + "時間" + getMinutesfromSeconds(sec) + "分" + getSecondsfromSeconds(sec) + "秒";
    }

    //タイマー用getTime
    public int reverseTime(int sec, int marksec){
        int ret = marksec - sec;
        if(ret < 0){
            ret = 0;
        }
        return ret;
    }
}