package com.example.yi.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Iterator;

public class ModifyService extends AppCompatActivity {

    String[] servicesArray = new String[MainActivity.serviceList.size()];
    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference serviceRef = rootRef.child("service");

    private String name;
    private String rate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_service);
        resetArray();
        resetListView();

    }

    /**
     * check if param name already in services
     * @param name string
     * @return if exist
     */
    public boolean ifExist(String name){
        for(Service s : MainActivity.serviceList){
            if(s.getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    /**
     * compare if the service has changes with before
     * @param service
     * @return if has changes,return true, else return false.
     */
    public boolean hasChanges(Service service){
        for(Service s : MainActivity.serviceList){
            if(s.getName().equals(name)&&String.valueOf(s.getRate()).equals(rate)){
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @return
     */
    public boolean validInfo(){
        if(name.trim().equals("")||rate.trim().equals("")){
            return false;
        }
        return true;
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
    }

    /**
     * when ArrayList changes, the ListView should refresh.
     */
    public void resetListView(){
        ListAdapter listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, servicesArray);
        ListView listView = (ListView) findViewById(R.id.servicesListView);
        listView.setAdapter(listAdapter);
        //what to do when user just clicked on
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {//position is the item be clicked's position
                        String service = String.valueOf(parent.getItemAtPosition(position));
                        EditText name = (EditText)findViewById(R.id.editTextSName);
                        EditText rate = (EditText)findViewById(R.id.editTextSRate);
                        name.setText(MainActivity.serviceList.get(position).getName());
                        rate.setText(String.valueOf(MainActivity.serviceList.get(position).getRate()));
                    }
                }
        );
    }

    /**
     * refresh the new information into class varible
     *
     */
    public void getInfo(){
        EditText etuserName= (EditText) findViewById(R.id.editTextSName);
        name = etuserName.getText().toString().trim();
        EditText etuserRate= (EditText) findViewById(R.id.editTextSRate);
        rate = etuserRate.getText().toString().trim();
    }

    /**
     * add service to DB
     * @param service
     */
    public void addToDB(Service service){
        serviceRef.child(service.getName()).setValue(service);
    }

    /**
     * remove service from DB
     * if not in DB, do nothing
     * @param name
     */
    public void removeFromDB(String name){
        serviceRef.child(name).removeValue();
        Intent intent = new Intent(getApplicationContext(), ModifyService.class);
        startActivity(intent);
    }

    /**
     * update ListView,ArrayList,Array,FireBase
     */
    public void addToDB(){
        addToDB(new Service(name,Double.parseDouble(rate)));
        Intent intent = new Intent(getApplicationContext(), ModifyService.class);
        startActivity(intent);
    }

    public void ServiceAdd(View view){
        getInfo();
        if (validInfo()){
            if (ifExist(name)) {
                if (hasChanges(new Service(name,Double.parseDouble(rate)))){
                    addToDB();
                    Toast.makeText(ModifyService.this, "Edited " + name + " successfully.", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(ModifyService.this, "Will not add to database because there is no changes.", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(ModifyService.this, "Added " + name + " successfully.", Toast.LENGTH_LONG).show();
                addToDB();
            }
        }else{
            Toast.makeText(ModifyService.this, "Added " + name + " unsuccessfully.\nPlease input valid data.", Toast.LENGTH_LONG).show();
        }


    }


    public void ServiceRemove(View view){
        getInfo();
        if(ifExist(name)){
            removeFromDB(name);
            Toast.makeText(ModifyService.this, "Removed "+name+" successfully.", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(ModifyService.this, "Removed "+name+" unsuccessfully.\n"+name+" does not exist.", Toast.LENGTH_LONG).show();
        }
    }

    //sign out
    public void ALO(View view){
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }


}
