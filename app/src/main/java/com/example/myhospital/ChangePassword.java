package com.example.myhospital;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ChangePassword extends AppCompatActivity {
    Button button;
    EditText textViewUsername, textViewUserEmail  ;
    TextView textViewUserPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);


        textViewUsername = (EditText) findViewById(R.id.textviewFullName);
        textViewUserEmail = (EditText) findViewById(R.id.textviewEmail);
        textViewUserPassword=(TextView) findViewById(R.id.textView19);
        button = (Button) findViewById(R.id.button);

      //  textViewUserPassword.setText(SharedPrefManager.getInstance(this).getKeyUserPassword());

    }
}