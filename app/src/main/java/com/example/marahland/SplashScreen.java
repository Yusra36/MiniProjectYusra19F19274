package com.example.marahland;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {
    //define the handler
    Handler handlerOBJ3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        handlerOBJ3 = new Handler();

        //creating a thrid in runnable method
        handlerOBJ3.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent pp=new Intent(SplashScreen.this, MainActivity.class);
                startActivity(pp);
                finish();

            }
        },3000);

    }
}