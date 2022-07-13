package com.example.myhospital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Doctorlogin extends AppCompatActivity implements View.OnClickListener {
    TextView textViewSignUP;
    EditText editTextUsername, editTextPassword;
    Button buttonLogin;

    private String user_name = "Doctor";
    private String user_pass = "12345678";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctorlogin);

        editTextUsername = (EditText) findViewById(R.id.username);
        editTextPassword = (EditText) findViewById(R.id.password);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        textViewSignUP=(TextView) findViewById(R.id.signUpText);
        textViewSignUP.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Doctorlogin.this, Login.class);
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
                    Toast.makeText(Doctorlogin.this, "Please fill all the required field", Toast.LENGTH_LONG).show();
                } else
                {
                    if (username.equals("Doctor") && password.equals("12345678")) {
                        //Toast.makeText(this,"username and password matched!",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(Doctorlogin.this, doctorhome.class);
                        startActivity(intent);
                        finish();

                    } else {
                        Toast errorToast = Toast.makeText(Doctorlogin.this, "username and password do not matched!", Toast.LENGTH_SHORT);
                        errorToast.show();

                    }
                }
            }
        });

    }

    @Override
    public void onClick(View v) {

    }
}
