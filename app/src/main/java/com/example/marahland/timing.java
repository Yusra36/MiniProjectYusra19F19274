package com.example.marahland;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class timing extends AppCompatActivity {

    //define the values
    Button backbtn2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timing);

        //Define the ID of the button
        backbtn2 = (Button) findViewById(R.id.backbtn2);

        //navigation button to move back to the main activity
        backbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent r33 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(r33);
            }
        });

    }
}