package com.example.myhospital;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class adminlogin extends AppCompatActivity implements View.OnClickListener{

    TextView textViewSignUP;
    EditText editTextUsername, editTextPassword;
    Button buttonLogin;

    private String user_name = "admin";
    private String user_pass = "admin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);

        editTextUsername = (EditText) findViewById(R.id.username);
        editTextPassword = (EditText) findViewById(R.id.password);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        textViewSignUP=(TextView) findViewById(R.id.signUpText);


        textViewSignUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(adminlogin.this, Login.class);
                startActivity(intent);
                finish();
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Login();


            }

            private void Login() {

                final String username = editTextUsername.getText().toString().trim();
                final String password = editTextPassword.getText().toString().trim();
                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(adminlogin.this, "Please fill all the required field", Toast.LENGTH_LONG).show();
                } else
                {
                if (username.equals("admin") && password.equals("admin")) {
                    //Toast.makeText(this,"username and password matched!",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(adminlogin.this, AdminHome.class);
                    startActivity(intent);
                    finish();

                } else {
                    Toast errorToast = Toast.makeText(adminlogin.this, "username and password do not matched!", Toast.LENGTH_SHORT);
                    errorToast.show();

                }
            }
            }
        });









        /*private void login()
             {
                 final String username = editTextUsername.getText().toString().trim();
                 final String password = editTextPassword.getText().toString().trim();
            if(username.equals("admin")&& password.equals("admin"))
            {
                Toast.makeText(this,"username and password matched!",Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(this,"username and password do not matched!",Toast.LENGTH_LONG).show();
            }


        }

         */






    }

    @Override
    public void onClick(View v) {

    }
}