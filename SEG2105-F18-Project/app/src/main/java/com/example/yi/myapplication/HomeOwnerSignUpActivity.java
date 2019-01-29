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


public class HomeOwnerSignUpActivity extends AppCompatActivity {

    private String userName;
    private String password;
    private String name;
    private String lastName;
    private String address;
    private String phoneNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_owner_sign_up);
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


    public boolean addToDatabase() {
        if (MainActivity.isExist) {
            if (userName.equals(MainActivity.adminProfile.getUsername())) {
                Toast.makeText(HomeOwnerSignUpActivity.this,
                        "Adding to database failed, username cannot be the same as the admin's username",
                        Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        if (userName.equals("admin")) {
            Toast.makeText(HomeOwnerSignUpActivity.this,
                    "Adding to database failed, user name cannot be \"admin\"",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        for (Iterator iterator = MainActivity.homeOwnerPofileList.iterator(); iterator.hasNext(); ) {
            HomeOwnerPofile temp2 = (HomeOwnerPofile) iterator.next();
            if (temp2.getUserName().equals(userName)) {
                Toast.makeText(HomeOwnerSignUpActivity.this,
                        "Adding to database failed, this user name already exists",
                        Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        for (Iterator iterator = MainActivity.serviceProviderProfileList.iterator(); iterator.hasNext(); ) {
            ServiceProviderProfile temp2 = (ServiceProviderProfile) iterator.next();
            if (temp2.getUserName().equals(userName)) {
                Toast.makeText(HomeOwnerSignUpActivity.this,
                        "Adding to database failed, this user name already exists",
                        Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        if (userName.equals("") || password.equals("") || name.equals("") || lastName.equals("") ||
                address.equals("") || phoneNumber.equals("")) {
            Toast.makeText(HomeOwnerSignUpActivity.this,
                    "Adding to database failed, all fields are mandatory",
                    Toast.LENGTH_SHORT).show();
            return false;
        } else if (isInteger(name.replace(" ", ""))) {
            Toast.makeText(HomeOwnerSignUpActivity.this,
                    "Invalid input, the name cannot be composed of pure numbers", Toast.LENGTH_SHORT).show();
            return false;
        } else if (isInteger(lastName.replace(" ", ""))) {
            Toast.makeText(HomeOwnerSignUpActivity.this,
                    "Invalid input, the last name cannot be composed of pure numbers", Toast.LENGTH_SHORT).show();
            return false;
        } else if (isInteger(address.replace(" ", ""))) {
            Toast.makeText(HomeOwnerSignUpActivity.this,
                    "Invalid input, the address cannot be composed of pure numbers", Toast.LENGTH_SHORT).show();
            return false;

        } else if (isInteger(password.replace(" ", ""))) {
            Toast.makeText(HomeOwnerSignUpActivity.this,
                    "Invalid input, the password cannot be composed of pure numbers", Toast.LENGTH_SHORT).show();
            return false;
        } else if ((password.replace(" ", "")).length() < 4) {
            Toast.makeText(HomeOwnerSignUpActivity.this,
                    "Invalid input, the password must be composed of at least 4 characters", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            String str = password;
            if (str.contains("*")
                    || str.contains(",")
                    || str.contains(" ")
                    || str.contains("$")
                    || str.contains("#")
                    || str.contains("%")
                    || str.contains("~")
                    || str.contains("&")
                    || str.contains("|")
                    || str.contains(":")
                    || str.contains("^")
                    || str.contains("`")) {
                Toast.makeText(HomeOwnerSignUpActivity.this,
                        "Invalid input, some special characters in the password you input is not allowed",
                        Toast.LENGTH_SHORT).show();
                return false;
            }

            str = userName;
            if (str.contains("*")
                    || str.contains(",")
                    || str.contains(" ")
                    || str.contains("$")
                    || str.contains("#")
                    || str.contains("%")
                    || str.contains("~")
                    || str.contains("&")
                    || str.contains("|")
                    || str.contains(":")
                    || str.contains("^")
                    || str.contains("`")) {
                Toast.makeText(HomeOwnerSignUpActivity.this,
                        "Invalid input, some special characters in the username you input is not allowed",
                        Toast.LENGTH_SHORT).show();
                return false;
            } else {

                for (int i = name.length();--i>=0;){
                    char c = name.charAt(i);

                    if (!( (Character.isLetter(c))  )){
                        Toast.makeText(HomeOwnerSignUpActivity.this,
                                "Invalid input, the name can only be composed of letters", Toast.LENGTH_SHORT).show();
                        return false;
                    }
                }

                for (int i = lastName.length();--i>=0;){
                    char c = lastName.charAt(i);

                    if (!( (Character.isLetter(c))  )){
                        Toast.makeText(HomeOwnerSignUpActivity.this,
                                "Invalid input, the last name can only be composed of letters", Toast.LENGTH_SHORT).show();
                        return false;
                    }
                }

                for (int i = phoneNumber.length();--i>=0;){
                    char c = phoneNumber.charAt(i);

                    if (!( (Character.isDigit(c))  )){
                        Toast.makeText(HomeOwnerSignUpActivity.this,
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
                    Toast.makeText(HomeOwnerSignUpActivity.this,
                            "Invalid input for the address", Toast.LENGTH_SHORT).show();
                    return false;
                }


                DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
                HomeOwnerPofile homeOwnerProfile = new HomeOwnerPofile(userName, password, name,
                        lastName, address, phoneNumber);
                DatabaseReference homeOwnerProfileRef = rootRef.child("homeOwnerProfile");

                homeOwnerProfile.encryptPassword();

                homeOwnerProfileRef.child(userName).setValue(homeOwnerProfile);
                return true;
            }
        }
    }


    public void ownerSignup(View view){


        EditText etuserName= (EditText) findViewById(R.id.editText_hw_username);
        userName = etuserName.getText().toString().trim();

        EditText etpassword= (EditText) findViewById(R.id.editText_hw_password);
        password = etpassword.getText().toString().trim();

        EditText etname= (EditText) findViewById(R.id.editText_hw_name);
        name = etname.getText().toString().trim();

        EditText etlastName= (EditText) findViewById(R.id.editText_hw_lastname);
        lastName = etlastName.getText().toString().trim();

        EditText etaddress= (EditText) findViewById(R.id.editText_hw_address);
        address = etaddress.getText().toString().trim();

        EditText etphoneNumber= (EditText) findViewById(R.id.editText_hw_phone);
        phoneNumber = etphoneNumber.getText().toString().trim();


        // if add info successfully, jump to Main Activity
        if(addToDatabase()){
            //tell user sign up success
            Toast.makeText(HomeOwnerSignUpActivity.this,"Home owner signed up successfully.",
                    Toast.LENGTH_SHORT).show();
            //jump to SignInActivity
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        }
//        else{
//            //tell user sign up failed and input valid information again
//            Toast.makeText(HomeOwnerSignUpActivity.this,"Adding to database failed, please try to input valid information",
//                    Toast.LENGTH_SHORT).show();
//        }
    }


}
