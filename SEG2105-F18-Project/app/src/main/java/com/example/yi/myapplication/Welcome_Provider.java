package com.example.yi.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class Welcome_Provider extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome__provider);
        TextView textview = (TextView)(findViewById(R.id.providerWelcomeMsg));
        textview.setText("\nWelcome "+MainActivity.firstName+",\nyou are entered as a Service Provider");
    }


    public void providerSignout(View view){
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
    public void onAvl(View view){
        Intent intent = new Intent(getApplicationContext(),ServiceProviderCheckModifyAvailability.class);
        startActivity(intent);
    }

    public void onSer(View view){
        Intent intent = new Intent(getApplicationContext(),ServiceProviderModifyService.class);
        startActivity(intent);
    }
}
