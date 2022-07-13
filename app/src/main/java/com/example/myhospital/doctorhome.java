package com.example.myhospital;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class doctorhome extends AppCompatActivity {
    Button buttonA, buttonB, buttonC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctorhome);

        buttonA = (Button) findViewById(R.id.buttonA);
        buttonB = (Button) findViewById(R.id.buttonB);
        buttonC = (Button) findViewById(R.id.buttonC);




        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(doctorhome.this, Appointment.class);
                startActivity(intentLoadNewActivity);
            }
        });


        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(doctorhome.this, AdminDoctor.class);
                startActivity(intentLoadNewActivity);
            }
        });


        buttonC= (Button) findViewById(R.id.buttonC);
        buttonC.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case DialogInterface.BUTTON_POSITIVE:
                                //Yes button clicked
                                Intent intent = new Intent(doctorhome.this, Login.class);
                                startActivity(intent);
                                finish();

                                break;
                            case DialogInterface.BUTTON_NEGATIVE:
                                //No button clicked
                                Intent intent1 = new Intent(doctorhome.this, doctorhome.class);
                                startActivity(intent1);
                                break;
                        }
                    }
                };
                AlertDialog.Builder builder = new AlertDialog.Builder(doctorhome.this);
                builder.setMessage("Are you sure you want to log out?").setPositiveButton("Log Out", dialogClickListener)
                        .setNegativeButton("Cancel", dialogClickListener).show();

            }
        });
    }
}
