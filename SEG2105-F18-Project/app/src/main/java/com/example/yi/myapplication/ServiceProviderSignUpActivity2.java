package com.example.yi.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class ServiceProviderSignUpActivity2 extends AppCompatActivity {

    private TextView signup21tv, signup22tv;
    private RadioButton provider_yesbt,provider_nobt,provider_unbt;
    private Button Signup2btnc;
    private String company, description, licened;
    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference serviceProviderProfileRef = rootRef.child("serviceProviderProfile");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_provider_sign_up2);
        initView();
    }

    public void initView(){
        signup21tv = (TextView)findViewById(R.id.signup21tv);
        signup22tv = (TextView)findViewById(R.id.signup22tv);
        provider_yesbt = (RadioButton)findViewById(R.id.provider_yesbt);
        provider_nobt = (RadioButton)findViewById(R.id.provider_nobt);
        provider_unbt = (RadioButton)findViewById(R.id.provider_unbt);
        Signup2btnc = (Button)findViewById(R.id.Signup2btnc);
        provider_unbt.setChecked(true);

    }


    public boolean isInteger(String str) {
        for (int i = str.length(); --i >= 0; ) {
            char c = str.charAt(i);

            if (!(Character.isDigit(c))) {
                return false;
                }
            }

        return true;
    }





    public boolean validInfo(){
        company = signup21tv.getText().toString().trim();
        description = signup22tv.getText().toString().trim();
        if(provider_yesbt.isChecked()){
            licened = "Yes";
        }else if(provider_nobt.isChecked()){
            licened = "No";
        }else if(provider_unbt.isChecked()){
            licened = "Unknown";
        }

        if(company.length() == 0){
            Toast.makeText(ServiceProviderSignUpActivity2.this, "The name of company is mandatory", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(isInteger(company.replace(" ", ""))) {
            Toast.makeText(ServiceProviderSignUpActivity2.this, "Invalid input, the name of a company cannot be composed of pure numbers", Toast.LENGTH_SHORT).show();
            return false;
        }

        for (int i = company.length();--i>=0;){
            char c = company.charAt(i);
            char cc;
            if(i>=1) {
                cc = company.charAt(i-1);
            } else {
                cc = 'a';
            }
            if (!( (Character.isLetter(c)) || (Character.isDigit(c)) || (Character.isSpaceChar(c)) || (c == '.') )){
                Toast.makeText(ServiceProviderSignUpActivity2.this, "Invalid input, a company name cannot contain special character", Toast.LENGTH_SHORT).show();
                return false;
            } else if((c == ' ')&&(c == cc)) {
                Toast.makeText(ServiceProviderSignUpActivity2.this, "Invalid input, double spaces detected", Toast.LENGTH_SHORT).show();
                return false;
            } else if((c == '.')&&(c == cc)) {
                Toast.makeText(ServiceProviderSignUpActivity2.this, "Invalid input, double dots detected", Toast.LENGTH_SHORT).show();
                return false;
            }
        }


        if(description.length() == 0){
            return true;
        }

        String str = description.replace(" ", "");
        if(isInteger(str)) {
            Toast.makeText(ServiceProviderSignUpActivity2.this, "Invalid input, the description cannot be composed of pure numbers", Toast.LENGTH_SHORT).show();
            return false;
        }

        Boolean isAllSpecialCharacters = true;
        for (int i = str.length();--i>=0;){
            char c = str.charAt(i);
            if (    (Character.isLetter(c))     ) { isAllSpecialCharacters = false; }
        }
        if (isAllSpecialCharacters) {
            Toast.makeText(ServiceProviderSignUpActivity2.this, "Invalid input, the description must contain at least one English letter", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
//
//    public boolean validInfo(){
//        company = signup21tv.getText().toString();
//        description = signup22tv.getText().toString();
//        if(provider_yesbt.isChecked()){
//            licened = "Yes";
//        }else if(provider_nobt.isChecked()){
//            licened = "No";
//        }else if(provider_unbt.isChecked()){
//            licened = "Unknown";
//        }
//        if(company.trim().equals("")||description.trim().equals("")){
//            return false;
//        }
//        return true;
//    }

    public boolean addDB(){
        for(ServiceProviderProfile s : MainActivity.serviceProviderProfileList){
            if(s.getUserName().equals(MainActivity.spp.getUserName())){
//                Log.v("Yi","ASD");

                MainActivity.spp.setCompany(company);
                MainActivity.spp.setDescription(description);
                MainActivity.spp.setLicened(licened);
                serviceProviderProfileRef.child(MainActivity.spp.getUserName()).setValue(MainActivity.spp);
                return true;
            }
        }
//        Log.v("Yi","A222SD");

        return false;
    }

    public void providerSignup2(View view){
        if(validInfo()){
            addDB();
            Toast.makeText(ServiceProviderSignUpActivity2.this, "Up date information successfully.", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(),ServiceProviderSignUpActivity3.class);
            startActivity(intent);
        }
//        else{
//            Toast.makeText(ServiceProviderSignUpActivity2.this, "Invalid information.", Toast.LENGTH_SHORT).show();
//
//        }
    }

}
