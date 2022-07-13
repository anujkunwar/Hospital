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

public class AdminBlood extends AppCompatActivity {

    String[] blood;
    ListView listView1;
    BufferedInputStream is1;
    String line1=null;
    String result1=null;


    //String  urladdress1 = "http://192.168.20.122/myhospital/v1/bloodbank.php";
    //String  urladdress1 = "http://10.30.97.243/myhospital/v1/bloodbank.php";
//192.168.40.56
    //academic new
   // String  urladdress1 = "http://192.168.40.230/myhospital/v1/bloodbank.php";
    //home
   // String  urladdress1 = "http://192.168.18.40/myhospital/v1/bloodbank.php";
    //academic
    String  urladdress1 = "http://192.168.18.40/myhospital/v1/bloodbank.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_blood);

        listView1=(ListView)findViewById(R.id.lview1);


        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitNetwork().build());
        collectionData();
        BloodListView bloodListView=new BloodListView(this,blood);
        listView1.setAdapter(bloodListView);


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