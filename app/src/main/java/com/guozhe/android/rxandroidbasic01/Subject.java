package com.guozhe.android.rxandroidbasic01;

import java.util.ArrayList;
import java.util.List;

//1초에 한번씩 등록된 옵저버들에게 "Hello" 메세지를 날린다
public class Subject extends Thread{
    List<Observer> observers = new ArrayList<>();
    boolean run = true;


    @Override
    public void run() {
        while (run) {
            try {
                Thread.sleep(1000);
                for (Observer observer : observers) {
                    observer.notification("Hello");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public interface Observer{
        public void notification(String msg);
    }
}
