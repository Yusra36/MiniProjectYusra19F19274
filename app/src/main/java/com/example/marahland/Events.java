package com.example.marahland;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Events extends AppCompatActivity {

    //define the values
    Button backbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        //Define the ID of the button
        backbtn = (Button) findViewById(R.id.backbtn);

        //navigation button to move back to the main activity
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent p33 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(p33);

            }
        });
    }
}