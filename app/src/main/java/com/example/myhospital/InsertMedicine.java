package com.example.myhospital;

import android.os.Bundle;
import android.util.Log;
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


public class InsertMedicine extends AppCompatActivity implements View.OnClickListener{

    EditText medicine,type,volume;
    Button insertdata;
    //home
    String url = "http://192.168.18.40/myhospital/v1/insertMedicine.php";
    //String url = "http://192.168.40.56/myhospital/v1/insertMedicine.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_medicine);


        medicine = (EditText)findViewById(R.id.editTextMedicine);
        type = (EditText)findViewById(R.id.editTextType);
        volume = (EditText)findViewById(R.id.editTextVolume);

        insertdata = (Button)findViewById(R.id.buttoninsertdata);
        insertdata.setOnClickListener(this);


    }



    @Override
    public void onClick(View v) {
        final String smedicine=medicine.getText().toString();
        final String ftype=type.getText().toString();
        final String mvolume=volume.getText().toString();

        if (smedicine.isEmpty() || ftype.length() == 0 || mvolume.equals("")) {
            Toast.makeText(this, "Please enter all field.", Toast.LENGTH_SHORT).show();
            return;
        }
        else {

            RequestQueue queue = Volley.newRequestQueue(InsertMedicine.this);
            StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    Toast.makeText(InsertMedicine.this, "Medicine " + response, Toast.LENGTH_SHORT).show();
                    Log.d("response", response);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                    Toast.makeText(InsertMedicine.this, "my error :" + error, Toast.LENGTH_LONG).show();
                    Log.i("My error", "" + error);

                }
            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {

                    Map<String, String> map = new HashMap<String, String>();
                    map.put("medicine", smedicine);
                    map.put("type", ftype);
                    map.put("volume", mvolume);

                    return map;
                }
            };
            queue.add(request);
        }







    }
}