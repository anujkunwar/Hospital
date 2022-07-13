package com.example.myhospital;

import android.os.Bundle;
import android.os.StrictMode;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Appointment extends AppCompatActivity {

    String[] appointments_date;
    String[] 	appointments_time;
    String[] username;
    String[] doctor_name;

    ListView listView5;
    BufferedInputStream is5;
    String line5=null;
    String result5=null;

    //String  urladdress5 = "http://192.168.20.122//myhospital/v1/appointments.php";
    //String  urladdress5 = "http://10.30.97.243/myhospital/v1/appointments.php";
    //192.168.40.230
    //academic
    //String  urladdress5 = "http://192.168.40.230/myhospital/v1/appointments.php";
    //home
    String  urladdress5 = "http://192.168.18.40/myhospital/v1/appointments.php";
    //academic
    //String  urladdress5 = "http://100.66.22.223/myhospital/v1/appointments.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);

        listView5=(ListView)findViewById(R.id.lview5);

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitNetwork().build());
        collectionData2();



        AppointmentListView appointmentListView=new AppointmentListView(this,doctor_name,appointments_date,appointments_time,username);
        listView5.setAdapter(appointmentListView);




    }
    private  void  collectionData2(){
        //connection
        try {
            URL url5=new URL(urladdress5);
            HttpURLConnection con5=(HttpURLConnection)url5.openConnection();
            con5.setRequestMethod("GET");
            is5=new BufferedInputStream(con5.getInputStream());
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        //content
        try{
            BufferedReader br5=new BufferedReader(new InputStreamReader(is5));
            StringBuilder sb5=new StringBuilder();
            while ((line5=br5.readLine())!=null){
                sb5.append(line5+"\n");
            }
            is5.close();
            result5=sb5.toString();

        }
        catch (Exception ex)
        {
            ex.printStackTrace();

        }

        //JSON
        try{
            JSONArray ja=new JSONArray(result5);
            JSONObject jo=null;
            doctor_name=new String[ja.length()];
            appointments_date=new String[ja.length()];
            appointments_time=new String[ja.length()];
            username=new String[ja.length()];

            for(int i=0;i<=ja.length();i++){
                jo=ja.getJSONObject(i);
                doctor_name[i]=jo.getString("doctor");
                appointments_date[i]=jo.getString("date");
                appointments_time[i]=jo.getString("time");
                username[i]=jo.getString("patient");
            }
        }
        catch (Exception ex)
        {

            ex.printStackTrace();
        }



    }
}