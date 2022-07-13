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

public class AdminDoctor extends AppCompatActivity {

    String[] dname;
    String[] dtype;
    String[] dphone;
    String[] demail;
    String[] daddress;
    ListView listView3;
    BufferedInputStream is3;
    String line3=null;
    String result3=null;

    //String  urladdress3 = "http://192.168.20.122//myhospital/v1/doctors.php";
    //String  urladdress3 = "http://10.30.97.243/myhospital/v1/doctors.php";
    //academic
   // String  urladdress3 = "http://192.168.40.99/myhospital/v1/doctors.php";

    //home.\n"
    // String  urladdress3 = \"http://100.65.52.17/myhospital/v1/doctors.php";

    //academic
    String  urladdress3 = "http://192.168.18.40/myhospital/v1/doctors.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_doctor);

        listView3=(ListView)findViewById(R.id.lview3);

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitNetwork().build());
        collectionData();
        AdminDoctorListView adminDoctorListView=new AdminDoctorListView(this,dname,dtype,dphone,daddress,demail);
        listView3.setAdapter(adminDoctorListView);

    }
    private  void  collectionData(){
        //connection
        try {
            URL url3=new URL(urladdress3);
            HttpURLConnection con=(HttpURLConnection)url3.openConnection();
            con.setRequestMethod("GET");
            is3=new BufferedInputStream(con.getInputStream());
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        //content
        try{
            BufferedReader br3=new BufferedReader(new InputStreamReader(is3));
            StringBuilder sb3=new StringBuilder();
            while ((line3=br3.readLine())!=null){
                sb3.append(line3+"\n");
            }
            is3.close();
            result3=sb3.toString();

        }
        catch (Exception ex)
        {
            ex.printStackTrace();

        }

        //JSON
        try{
            JSONArray ja3=new JSONArray(result3);
            JSONObject jo3=null;
            dname=new String[ja3.length()];
            dtype=new String[ja3.length()];
            dphone=new String[ja3.length()];
            daddress=new String[ja3.length()];
            demail=new String[ja3.length()];

            for(int i=0;i<=ja3.length();i++){
                jo3=ja3.getJSONObject(i);
                dname[i]=jo3.getString("doctor_name");
                dtype[i]=jo3.getString("doctor_type");
                dphone[i]=jo3.getString("doctor_contact");
                daddress[i]=jo3.getString("d_address");
                demail[i]=jo3.getString("d_email");
            }
        }
        catch (Exception ex)
        {

            ex.printStackTrace();
        }

    }
}