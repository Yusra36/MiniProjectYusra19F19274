package com.example.marahland;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //define the values
    Button BookTicket, viewtiming, events, closeApplicationBtn13;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Define the ID of the buttons
        BookTicket = (Button) findViewById(R.id.BookTicket);
        viewtiming = (Button) findViewById(R.id.viewtiming);
        events = (Button) findViewById(R.id.events);
        closeApplicationBtn13 = findViewById(R.id.button13);

        //navigation button to move to Book ticket activity
        BookTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent q = new Intent(getApplicationContext(), bookingTtcket.class);
                startActivity(q);
            }
        });

        //navigation button to move to view timing activity
        viewtiming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent w = new Intent(getApplicationContext(), timing.class);
                startActivity(w);
            }
        });

        //navigation button to move to events activity
        events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent e = new Intent(getApplicationContext(), Events.class);
                startActivity(e);
            }
        });

        //navigation button to close the activity
        closeApplicationBtn13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // on below line we are finishing activity.
                MainActivity.this.finish();

                // on below line we are exiting our activity
                System.exit(0);
            }
        });
    }
}
