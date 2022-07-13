package com.example.myhospital;

import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class InsertDoctor extends AppCompatActivity implements View.OnClickListener{

    EditText doctorName,doctorType,doctorContact,doctorAddress,doctorEmail;
    Button insertdata;

    //home
    //String url = "http://100.66.22.223/myhospital/v1/insertDoctor.php";
    String url = "http://192.168.18.40/myhospital/v1/insertDoctor.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_doctor);


        doctorName = (EditText)findViewById(R.id.editTextName);
        doctorType = (EditText)findViewById(R.id.editTextType);
        doctorContact = (EditText)findViewById(R.id.editTextContact);
        doctorAddress = (EditText)findViewById(R.id.editTextAddress);
        doctorEmail = (EditText)findViewById(R.id.editTextEmail);

        insertdata = (Button)findViewById(R.id.buttoninsertdata);
        insertdata.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        final String name=doctorName.getText().toString();
        final String type=doctorType.getText().toString();
        final String contact=doctorContact.getText().toString();
        final String address=doctorAddress.getText().toString();
        final String email=doctorEmail.getText().toString();

        if (name.isEmpty() || type.length() == 0 || contact.equals("") || address.isEmpty() || email.isEmpty()) {
            Toast.makeText(this, "Please enter all field.", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                RequestQueue queue = Volley.newRequestQueue(InsertDoctor.this);
            StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    Toast.makeText(InsertDoctor.this, "Doctor " + response, Toast.LENGTH_SHORT).show();
                    Log.d("response", response);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                    Toast.makeText(InsertDoctor.this, "my error :" + error, Toast.LENGTH_LONG).show();
                    Log.i("My error", "" + error);

                }
            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {

                    Map<String, String> map = new HashMap<String, String>();
                    map.put("doctor_name", name);
                    map.put("doctor_type", type);
                    map.put("doctor_contact", contact);
                    map.put("d_address", address);
                    map.put("d_email", email);

                    return map;
                }
            };
            queue.add(request);
        }
        else
        {
            Toast.makeText(this, "Invalid Email", Toast.LENGTH_SHORT).show();
        }
        }



    }
}