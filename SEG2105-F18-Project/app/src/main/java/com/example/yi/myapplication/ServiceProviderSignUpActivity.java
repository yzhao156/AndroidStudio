package com.example.yi.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Iterator;

public class ServiceProviderSignUpActivity extends AppCompatActivity {

    private String name;
    private String lastName;
    private String userName;
    private String phoneNumber;
    private String password;
    private String address;

    private int[][] mavail = new int[9][5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_provider_sign_up);

        for(int i = 0; i < mavail.length; i++){
            for(int j = 0; j < mavail[i].length; j++){
                mavail[i][j] = 0;
            }
        }
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




    public boolean addToDatabase(){
        if (MainActivity.isExist){
            if(userName.equals(MainActivity.adminProfile.getUsername())){
                Toast.makeText(ServiceProviderSignUpActivity.this,
                        "Adding to database failed, username cannot be the same as the admin's username",
                        Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        if (userName.equals("admin")){
            Toast.makeText(ServiceProviderSignUpActivity.this,
                    "Adding to database failed, user name cannot be \"admin\"",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        for (Iterator iterator = MainActivity.homeOwnerPofileList.iterator(); iterator.hasNext(); ) {
            HomeOwnerPofile temp2 = (HomeOwnerPofile) iterator.next();
            if(temp2.getUserName().equals(userName)){
                Toast.makeText(ServiceProviderSignUpActivity.this,
                        "Adding to database failed, this user name already exists",
                        Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        for (Iterator iterator = MainActivity.serviceProviderProfileList.iterator(); iterator.hasNext(); ) {
            ServiceProviderProfile temp2 = (ServiceProviderProfile) iterator.next();
            if(temp2.getUserName().equals(userName)){
                Toast.makeText(ServiceProviderSignUpActivity.this,
                        "Adding to database failed, this user name already exists",
                        Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        if(userName.equals("")||password.equals("")||name.equals("")||lastName.equals("")
                ||phoneNumber.equals("")||address.equals(""))
        {
            Toast.makeText(ServiceProviderSignUpActivity.this,
                    "Adding to database failed, all fields are mandatory",
                    Toast.LENGTH_SHORT).show();
            return false;
        }else if(isInteger(name.replace(" ", ""))) {
            Toast.makeText(ServiceProviderSignUpActivity.this,
                    "Invalid input, the name cannot be composed of pure numbers", Toast.LENGTH_SHORT).show();
            return false;
        }else if(isInteger(lastName.replace(" ", ""))) {
            Toast.makeText(ServiceProviderSignUpActivity.this,
                    "Invalid input, the last name cannot be composed of pure numbers", Toast.LENGTH_SHORT).show();
            return false;
        }else if(isInteger(address.replace(" ", ""))) {
            Toast.makeText(ServiceProviderSignUpActivity.this,
                    "Invalid input, the address cannot be composed of pure numbers", Toast.LENGTH_SHORT).show();
            return false;

        }else if(isInteger(password.replace(" ", ""))) {
            Toast.makeText(ServiceProviderSignUpActivity.this,
                    "Invalid input, the password cannot be composed of pure numbers", Toast.LENGTH_SHORT).show();
            return false;
        }else if(   (password.replace(" ", "")).length() < 4     ) {
            Toast.makeText(ServiceProviderSignUpActivity.this,
                    "Invalid input, the password must be composed of at least 4 characters", Toast.LENGTH_SHORT).show();
            return false;
        }else {
            String str = password;
            if(   str.contains("*")
                    ||str.contains(",")
                    ||str.contains(" ")
                    ||str.contains("$")
                    ||str.contains("#")
                    ||str.contains("%")
                    ||str.contains("~")
                    ||str.contains("&")
                    ||str.contains("|")
                    ||str.contains(":")
                    ||str.contains("^")
                    ||str.contains("`")) {
                Toast.makeText(ServiceProviderSignUpActivity.this,
                        "Invalid input, some special characters in the password you input is not allowed",
                        Toast.LENGTH_SHORT).show();
                return false;
            }

            str = userName;
            if(   str.contains("*")
                    ||str.contains(",")
                    ||str.contains(" ")
                    ||str.contains("$")
                    ||str.contains("#")
                    ||str.contains("%")
                    ||str.contains("~")
                    ||str.contains("&")
                    ||str.contains("|")
                    ||str.contains(":")
                    ||str.contains("^")
                    ||str.contains("`")) {
                Toast.makeText(ServiceProviderSignUpActivity.this,
                        "Invalid input, some special characters in the username you input is not allowed",
                        Toast.LENGTH_SHORT).show();
                return false;
            }


        else{

                    for (int i = name.length();--i>=0;){
                        char c = name.charAt(i);

                        if (!( (Character.isLetter(c))  )){
                            Toast.makeText(ServiceProviderSignUpActivity.this,
                                    "Invalid input, the name can only be composed of letters", Toast.LENGTH_SHORT).show();
                            return false;
                        }
                    }

                    for (int i = lastName.length();--i>=0;){
                        char c = lastName.charAt(i);

                        if (!( (Character.isLetter(c))  )){
                            Toast.makeText(ServiceProviderSignUpActivity.this,
                                    "Invalid input, the last name can only be composed of letters", Toast.LENGTH_SHORT).show();
                            return false;
                        }
                    }

                    for (int i = phoneNumber.length();--i>=0;){
                        char c = phoneNumber.charAt(i);

                        if (!( (Character.isDigit(c))  )){
                            Toast.makeText(ServiceProviderSignUpActivity.this,
                                    "Invalid input, the phone number can only be composed of numbers in this app", Toast.LENGTH_SHORT).show();
                            return false;
                        }
                    }

                str = address.replace(" ", "");

                Boolean isAllSpecialCharacters = true;
                for (int i = str.length(); --i >= 0; ) {
                    char c = str.charAt(i);
                    if ((Character.isLetter(c))) {
                        isAllSpecialCharacters = false;
                    }
                }
                if (isAllSpecialCharacters) {
                    Toast.makeText(ServiceProviderSignUpActivity.this,
                            "Invalid input for the address", Toast.LENGTH_SHORT).show();
                    return false;
                }


                    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
                    DatabaseReference serviceProviderProfileRef = rootRef.child("serviceProviderProfile");
//            String id = serviceProviderProfileRef.push().getKey();
                    ServiceProviderProfile serviceProviderProfile = new ServiceProviderProfile(name,lastName,phoneNumber,
                            userName,password,address,mavail);
//            ServiceProviderProfile serviceProviderProfile = new ServiceProviderProfile(id, name,lastName,phoneNumber,
//                    userName,password);

                    serviceProviderProfile.encryptPassword();
                    MainActivity.spp = serviceProviderProfile;
                    serviceProviderProfileRef.child(userName).setValue(serviceProviderProfile);
//            int[][] m = { { 1, 23 }, { 2, 3, 4, 5 } };
//            int nnn = 999666;
//            int[] kk = { 2, 3, 4, 5 };
//
//            serviceProviderProfileRef.child("456").setValue(kk);
                    return true;
                }
            }
        }

    public void providerSignup(View view){
        EditText et1 = (EditText)findViewById(R.id.editText_sp_name);
        name = et1.getText().toString().trim();
        EditText et2 = (EditText)findViewById(R.id.editText_sp_lastname);
        lastName = et2.getText().toString().trim();
        EditText et3 = (EditText)findViewById(R.id.editText_sp_phonenumber);
        phoneNumber = et3.getText().toString().trim();
        EditText et4 = (EditText)findViewById(R.id.editText_sp_username);
        userName = et4.getText().toString().trim();
        EditText et5 = (EditText)findViewById(R.id.editText_sp_password);
        password = et5.getText().toString().trim();
        EditText et6 = (EditText)findViewById(R.id.providerAva);
        address = et6.getText().toString().trim();


        // if add info successfully, jump to Main Activity
        if(addToDatabase()){
            //tell user sign up success
            Toast.makeText(ServiceProviderSignUpActivity.this,"Next step",
                    Toast.LENGTH_SHORT).show();
            //jump to SignInActivity
            Intent intent = new Intent(getApplicationContext(),ServiceProviderSignUpActivity2.class);
            startActivity(intent);
        }
//        else{
//            //tell user sign up failed and input valid information again
//            Toast.makeText(ServiceProviderSignUpActivity.this,"Adding to database failed, please try to input valid information.",
//                    Toast.LENGTH_SHORT).show();
//        }
    }
}
