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

import java.util.Iterator;

public class Welcome_Admin extends AppCompatActivity {
    String[] firstNamesProvider = new String[MainActivity.serviceProviderProfileList.size()];
//    String[] firstNamesProvider= {"S","SD"};
    String[] firstNamesOwner = new String[MainActivity.homeOwnerPofileList.size()];
//    String[] firstNamesOwner = {"@","SD"};
    int i = 0;
    int j = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome__admin);
        TextView textview = (TextView) (findViewById(R.id.adminWelcomeMsg));
        textview.setText("Welcome " + MainActivity.firstName + ",\nyou are entered as administrator");
// part1
        for (Iterator iterator = MainActivity.serviceProviderProfileList.iterator(); iterator.hasNext(); ) {
            ServiceProviderProfile temp = (ServiceProviderProfile) iterator.next();
            firstNamesProvider[i] = temp.getUserName();
            i++;

        }

        ListAdapter listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, firstNamesProvider);
        ListView listView = (ListView) findViewById(R.id.adminListView1);
        listView.setAdapter(listAdapter);

        //toast what user just clicked on
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {//position is the item be clicked's position
                        String name = String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(Welcome_Admin.this, name, Toast.LENGTH_LONG).show();
                    }
                }
        );
        //part2
        for (Iterator iterator = MainActivity.homeOwnerPofileList.iterator(); iterator.hasNext(); ) {
            HomeOwnerPofile temp2 = (HomeOwnerPofile) iterator.next();
            firstNamesOwner[j] = temp2.getUserName();
            j++;

        }
        ListAdapter listAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, firstNamesOwner);
        ListView listView2 = (ListView) findViewById(R.id.adminListView2);
        listView2.setAdapter(listAdapter2);

        //toast what user just clicked on
        listView2.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {//position is the item be clicked's position
                        String name = String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(Welcome_Admin.this, name, Toast.LENGTH_LONG).show();
                    }
                }
        );
    }



    public void adminSignout(View view){
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
    public void modifyServices(View view){
        Intent intent = new Intent(getApplicationContext(),ModifyService.class);
        startActivity(intent);
    }

}
