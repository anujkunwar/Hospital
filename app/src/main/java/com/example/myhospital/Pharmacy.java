package com.example.myhospital;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Pharmacy extends AppCompatActivity {
    String[] medicine;
    String[] type;
    String[] volume;
    ListView listView2;
    BufferedInputStream is2;
    String line2=null;
    String result2=null;
    Button callButton2;

    //String  urladdress2 = "http://192.168.20.122//myhospital/v1/medicines.php";
    //String  urladdress2 = "http://10.30.97.243/myhospital/v1/medicines.php";
    //home
    String  urladdress2 = "http://192.168.18.40/myhospital/v1/medicines.php";
    //academic
   //String  urladdress2 = "http://100.66.22.223/myhospital/v1/medicines.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pharmacy);

        listView2=(ListView)findViewById(R.id.lview2);

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitNetwork().build());
        collectionData2();



        MedicineListView medicineListView=new MedicineListView(this,medicine,type,volume);
        listView2.setAdapter(medicineListView);


        //for calling
        callButton2= (Button) findViewById(R.id.callButton2);
        callButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(Intent.ACTION_DIAL);
                intentLoadNewActivity.setData(Uri.parse("tel:+977 9842184360"));
                startActivity(intentLoadNewActivity);
            }
        });


    }
    private  void  collectionData2(){
        //connection
        try {
            URL url2=new URL(urladdress2);
            HttpURLConnection con2=(HttpURLConnection)url2.openConnection();
            con2.setRequestMethod("GET");
            is2=new BufferedInputStream(con2.getInputStream());
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        //content
        try{
            BufferedReader br2=new BufferedReader(new InputStreamReader(is2));
            StringBuilder sb2=new StringBuilder();
            while ((line2=br2.readLine())!=null){
                sb2.append(line2+"\n");
            }
            is2.close();
            result2=sb2.toString();

        }
        catch (Exception ex)
        {
            ex.printStackTrace();

        }

        //JSON
        try{
            JSONArray ja=new JSONArray(result2);
            JSONObject jo=null;
            medicine=new String[ja.length()];
            type=new String[ja.length()];
            volume=new String[ja.length()];

            for(int i=0;i<=ja.length();i++){
                jo=ja.getJSONObject(i);
                medicine[i]=jo.getString("medicine");
                type[i]=jo.getString("type");
                volume[i]=jo.getString("volume");
            }
        }
        catch (Exception ex)
        {

            ex.printStackTrace();
        }

    }






}



