package com.company;

/**
 * Created by suzukikohei on 2016/01/22.
 */
abstract class Task implements Runnable{
    protected Time time;
    public abstract void run();
}


class TimerTask extends Task{
    int designatedTime;//タイマーのセットされた時間

    TimerTask(Time aTime, int dTime){
        time = aTime;
        designatedTime = dTime;
    }

    public void run(){
        time.tack();
        if(time.getSecond() != designatedTime-1) System.out.print("\r");
        System.out.print(time.getTime());
    }
}

class StopwatchTask extends Task{

    StopwatchTask(Time aTime){
        time = aTime;
    }

    public void run(){
        time.tick();
        if(time.getSecond() != 1) System.out.print("\r");
        System.out.print(time.getTime());
    }
}

class PomodoroTask extends Task{

    PomodoroTask(Time aTime){
        time = aTime;
    }

    public void run(){
        time.tack();
        System.out.print("\r");
        System.out.print(time.getTime());
    }

}