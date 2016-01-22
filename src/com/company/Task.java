package com.company;

/**
 * Created by suzukikohei on 2016/01/22.
 */
abstract class Task implements Runnable{
    protected Time time;
    public abstract void run();
}


class TimerTask extends Task{

    TimerTask(Time aTime){
        time = aTime;
    }

    public void run(){
        System.out.print("timer");
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
        System.out.print("pomodoro");
    }
}