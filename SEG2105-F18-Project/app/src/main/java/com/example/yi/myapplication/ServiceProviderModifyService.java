package com.example.yi.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ServiceProviderModifyService extends AppCompatActivity {

    List<Service> serviceList= new ArrayList<>();
    String[] servicesArray = new String[MainActivity.serviceList.size()];
    String[] chosenArray;
    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference serviceRef = rootRef.child("service");
    DatabaseReference serviceProviderProfileRef = rootRef.child("serviceProviderProfile");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_provider_modify_service);
        resetArray();
        resetListView();
    }

    /**
     * reset array from serviceList in MainActivity
     * so that array can update.
     */
    public void resetArray(){
        //reset array
        int i =0;
        for (Iterator iterator = MainActivity.serviceList.iterator(); iterator.hasNext(); ) {
            Service temp = (Service) iterator.next();
            servicesArray[i] = temp.toString();
            i++;
        }
        if (MainActivity.spp.getSl().size()==0){
            chosenArray = new String[0];
        }else {
            chosenArray = new String[MainActivity.spp.getSl().size()];
            int j = 0;
            for (Service s : MainActivity.spp.getSl()) {
                chosenArray[j] = s.toString();
                j++;
            }
        }

    }

    /**
     * when ArrayList changes, the ListView should refresh.
     */
    public void resetListView(){


        ListAdapter listAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, servicesArray);
        ListView listView = (ListView) findViewById(R.id.sp1);
        listView.setAdapter(listAdapter);
        //what to do when user just clicked on
        listView.setOnItemClickListener(

                new AdapterView.OnItemClickListener() {

                    Service temp;
                    ArrayList<Service> sc = new ArrayList<>();
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {//position is the item be clicked's position
                        for(Service s: MainActivity.serviceList){
                            if(s.toString().equals(servicesArray[position])){
                                temp = s;

                            }
                        }
                        boolean flag = true;
                        for(Service ss:MainActivity.spp.getSl()){
                            if(ss.getName().equals(temp.getName())){
                                flag = false;
                            }
                        }
                        if (flag){
                            sc=(MainActivity.spp.getSl());
                            sc.add(temp);
                            MainActivity.spp.setSl(sc);
                            resetArray();
                            resetListView();
                        }else{
                            Toast.makeText(ServiceProviderModifyService.this, "Added " + " unsuccessfully, already added.", Toast.LENGTH_LONG).show();

                        }
                        resetArray();
                        resetListView();
                    }
                }
        );

        ListAdapter listAdapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, chosenArray);
        ListView listView2 = (ListView) findViewById(R.id.sp2);
        listView2.setAdapter(listAdapter2);
        //what to do when user just clicked on
        listView2.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    Service temp;
                    ArrayList<Service> sc = new ArrayList<>();
                    ArrayList<Service> tmpsc = new ArrayList<>();
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {//position is the item be clicked's position
                        for(Service s: MainActivity.serviceList){
                            if(s.toString().equals(servicesArray[position])){
                                temp = s;

                            }
                        }
                        sc = MainActivity.spp.getSl();
                        sc.remove(position);

                        MainActivity.spp.setSl(sc);

                        resetArray();
                        resetListView();
                    }
                }
        );


    }


    public void psu3(View view){

        serviceProviderProfileRef.child(MainActivity.spp.getUserName()).setValue(MainActivity.spp);
        Toast.makeText(ServiceProviderModifyService.this, "Saved " + " successfully.", Toast.LENGTH_LONG).show();
    }
    public void babak(View view){
        Intent intent = new Intent(getApplicationContext(),Welcome_Provider.class);
        startActivity(intent);
    }
}
