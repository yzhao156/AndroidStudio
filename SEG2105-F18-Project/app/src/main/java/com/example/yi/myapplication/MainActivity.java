package com.example.yi.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference isAdminExistRef = rootRef.child("isAdminExist");
    DatabaseReference homeOwnerProfileRef = rootRef.child("homeOwnerProfile");
    DatabaseReference serviceProviderProfileRef = rootRef.child("serviceProviderProfile");
    DatabaseReference adminProfileRef = rootRef.child("adminProfile");
    DatabaseReference serviceRef = rootRef.child("service");
    public static List<ServiceProviderProfile> serviceProviderProfileListFiltered = new ArrayList<>();
    public static ServiceProviderProfile spp;//log in instance
    public static HomeOwnerPofile hop;//log in instance
    public static Boolean isExist;
    public static List<HomeOwnerPofile> homeOwnerPofileList= new ArrayList<>();
    public static List<ServiceProviderProfile> serviceProviderProfileList = new ArrayList<>();
    public static List<Service> serviceList= new ArrayList<>();
    public static AdminProfile adminProfile;
    public static String firstName;
    public static String userName;

    //public static int[][] matrixAvailability = new int[9][5];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }



    @Override
    protected void onStart() {
        super.onStart ();

        //attaching value event listener
        isAdminExistRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange (DataSnapshot dataSnapshot) {
                isExist = dataSnapshot.getValue(Boolean.class);

                if (isExist == null) {
                    isAdminExistRef.setValue(false); //Set default value for "isExist" admin
                }


            }
            @Override
            public void onCancelled (DatabaseError databaseError) {

            }
        });

        homeOwnerProfileRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange (DataSnapshot dataSnapshot) {
                HomeOwnerPofile homeOwnerPofile;

                //clearing the previous homeOwnerPofileList
                homeOwnerPofileList.clear();

                //iterating through all the nodes
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //getting homeOwnerPofile
                    homeOwnerPofile = postSnapshot.getValue(HomeOwnerPofile.class);
//                    //decrypt password
//                    if(homeOwnerPofile != null){ homeOwnerPofile.decryptPassword();}
                    //adding homeOwnerPofile to the list
                    homeOwnerPofileList.add(homeOwnerPofile);
                }



            }
            @Override
            public void onCancelled (DatabaseError databaseError) {

            }
        });

        serviceProviderProfileRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange (DataSnapshot dataSnapshot) {
                ServiceProviderProfile serviceProviderPofile;

                //clearing the previous homeOwnerPofileList
                serviceProviderProfileList.clear();

                //iterating through all the nodes
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //getting serviceProviderPofile
                    serviceProviderPofile = postSnapshot.getValue(ServiceProviderProfile.class);
//                    //decrypt password
//                    if(serviceProviderPofile != null){ serviceProviderPofile.decryptPassword();}
                    //adding serviceProviderPofile to the list
                    serviceProviderProfileList.add(serviceProviderPofile);
                }
            }
            @Override
            public void onCancelled (DatabaseError databaseError) {

            }
        });


        adminProfileRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange (DataSnapshot dataSnapshot) {
                adminProfile = dataSnapshot.getValue(AdminProfile.class);
//                if(adminProfile != null) {
//                    adminProfile.decryptPassword();
//                }

            }
            @Override
            public void onCancelled (DatabaseError databaseError) {

            }
        });



        serviceRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange (DataSnapshot dataSnapshot) {
                Service service;

                //clearing the previous serviceList
                serviceList.clear();

                //iterating through all the nodes
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //getting service
                    service = postSnapshot.getValue(Service.class);
                    //adding service to the list
                    serviceList.add(service);
                }



            }
            @Override
            public void onCancelled (DatabaseError databaseError) {

            }
        });

    }


    public void btn_sign_in(View view) {
        //to delete
        Toast.makeText(MainActivity.this,"sign in",Toast.LENGTH_SHORT).show();


        //start new activity
        Intent intent = new Intent(getApplicationContext(),SignInActivity.class);
        startActivity(intent);
    }

    public void btn_sign_up(View view) {
        //to delete
        Toast.makeText(MainActivity.this,"sign up",Toast.LENGTH_SHORT).show();


        //start new activity
        if(isExist) {
            Intent intent = new Intent(getApplicationContext(), SignUpWithoutAdmin.class);
            startActivity(intent);
        }else{
            Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
            startActivity(intent);
        }
    }






}
