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

public class AdminUserList extends AppCompatActivity {
    String[] username;
    String[] email;

    ListView listView7;
    BufferedInputStream is7;
    String line7=null;
    String result7=null;

    //String  urladdress7 = "http://192.168.20.122//myhospital/v1/user.php";
    //String  urladdress7 = "http://10.30.97.243/myhospital/v1/user.php";
    //academic
    // String  urladdress7 = "http://192.168.40.99/myhospital/v1/user.php";

    //home
   String  urladdress7 = "http://192.168.18.40/myhospital/v1/user.php";

    //academic
   // String  urladdress7 = "http://100.66.22.223/myhospital/v1/user.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_user_list);

        listView7=(ListView)findViewById(R.id.lview7);

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitNetwork().build());
        collectionData7();



        AdminUserListView adminUserListView=new AdminUserListView(this,username,email);
        listView7.setAdapter(adminUserListView);



    }
    private  void  collectionData7(){
        //connection
        try {
            URL url7=new URL(urladdress7);
            HttpURLConnection con7=(HttpURLConnection)url7.openConnection();
            con7.setRequestMethod("GET");
            is7=new BufferedInputStream(con7.getInputStream());
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        //content
        try{
            BufferedReader br7=new BufferedReader(new InputStreamReader(is7));
            StringBuilder sb7=new StringBuilder();
            while ((line7=br7.readLine())!=null){
                sb7.append(line7+"\n");
            }
            is7.close();
            result7=sb7.toString();

        }
        catch (Exception ex)
        {
            ex.printStackTrace();

        }

        //JSON
        try{
            JSONArray ja=new JSONArray(result7);
            JSONObject jo=null;
            username=new String[ja.length()];
            email=new String[ja.length()];


            for(int i=0;i<=ja.length();i++){
                jo=ja.getJSONObject(i);
                username[i]=jo.getString("username");
                email[i]=jo.getString("email");

            }
        }
        catch (Exception ex)
        {

            ex.printStackTrace();
        }


    }
}