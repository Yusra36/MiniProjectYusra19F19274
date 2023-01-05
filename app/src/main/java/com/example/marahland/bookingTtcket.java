package com.example.marahland;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class bookingTtcket extends AppCompatActivity {

    //define all variables
    EditText Email, AdultNum, ChildrenNum, VisitorID;
    RadioButton WithGames, WithoutGames;
    Button btn7, BookBtn, ClearBtn, DeleteBtn, ViewBtn, updateBtn, price;
    DatabaseHelper DB; // we need to create another class
    RadioGroup G1;
    TextView TicketPrice;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_ttcket);

        DB = new DatabaseHelper(this); //create on instance of DatabaseHelper class

        //get the ID's of all Edit text
        Email = (EditText) findViewById(R.id.Email);
        AdultNum = (EditText) findViewById(R.id.AdultNum);
        ChildrenNum = (EditText) findViewById(R.id.ChildrenNum);
        VisitorID = (EditText) findViewById(R.id.VisitorID);
        TicketPrice = (TextView) findViewById(R.id.TicketPrice);


        //get the ID's of all Buttons
        btn7 = (Button) findViewById(R.id.button7);
        BookBtn = (Button) findViewById(R.id.BookBtn);
        ClearBtn = (Button) findViewById(R.id.ClearBtn);
        DeleteBtn = (Button) findViewById(R.id.DeleteBtn);
        ViewBtn = (Button) findViewById(R.id.ViewBtn);
        updateBtn = (Button) findViewById(R.id.updateBtn);
        price = (Button) findViewById(R.id.button17);

        //get the ID's of the radio buttons
        WithGames = (RadioButton) findViewById(R.id.WithGames);
        WithoutGames = (RadioButton) findViewById(R.id.WithoutGames);
        G1 = (RadioGroup) findViewById(R.id.G1);

        //define user defined methods
        addData();
        updateData();
        deleteData();
        viewData();
        clearData();

        //navigation button to move back to the main activity
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rt3 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(rt3);
            }
        });

        //trigger action for calculation

        price.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                String ANumber1 = AdultNum.getText().toString();
                int  ANum1 = Integer.parseInt(ANumber1);

                if (WithGames.isChecked())
                {
                    double TicketPrice = ((ANum1 *0.500) + 10);
                    ((TextView) findViewById(R.id.TicketPrice)).setText("Price "+ TicketPrice);
                }
                else if (WithoutGames.isChecked())
                {
                    double TicketPrice = (ANum1 *0.500);
                    ((TextView) findViewById(R.id.TicketPrice)).setText("Price "+ TicketPrice);
                }

            }
        });


    }

    //add data function
    public void addData()
    {
        BookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean
                        insert=DB.insertData(Email.getText().toString(),AdultNum.getText().toString(),ChildrenNum.getText().toString());
                if(insert==true)
                    Toast.makeText(bookingTtcket.this, "Data  Inserted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(bookingTtcket.this,"Data not Inserted",Toast.LENGTH_LONG).show();
            }
        });
    }

    //Update data function
    public void updateData()
    {
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                boolean
                        update=DB.updateData(VisitorID.getText().toString(),Email.getText().toString(),AdultNum.getText().toString(),ChildrenNum.getText().toString());
                if(update==true)
                    Toast.makeText(bookingTtcket.this,"Data updated",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(bookingTtcket.this, "Data not updated",Toast.LENGTH_LONG).show();
            }
        });
    }

    //delete data function
    public void deleteData()
    {
        DeleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Integer del=DB.deleteData(VisitorID.getText().toString());if(del>0)
                Toast.makeText(bookingTtcket.this,"Data  deleted",Toast.LENGTH_LONG).show();
            else
                Toast.makeText(bookingTtcket.this,"Dat not  deleted",Toast.LENGTH_LONG).show();
            }
        });
    }

    //view data function
    public void viewData()
    {
        ViewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor Cursor33=DB.GetAllData();
                if(Cursor33.getCount()==0)
                {
                    showMessage("Error", "Nothing found");
                    return;
                }
                StringBuffer BR=new StringBuffer();
                while(Cursor33.moveToNext())
                {
                    BR.append("VisitorID:"+Cursor33.getString(0)+"\n");
                    BR.append("Email:"+Cursor33.getString(1)+"\n");
                    BR.append("AdultNum:"+Cursor33.getString(2)+"\n");
                    BR.append("ChildrenNum:"+Cursor33.getString(3)+"\n");
                }
                showMessage("Visitors Details",BR.toString());
            }
        });
    }

    //clear data function
    public void clearData()
    {
        ClearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VisitorID.setText("");
                Email.setText("");
                AdultNum.setText("");
                ChildrenNum.setText("");
                TicketPrice.setText("");
                G1.clearCheck();
            }
        });
    }

    //status bar
    public void showMessage(String title, String mes)
    {
        AlertDialog.Builder  AlerDBuilder = new AlertDialog.Builder(this);
        AlerDBuilder.setCancelable(true);
        AlerDBuilder.setTitle(title);
        AlerDBuilder.setMessage(mes);
        AlerDBuilder.show();
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.assignment,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem)
    {
        int id=menuItem.getItemId();
        if(id==R.id.action_settings)
        {
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }


}
