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

public class AmbulanceAct extends AppCompatActivity {


String[] name;
String[] phone;
String[] imagepath;
ListView listView;
BufferedInputStream is;
String line=null;
String result=null;

    //String  urladdress = "http://192.168.20.122/myhospital/v1/drivers.php";
    //academic
    //String  urladdress = "http://192.168.40.99/myhospital/v1/drivers.php";

   // String  urladdress = "http://10.30.97.243/myhospital/v1/driverss.php";
    //academic
  //String  urladdress = "http://100.66.22.223/myhospital/v1/drivers.php";
   // home
   String  urladdress = "http://192.168.18.40/myhospital/v1/drivers.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ambulance);

        listView=(ListView)findViewById(R.id.lview);

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitNetwork().build());
       collectionData();
       DriverListView driverListView=new DriverListView(this,name,phone,imagepath);
       listView.setAdapter(driverListView);

        }
        private  void  collectionData(){
        //connection
            try {
                URL url=new URL(urladdress);
                HttpURLConnection con=(HttpURLConnection)url.openConnection();
                con.setRequestMethod("GET");
                is=new BufferedInputStream(con.getInputStream());
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
            //content
            try{
                BufferedReader br=new BufferedReader(new InputStreamReader(is));
                StringBuilder sb=new StringBuilder();
                while ((line=br.readLine())!=null){
                    sb.append(line+"\n");
                }
                is.close();
                result=sb.toString();

            }
            catch (Exception ex)
            {
                ex.printStackTrace();

            }

            //JSON
            try{
                JSONArray ja=new JSONArray(result);
                JSONObject jo=null;
                name=new String[ja.length()];
                phone=new String[ja.length()];
                imagepath=new String[ja.length()];

                for(int i=0;i<=ja.length();i++){
                    jo=ja.getJSONObject(i);
                    name[i]=jo.getString("name");
                    phone[i]=jo.getString("phone");
                    imagepath[i]=jo.getString("photo");
                }
            }
            catch (Exception ex)
            {

                ex.printStackTrace();
            }

        }

    }
