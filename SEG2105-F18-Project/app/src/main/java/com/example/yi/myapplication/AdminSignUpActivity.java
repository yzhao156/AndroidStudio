package com.example.yi.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdminSignUpActivity extends AppCompatActivity {

    private String userName;
    private String userPsd;

    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_sign_up);
    }


    public boolean addToDatabase(){
        if(MainActivity.isExist == true){
            return false;
        }
        if(userName.equals("")||userPsd.equals("")) {
            Toast.makeText(AdminSignUpActivity.this, "Invalid input, all fields are mandatory",
                    Toast.LENGTH_SHORT).show();
            return false;



        }else if ((userPsd.replace(" ", "")).length() < 4) {
            Toast.makeText(AdminSignUpActivity.this,
                    "Invalid input, the password must be composed of at least 4 characters", Toast.LENGTH_SHORT).show();
            return false;
        }

        else{
            String str = userName;
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
                Toast.makeText(AdminSignUpActivity.this,
                        "Invalid input, some special characters in the username you input is not allowed",
                        Toast.LENGTH_SHORT).show();
                return false;
            }

            str = userPsd;
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
                Toast.makeText(AdminSignUpActivity.this,
                        "Invalid input, some special characters in the password you input is not allowed",
                        Toast.LENGTH_SHORT).show();
                return false;
            }





            AdminProfile adminProfile = new AdminProfile(userName,userPsd);
            DatabaseReference adminProfileRef = rootRef.child("adminProfile");

            adminProfile.encryptPassword();

            adminProfileRef.setValue(adminProfile);

            return true;
        }
    }


    public void adminSignup(View view){
        EditText et1 = (EditText)findViewById(R.id.admin_user);
        EditText et2 = (EditText)findViewById(R.id.admin_psd);
        userName = et1.getText().toString().trim();
        userPsd = et2.getText().toString().trim();
        // if add info successfully, jump to Main Activity
        if(addToDatabase()){
            //tell user sign up success
            Toast.makeText(AdminSignUpActivity.this,"Admin account signed up successfully.",
                    Toast.LENGTH_SHORT).show();
            //jump to SignInActivity
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);

            //In the database, set isAdminExist flag to true
            DatabaseReference isAdminExistRef = rootRef.child("isAdminExist");
            isAdminExistRef.setValue(true);
        }
//        else{
//            //tell user sign up failed and input valid information again
//            Toast.makeText(AdminSignUpActivity.this,"Adding to database failed, please try to input valid information",
//                    Toast.LENGTH_SHORT).show();
//        }
    }

}
