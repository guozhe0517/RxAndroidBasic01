package com.guozhe.android.rxandroidbasic01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Subject subject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //생성
        subject = new Subject();
        //동작
        subject.start();
    }
    //버튼이 클릭될때마다 Subject 옵저버를 추가
    int value = 0;
    public void add(View v){
        value++;
        subject.addObserver(new Subject.Observer() {
            String myName = "Obserer"+value;
            @Override
            public void notification(String msg) {
                System.out.println(myName+":"+msg);
            }
        });
    }
    public void goObservable(View v){
        Intent intent = new Intent(this,ObservableActivity.class);
        startActivity(intent);
    }
}
