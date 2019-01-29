package com.example.yi.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class Welcome_Owner extends AppCompatActivity {

    private final String TAG = "Ji";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome__owner);
        TextView textview = (TextView)(findViewById(R.id.ownerWelcomeMsg));
        textview.setText("\nWelcome "+MainActivity.firstName+",\nyou are entered as a home owner");
        initView();
    }

    public void initView(){

    }


    public void ownerSignout(View view){
        //Sign out
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }

    public void BookNS(View view){
        //Book services
        //copy serviceProviderProfileList to serviceProviderProfileListFiltered
        MainActivity.serviceProviderProfileListFiltered.clear();
        for (ServiceProviderProfile spp: MainActivity.serviceProviderProfileList){
            MainActivity.serviceProviderProfileListFiltered.add(spp);
        }

        Intent intent = new Intent(getApplicationContext(),BookNewService.class);
        startActivity(intent);
    }

    public void WOCB(View view){
        //Check booked
        Intent intent = new Intent(getApplicationContext(),CheckBooked.class);
        startActivity(intent);
    }
}
