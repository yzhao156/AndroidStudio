package com.example.yi.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class BookNewService extends AppCompatActivity {


    private final String TAG = "Ji";
    private Button BnsTimeBtn,BnsServiceBtn,BnsRateBtn;
    private ListView bnsListView;
    private TextView bnsTv1,bnsTv2,bnsTv3,bnsTvSel;

    //-----------------------
    //info need to pass:
    public static Service serviceChoosed=null;
    public static ServiceProviderProfile providerChoosed=null;
    //=======================

    private String[] ALV;//Array List View;
//    private String[] ALV = {"S", "SD", "DD"};//
    private int temp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_new_service);
        initView();
        initValue();
    }

    public void initView(){
        BnsTimeBtn = (Button)findViewById(R.id.BnsTimeBtn);
        BnsServiceBtn = (Button)findViewById(R.id.BnsServiceBtn);
        BnsRateBtn = (Button)findViewById(R.id.BnsRateBtn);
        bnsListView = (ListView)findViewById(R.id.bnsListView);
        bnsTvSel = (TextView)findViewById(R.id.bnsTvSel);
        bnsTv1 = (TextView)findViewById(R.id.bnsTv1);
        bnsTv2 = (TextView)findViewById(R.id.bnsTv2);
        bnsTv3 = (TextView)findViewById(R.id.bnsTv3);
        bnsTv1.setVisibility(View.INVISIBLE);


        if (FilterTime.selected){
            bnsTv1.setVisibility(View.VISIBLE);
        }else{
            bnsTv1.setVisibility(View.INVISIBLE);

        }

        if (FilterService.selected){
            bnsTv2.setVisibility(View.VISIBLE);
        }else{
            bnsTv2.setVisibility(View.INVISIBLE);

        }

        if (FilterRate.selected){
            bnsTv3.setVisibility(View.VISIBLE);
        }else{
            bnsTv3.setVisibility(View.INVISIBLE);

        }

    }

    public void initValue(){
        temp = 0;
        ALV = new String[MainActivity.serviceProviderProfileListFiltered.size()];
        for (ServiceProviderProfile spp : MainActivity.serviceProviderProfileListFiltered){
            ALV[temp] = spp.getName() + " " + spp.getLastName() + "\n(Rate: "+spp.getCurrentRate() + ")";
            temp++;
        }

        ListAdapter listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ALV);
        bnsListView.setAdapter(listAdapter);

        //toast what user just clicked on
        bnsListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {//position is the item be clicked's position
                        ServiceProviderProfile serviceProviderProfile = MainActivity.serviceProviderProfileListFiltered.get(position);
                        providerChoosed = serviceProviderProfile;
                        bnsTvSel.setText("The service provider you choose is:" + "\n\nFirst Name:\n" + serviceProviderProfile.getName() + "\n\nLast Name:\n" + serviceProviderProfile.getLastName()+"\n\nRate:\n"+serviceProviderProfile.getCurrentRate());

                       /* //test serviceChoosed and providerChoosed
                        //precondition: choose a service first!
                        bnsTvSel.setText(serviceChoosed.getName()+"\n"+providerChoosed.getLastName());
                        //test success*/
                    }
                }
        );

    }




    public void BNSRes(View view){
        MainActivity.serviceProviderProfileListFiltered.clear();
        for (ServiceProviderProfile spp: MainActivity.serviceProviderProfileList){
            MainActivity.serviceProviderProfileListFiltered.add(spp);
        }

        FilterRate.selected=false;
        FilterService.selected=false;
        FilterTime.selected=false;
        initValue();
        initView();
    }


    public void TimeClk(View view){
        //Time
        if(FilterTime.selected){
            Toast.makeText(BookNewService.this, "Already selected, please reset to change the filter.", Toast.LENGTH_LONG).show();
        }else {
            Intent intent = new Intent(getApplicationContext(), FilterTime.class);
            startActivity(intent);
        }
    }

    public void ServiceClk(View view){
        //Service
        if(FilterService.selected){
            Toast.makeText(BookNewService.this, "Already selected, please reset to change the filter.", Toast.LENGTH_LONG).show();
        }else {
            Intent intent = new Intent(getApplicationContext(), FilterService.class);
            startActivity(intent);
        }
    }
    public void RateClk(View view){
        //Rate
        if(FilterRate.selected){
            Toast.makeText(BookNewService.this, "Already selected, please reset to change the filter.", Toast.LENGTH_LONG).show();

        }else {
            Intent intent = new Intent(getApplicationContext(), FilterRate.class);
            startActivity(intent);
        }
    }
    public void bnsBack(View view){
        //Back
        Intent intent = new Intent(getApplicationContext(),Welcome_Owner.class);
        startActivity(intent);
    }
    public void btnChooseSP(View view){
        //Book Time
        if(providerChoosed == null){
            Toast.makeText(BookNewService.this, "Please select a service provider.", Toast.LENGTH_LONG).show();

        }else if(!FilterService.selected){
            Toast.makeText(BookNewService.this, "Please select a service by pressing the service button on top.", Toast.LENGTH_LONG).show();
        }else{

            FilterRate.selected=false;
            FilterService.selected=false;
            FilterTime.selected=false;



            Intent intent = new Intent(getApplicationContext(),BookNewServiceTimeSlot.class);
            startActivity(intent);

        }

    }
}
