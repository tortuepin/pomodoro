package com.company;

/**
 * Created by suzukikohei on 2016/01/22.
 */
public class Time {
    private int second = 0;

    public Time(){

    }

    public Time(int sec){
        ///タイマー用のコンストラクタ
        second = sec;
    }



    public void tick() {
        second++;
    }

    public void tack() {
        second--;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int sec){
        second = sec;
    }

    public int getSecondsfromSeconds(){
        return second%60;
    }

    public int getMinutesfromSeconds(){
        return (second/60)%60;
    }

    public int getHourfromSeconds(){
        return (second/60)/60;
    }

    public String getTime(){
        return getHourfromSeconds() + "時間" + getMinutesfromSeconds() + "分" + getSecondsfromSeconds() + "秒";
    }

    //タイマー用getTime
    public int reverseTime(int marksec){
        int ret = marksec - second;
        if(ret < 0){
            ret = 0;
        }
        return ret;
    }
}
