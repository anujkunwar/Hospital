package com.example.myhospital;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import static com.android.volley.Request.Method;

public class Doctor extends AppCompatActivity implements View.OnClickListener {


    Spinner mySpinner, spinnerTime;
    Button buttonVA,buttonAD,buttonDD;


    private static final String TAG = "Doctor";
    TextView mDisplayDate;
    //EditText editTextTextPersonName2;
    TextView PersonName;
    String url = "http://192.168.18.40/myhospital/v1/insertApp.php";
   // String url = "http://100.66.22.223/myhospital/v1/insertApp.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);

        mDisplayDate=(TextView)findViewById(R.id.datepick);
        buttonVA=(Button) findViewById(R.id.buttonVA);
        buttonDD=(Button) findViewById(R.id.buttonDD);
       // editTextTextPersonName2=(EditText) findViewById(R.id.editTextTextPersonName2);
        PersonName=(TextView) findViewById(R.id.PersonName);
        mySpinner=(Spinner) findViewById(R.id.spinner);
        spinnerTime=(Spinner) findViewById(R.id.spinnerTime);
        PersonName.setText(SharedPrefManager.getInstance(this).getUsername());


//for doctor name
            ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(Doctor.this,
                    android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.names));
            myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            mySpinner.setAdapter(myAdapter);

            //for time selection

            ArrayAdapter<String> myAdapter1 = new ArrayAdapter<String>(Doctor.this,
                    android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.times));
            myAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerTime.setAdapter(myAdapter1);

            //for view doctor details
            buttonDD.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentLoadNewActivity = new Intent(Doctor.this, AdminDoctor.class);
                    startActivity(intentLoadNewActivity);
                }
            });

//for view apppointment
            buttonVA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentLoadNewActivity = new Intent(Doctor.this, Appointment.class);
                    startActivity(intentLoadNewActivity);
                }
            });

            Calendar calendar = Calendar.getInstance();
            final int year = calendar.get(Calendar.YEAR);
            final int month = calendar.get(Calendar.MONTH);
            final int day = calendar.get(Calendar.DAY_OF_MONTH);

            mDisplayDate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DatePickerDialog datePickerDialog = new DatePickerDialog(
                            Doctor.this, new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                            String sDate = dayOfMonth + "/" + month + "/" + year;
                            mDisplayDate.setText(sDate);


                        }

                    }, year, month, day
                    );
                    //disable past date
                    datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                    //show date picker dialog
                    datePickerDialog.show();
                }
            });






        buttonAD=(Button) findViewById(R.id.buttonAD);
        buttonAD.setOnClickListener((View.OnClickListener) this);

    }

    @Override
    public void onClick(View v) {

        final String date=mDisplayDate.getText().toString();
        final String time=spinnerTime.getSelectedItem().toString();
        final String username=PersonName.getText().toString();
        final String doctorname=mySpinner.getSelectedItem().toString();


        if (date.equals("Choose Date") || time.length() == 0 || username.equals("") ||  doctorname.equals("")) {
            Toast.makeText(this, "Please enter all field.", Toast.LENGTH_SHORT).show();
            return;
        }
        else {

            RequestQueue queue = Volley.newRequestQueue(Doctor.this);
            StringRequest request = new StringRequest(Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    Toast.makeText(Doctor.this, "Appointment  " + response, Toast.LENGTH_SHORT).show();
                    Log.d("response", response);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                    Toast.makeText(Doctor.this, "my error :" + error, Toast.LENGTH_LONG).show();
                    Log.i("My error", "" + error);

                }
            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {

                    Map<String, String> map = new HashMap<String, String>();
                    map.put("date", date);
                    map.put("time", time);
                    map.put("patient", username);
                    map.put("doctor", doctorname);
                    return map;
                }
            };
            queue.add(request);
        }



    }







}












