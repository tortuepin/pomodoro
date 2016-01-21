package com.company;


import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Command cm = new Command();

        System.out.println("Input command");
        System.out.println("timer stopwatch pomodoro");
        cm.CheckCommand();

        RunTimer runtimer = new RunTimer();
        runtimer.time();
    }
}
