package com.company;


import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Created by suzukikohei on 2016/01/22.
 */

public class Watch {

    private Task task;
    private ScheduledExecutorService scheduler;
    private ScheduledFuture<?> future;
    private int checkedNum;

    //Watchに引数をもたせてその値によってtimerかstopwatchかpomodoroか分ける
    public Watch(int checkcom) throws IOException {
        switch (checkcom){
            case 0:
                //// stopwatch
                task = new StopwatchTask(new Time());
                break;
            case 1:
                //// timer
                StringUtil su = new StringUtil();

                System.out.println("Time Setting");
                String uncheckedNam = su.InputLine();

                checkedNum = su.CheckNumber(uncheckedNam);
                task = new TimerTask(new Time(checkedNum), checkedNum);
                break;
            case 2:
                ////pomodoro
                task = new PomodoroTask(new Time());
                break;
            default:
                break;
        }
        scheduler = Executors.newSingleThreadScheduledExecutor();
    }




    /**
     * タスクを開始(再開)する。
     * タスクを固定周期(1秒)で実行します。
     */
    public void start() {
        System.out.println("> start called.");
        future = scheduler.scheduleAtFixedRate(
                task, 0, 1000, TimeUnit.MILLISECONDS
        );
    }



    /**
     * schedulerに登録したタスクを停止する。
     */
    public void stop() {
        System.out.println("> stop called.");
        if (future != null) {
            future.cancel(true);
        }
    }



    /**
     * schedulerをシャットダウンする
     */
    public void shutdown() {
        System.out.println("> shutdown called.");
        scheduler.shutdownNow();
    }
}
