package com.example.yi.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FilterRate extends AppCompatActivity {

    public static boolean selected;


    private final String TAG = "Ji";
    private boolean isValid;
    private RadioButton FR1,FR2,FR3,FR4,FR5;
    private EditText FRET;
    private double minimumRate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_rate);
        initView();

    }

    public void initView(){
        FR1 = (RadioButton)findViewById(R.id.FR1);
        FR2 = (RadioButton)findViewById(R.id.FR2);
        FR3 = (RadioButton)findViewById(R.id.FR3);
        FR4 = (RadioButton)findViewById(R.id.FR4);
        FR5 = (RadioButton)findViewById(R.id.FR5);
        FRET = (EditText)findViewById(R.id.FRET);
        FRET.setVisibility(View.INVISIBLE);//never needed, can use for test

    }

    public void FrBck(View view){
        //Filter Rate Back
        Intent intent = new Intent(getApplicationContext(),BookNewService.class);
        startActivity(intent);
    }

    public void AFRat(View view){
        isValid = true;
        //Filter Rate Submit

        //get value from radioButton
        if(FR1.isChecked()){
            minimumRate=1.0;
        }else if(FR2.isChecked()){
            minimumRate=2.0;
        }else if(FR3.isChecked()){
            minimumRate=3.0;
        }else if(FR4.isChecked()){
            minimumRate=4.0;
        }else if(FR5.isChecked()){
            minimumRate=5.0;
        }else{
            isValid = false;
            Toast.makeText(FilterRate.this, "Please input a minimum rate.", Toast.LENGTH_LONG).show();
        }
        if(isValid) {

//        for test
//        FRET.setText(minimumRate+"");

            selected = true;

            List<ServiceProviderProfile> tempSPP = new ArrayList<>();
            for (ServiceProviderProfile spp : MainActivity.serviceProviderProfileListFiltered) {
                if (spp.getCurrentRate() >= minimumRate) {
                    tempSPP.add(spp);
                }
            }
            MainActivity.serviceProviderProfileListFiltered.clear();
            for (ServiceProviderProfile spp : tempSPP) {
                MainActivity.serviceProviderProfileListFiltered.add(spp);
            }

            Toast.makeText(FilterRate.this, "Added filter successfully.", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(getApplicationContext(), BookNewService.class);
            startActivity(intent);
        }
    }
}
