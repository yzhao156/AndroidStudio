package com.example.yi.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FilterService extends AppCompatActivity {

    public static boolean selected;

    private final String TAG = "Ji";
    private ListView FSListView;
    private TextView FSTeVw;
    private int temp = 0;
    private Service selectedService;

    private String[] servicesArray = new String[MainActivity.serviceList.size()];
//    private String[] servicesArray = {"a","b","c"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_service);
        initValue();
        initView();

    }


    public void initValue(){
        for(Service s : MainActivity.serviceList){
            servicesArray[temp] = s.getName()+"($"+s.getRate()+"/h)";
            temp++;
        }
    }


    public void initView(){
        FSListView = (ListView)findViewById(R.id.FSListView);
        FSTeVw = (TextView)findViewById(R.id.FSTeVw);

        ListAdapter listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, servicesArray);
        FSListView.setAdapter(listAdapter);
        //what to do when user just clicked on
        FSListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {//position is the item be clicked's position
                        FSTeVw.setText("Selected: "+servicesArray[position]);
                        selectedService = MainActivity.serviceList.get(position);
                        BookNewService.serviceChoosed =  MainActivity.serviceList.get(position);
                        Toast.makeText(FilterService.this, selectedService.getName(), Toast.LENGTH_LONG).show();

                    }
                }
        );
    }

    public void FSBack(View view){
        //Back
        Intent intent = new Intent(getApplicationContext(),BookNewService.class);
        startActivity(intent);
    }

    public void FSSubmit(View view){
        //Submit
        selected = true;
        List<ServiceProviderProfile> tempSPP = new ArrayList<>();
        for(ServiceProviderProfile spp: MainActivity.serviceProviderProfileListFiltered){
            for (Service s : spp.getSl()){
                if(s.getName().equals(selectedService.getName())){
                    tempSPP.add(spp);
                    break;
                }
            }
        }
        MainActivity.serviceProviderProfileListFiltered.clear();
        for(ServiceProviderProfile spp: tempSPP){
            MainActivity.serviceProviderProfileListFiltered.add(spp);
        }


        Toast.makeText(FilterService.this, "Added filter successfully.", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(getApplicationContext(),BookNewService.class);
        startActivity(intent);

    }
}
