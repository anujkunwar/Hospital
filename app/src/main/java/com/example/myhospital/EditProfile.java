package com.example.myhospital;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EditProfile extends AppCompatActivity {
    private static final String TAG = EditProfile.class.getSimpleName();
    Button button;
    EditText textViewUsername, textViewUserEmail;
    String getUsername;
    private static String URl_READ="http://192.168.18.40/myhospital/v1/edit_detail.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        textViewUsername = (EditText) findViewById(R.id.textviewFullName);
        textViewUserEmail = (EditText) findViewById(R.id.textviewEmail);
        button = (Button) findViewById(R.id.button);




        textViewUserEmail.setText(SharedPrefManager.getInstance(this).getUserEmail());
        textViewUsername.setText(SharedPrefManager.getInstance(this).getUsername());
        getUsername=(SharedPrefManager.getInstance(this).getUsername());



    }
    /*
    private  void getUserDetail(final String Username){
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        StringRequest stringRequest= new StringRequest(Request.Method.POST, URl_READ,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
progressDialog.dismiss();
Log.i(TAG, response.toString());
                        //JSONObject jsonObject
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return super.getParams();
            }
        };



    }
      */
}