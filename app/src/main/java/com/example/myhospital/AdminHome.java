package com.example.myhospital;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminHome extends AppCompatActivity {
    Button button1, button2, button3, button4, button5, button6, button7, button9, button10, button8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

        button2 = (Button) findViewById(R.id.button2);
        button7 = (Button) findViewById(R.id.button7);
        button5 = (Button) findViewById(R.id.button5);
        button3 = (Button) findViewById(R.id.button3);
        button6 = (Button) findViewById(R.id.button6);
        button4 = (Button) findViewById(R.id.button4);
        button9 = (Button) findViewById(R.id.button9);
        button10 = (Button) findViewById(R.id.button10);
        button8 = (Button) findViewById(R.id.button8);



        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(AdminHome.this, AdminUserList.class);
                startActivity(intentLoadNewActivity);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(AdminHome.this, AmbulanceAct.class);
                startActivity(intentLoadNewActivity);
            }
        });



        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(AdminHome.this, AdminBlood.class);
                startActivity(intentLoadNewActivity);
            }
        });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(AdminHome.this, Appointment.class);
                startActivity(intentLoadNewActivity);
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(AdminHome.this, AdminMedicine.class);
                startActivity(intentLoadNewActivity);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(AdminHome.this, AdminDoctor.class);
                startActivity(intentLoadNewActivity);
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(AdminHome.this, InsertDoctor.class);
                startActivity(intentLoadNewActivity);
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(AdminHome.this, InsertMedicine.class);
                startActivity(intentLoadNewActivity);
            }
        });


        button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case DialogInterface.BUTTON_POSITIVE:
                                //Yes button clicked
                                Intent intent = new Intent(AdminHome.this, Login.class);
                                startActivity(intent);
                                finish();

                                break;
                            case DialogInterface.BUTTON_NEGATIVE:
                                //No button clicked
                                Intent intent1 = new Intent(AdminHome.this, AdminHome.class);
                                startActivity(intent1);
                                break;
                        }
                    }
                };
                AlertDialog.Builder builder = new AlertDialog.Builder(AdminHome.this);
                builder.setMessage("Are you sure you want to log out?").setPositiveButton("Log Out", dialogClickListener)
                        .setNegativeButton("Cancel", dialogClickListener).show();

            }
        });


    }
}