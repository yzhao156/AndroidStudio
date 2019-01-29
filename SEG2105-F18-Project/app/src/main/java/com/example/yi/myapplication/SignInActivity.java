package com.example.yi.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Iterator;

public class SignInActivity extends AppCompatActivity {



    String un;
    String pw;
    String type = "admin";
    String valid = "notSure";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

    }


    public boolean checkOwner(){
        for (Iterator iterator = MainActivity.homeOwnerPofileList.iterator(); iterator.hasNext(); ) {
            HomeOwnerPofile temp = (HomeOwnerPofile) iterator.next();
            if (temp.getUserName().equals(un)){
                if(decryptPassword(temp.getPassword()).equals(pw)){
                    type = "owner";
                    valid = "true";
                    MainActivity.firstName = temp.getName();
                    MainActivity.userName = temp.getUserName();
                    return true;
                }else{
                    valid = "false";
                    return true;
                }
            }
        }
        valid = "notSure";
        return true;
    }
    public boolean checkProvider(){
        for (Iterator iterator = MainActivity.serviceProviderProfileList.iterator(); iterator.hasNext(); ) {
            ServiceProviderProfile temp = (ServiceProviderProfile) iterator.next();
            if (temp.getUserName().equals(un)){
                if(decryptPassword(temp.getPassword()).equals(pw)){
                    type = "provider";
                    valid = "true";
                    MainActivity.firstName = temp.getName();
                    MainActivity.userName = temp.getUserName();
                    return true;
                }else{
                    valid = "false";
                    return true;
                }
            }
        }
        valid = "notSure";
        return true;
    }



    public boolean checkAdmin(){
        if (!MainActivity.isExist){
            valid = "notSure";
            return true;
        }
        if (MainActivity.adminProfile.getUsername().equals(un)){
            if(decryptPassword(MainActivity.adminProfile.getPassword()).equals(pw)){
                type = "admin";
                valid = "true";
                MainActivity.firstName = "admin";
                MainActivity.userName = MainActivity.adminProfile.getUsername();
                return true;
            }else{
                valid = "false";
                return true;
            }
        }
        valid = "notSure";
        return true;

    }



    public void btn_signin(View view){
        Intent intent;
        EditText userName = (EditText)findViewById(R.id.editText_username);
        EditText passWord = (EditText)findViewById(R.id.editText_password);
        un = userName.getText().toString();
        pw = passWord.getText().toString();


//
        checkAdmin();
        if (valid.equals("notSure")) {
            checkProvider();
        }
        if (valid.equals("notSure")) {
            checkOwner();
        }
        if (valid.equals("true")){
            switch(type)//jump to role activity
            {
                case "admin":
                    intent = new Intent(getApplicationContext(), Welcome_Admin.class);
                    startActivity(intent);
                    break;
                case "provider":
                    for(ServiceProviderProfile s : MainActivity.serviceProviderProfileList){
                        if(MainActivity.userName.equals(s.getUserName())){
                            MainActivity.spp = s;
                        }
                    }
                    intent = new Intent(getApplicationContext(), Welcome_Provider.class);
                    startActivity(intent);
                    break;
                case "owner":
                    for(HomeOwnerPofile s : MainActivity.homeOwnerPofileList){
                        if(MainActivity.userName.equals(s.getUserName())){
                            MainActivity.hop = s;
                        }
                    }
                    intent = new Intent(getApplicationContext(), Welcome_Owner.class);
                    startActivity(intent);
                    break;
                default:
            }
        }else{
            //if not valid , hint invalid id or psd
            Toast.makeText(SignInActivity.this,"Wrong User name or password",
                    Toast.LENGTH_SHORT).show();
        }

    }

    public String decryptPassword(String str) {
        StringBuffer sbu = new StringBuffer();
        String[] chars = str.split(",");
        for (int i = 0; i < chars.length; i++) {
            sbu.append((char) (Integer.parseInt(chars[i]) - 5));
        }
        return sbu.toString();
    }


}
