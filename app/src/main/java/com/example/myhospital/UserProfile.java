package com.example.myhospital;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class UserProfile extends AppCompatActivity {
     Button button,button11,button12;
     TextView textViewUsername, textViewUserEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        textViewUsername = (TextView) findViewById(R.id.textviewFullName);
        textViewUserEmail = (TextView) findViewById(R.id.textviewEmail);
        button = (Button) findViewById(R.id.button);

        button11 = (Button) findViewById(R.id.button11);
       button12 = (Button) findViewById(R.id.button12);



        textViewUserEmail.setText(SharedPrefManager.getInstance(this).getUserEmail());
        textViewUsername.setText(SharedPrefManager.getInstance(this).getUsername());



// for logout

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case DialogInterface.BUTTON_POSITIVE:
                                //Yes button clicked
                                SharedPrefManager.getInstance(UserProfile.this).logout();
                                finish();
                                startActivity(new Intent(UserProfile.this, Login.class));

                                break;
                            case DialogInterface.BUTTON_NEGATIVE:
                                //No button clicked
                                Intent intent1 = new Intent(UserProfile.this, UserProfile.class);
                                startActivity(intent1);
                                break;
                        }
                    }
                };
                AlertDialog.Builder builder = new AlertDialog.Builder(UserProfile.this);
                builder.setMessage("Are you sure you want to log out?").setPositiveButton("Log Out", dialogClickListener)
                        .setNegativeButton("Cancel", dialogClickListener).show();

            }
        });




        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(UserProfile.this, EditProfile.class);
                startActivity(intentLoadNewActivity);
            }
        });
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(UserProfile.this, ChangePassword.class);
                startActivity(intentLoadNewActivity);
            }
        });




    }


}





