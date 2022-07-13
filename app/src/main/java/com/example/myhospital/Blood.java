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


public class Blood extends AppCompatActivity {
    String[] blood;
    ListView listView1;
    BufferedInputStream is1;
    String line1=null;
    String result1=null;
    Button callButton;

    //String  urladdress1 = "http://192.168.20.122/myhospital/v1/bloodbank.php";
    //String  urladdress1 = "http://10.30.97.243/myhospital/v1/bloodbank.php";

    //home
     String  urladdress1 = "http://192.168.18.40/myhospital/v1/bloodbank.php";
    //academic
    //String  urladdress1 = "http://100.66.22.223/myhospital/v1/bloodbank.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood);

        listView1=(ListView)findViewById(R.id.lview1);


        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitNetwork().build());
        collectionData();
        BloodListView bloodListView=new BloodListView(this,blood);
        listView1.setAdapter(bloodListView);


        //for calling
        callButton= (Button) findViewById(R.id.callButton);
        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(Intent.ACTION_DIAL);
                intentLoadNewActivity.setData(Uri.parse("tel:9842184360"));
                startActivity(intentLoadNewActivity);
            }
        });


    }
    private  void  collectionData(){
        //connection
        try {
            URL url1=new URL(urladdress1);
            HttpURLConnection con1=(HttpURLConnection)url1.openConnection();
            con1.setRequestMethod("GET");
            is1=new BufferedInputStream(con1.getInputStream());
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        //content
        try{
            BufferedReader br1=new BufferedReader(new InputStreamReader(is1));
            StringBuilder sb1=new StringBuilder();
            while ((line1=br1.readLine())!=null){
                sb1.append(line1+"\n");
            }
            is1.close();
            result1=sb1.toString();

        }
        catch (Exception ex)
        {
            ex.printStackTrace();

        }

        //JSON
        try{
            JSONArray ja1=new JSONArray(result1);
            JSONObject jo1=null;
            blood=new String[ja1.length()];

            for(int i=0;i<=ja1.length();i++){
                jo1=ja1.getJSONObject(i);
                blood[i]=jo1.getString("blood");
            }
        }
        catch (Exception ex)
        {

            ex.printStackTrace();
        }

    }

}

