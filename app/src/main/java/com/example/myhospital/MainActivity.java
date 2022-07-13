package com.example.myhospital;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

public class MainActivity extends AppCompatActivity {

//variable initialize
    SliderView sliderView;
    int [] images = {R.drawable.bb, R.drawable.doctor, R.drawable.four, R.drawable.three,R.drawable.five};
    SliderAdp sliderAdp;
    //for navigation bar
    DrawerLayout drawer;
    NavigationView navigationView;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;
    //for image button of home
    ImageButton ambulanceButton;
    ImageButton bloodButton;
    ImageButton doctorButton;
    ImageButton pharmacyButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //for keeping log in

        if(!SharedPrefManager.getInstance(this).isLoggedIn()){
            finish();
           startActivity(new Intent(this, MainActivity.class));

        }
        sliderView=  findViewById(R.id.slider_view);

        //initialize adapter
        sliderAdp = new SliderAdp(images);
        //set adapter
        sliderView.setSliderAdapter(sliderAdp);
        //set indicator animation
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        //set transformation animation
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        //start auto cycle
        sliderView.startAutoCycle();
        //for ambulance
        ambulanceButton= (ImageButton) findViewById(R.id.ambulanceButton);
        ambulanceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(MainActivity.this, AmbulanceAct.class);
                startActivity(intentLoadNewActivity);
            }
        });
        //for blood
        bloodButton= (ImageButton) findViewById(R.id.bloodButton);
        bloodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(MainActivity.this, Blood.class);
                startActivity(intentLoadNewActivity);
            }
        });
        //for doctor
        doctorButton= (ImageButton) findViewById(R.id.doctorButton);
        doctorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(MainActivity.this, Doctor.class);
                startActivity(intentLoadNewActivity);
            }
        });

        //for pharmacy
        pharmacyButton= (ImageButton) findViewById(R.id.pharmacyButton);
        pharmacyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(MainActivity.this, Pharmacy.class);
                startActivity(intentLoadNewActivity);
            }
        });



        //navigation bar menu button
     toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.navigation);
        drawer = findViewById(R.id.drawer);
       setSupportActionBar(toolbar);
       toggle = new ActionBarDrawerToggle(this, drawer,toolbar,R.string.open,R.string.close);
        drawer.addDrawerListener(toggle);
       toggle.syncState();

       navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               //close drawer after selecting one option
               drawer.closeDrawer(GravityCompat.START);
               switch (item.getItemId()) {
                   case R.id.Ambulance:
                       //for ambulance
                       Intent intentLoadNewActivity = new Intent(MainActivity.this, AmbulanceAct.class);
                       startActivity(intentLoadNewActivity);
                        break;
                   case R.id.BloodBank:
                       //for profile
                       Intent intentLoadNewActivity2 = new Intent(MainActivity.this, Blood.class);
                       startActivity(intentLoadNewActivity2);
                       break;
                   case R.id.DoctorAppointment:
                       //for DoctorAppointment
                       Intent intentLoadNewActivity3 = new Intent(MainActivity.this, Doctor.class);
                       startActivity(intentLoadNewActivity3);
                       break;
                   case R.id.Pharmacy:
                       //for DoctorAppointment
                       Intent intentLoadNewActivity4 = new Intent(MainActivity.this, Pharmacy.class);
                       startActivity(intentLoadNewActivity4);
                       break;
                   case R.id.Profile:
                       //for profile
                       Intent intentLoadNewActivity5 = new Intent(MainActivity.this, UserProfile.class);
                       startActivity(intentLoadNewActivity5);

                       break;
                   case R.id.AboutUs:
                       //for DoctorAppointment
                       Intent intentLoadNewActivity6 = new Intent(MainActivity.this, AboutUs.class);
                       startActivity(intentLoadNewActivity6);
                       break;
                   case R.id.LogOut:


                       DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialog, int which) {
                               switch (which){
                                   case DialogInterface.BUTTON_POSITIVE:
                                       //Yes button clicked
                                       SharedPrefManager.getInstance(MainActivity.this).logout();
                                       finish();
                                       startActivity(new Intent(MainActivity.this, Login.class));
                                       break;
                                   case DialogInterface.BUTTON_NEGATIVE:
                                       //No button clicked
                                       Intent intent1 = new Intent(MainActivity.this, MainActivity.class);
                                       startActivity(intent1);
                                       break;
                               }
                           }
                       };
                       AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                       builder.setMessage("Are you sure you want to log out?").setPositiveButton("Log Out", dialogClickListener)
                              .setNegativeButton("Cancel", dialogClickListener).show();
                       break;


               }
               return true;
           }
       });
       //for text in navigation top
        View view = navigationView.getHeaderView(0);
        TextView My = view.findViewById(R.id.name1);
        TextView Hospital = view.findViewById(R.id.name2);
        My.setText("My");
        Hospital.setText("Hospital");




    }
//for not closing app in back button press
    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }


    }
}