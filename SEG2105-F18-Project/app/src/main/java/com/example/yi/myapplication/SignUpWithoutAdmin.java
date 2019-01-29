package com.example.yi.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class SignUpWithoutAdmin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_without_admin);
    }
    //on click jump to HomeOwnerSignUpActivity
    public void HomeOwner(View view){
        //to delete
        Toast.makeText(SignUpWithoutAdmin.this,"Home owner sign up",Toast.LENGTH_SHORT).show();


        Intent intent = new Intent(getApplicationContext(),HomeOwnerSignUpActivity.class);
        startActivity(intent);
    }

    //on click jump to ServiceProviderSignUpActivity
    public void ServiceProvider(View view){
        //to delete
        Toast.makeText(SignUpWithoutAdmin.this,"Service provider sign up",Toast.LENGTH_SHORT).show();


        Intent intent = new Intent(getApplicationContext(),ServiceProviderSignUpActivity.class);
        startActivity(intent);
    }
}
