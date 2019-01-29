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
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class CheckBooked extends AppCompatActivity {

    private final String TAG = "Ji";
    private int temp;
    private boolean valid;
    private double givenRate;
    private int choosenIndex;
    private ServiceProviderProfile choosenSP = null;

    private ListView CBListView;
    private EditText CBET;
    private TextView CBTextView;
    private RadioButton CB1,CB2,CB3,CB4,CB5;

    private String[] prossingService = new String[MainActivity.hop.getHaveServiceArrayList().size()];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_booked);
        initValue();
        initView();

    }

    public void initValue(){

        temp = 0;
        for(ServiceProviderProfile s : MainActivity.hop.getHaveServiceProviderArrayList()){
            prossingService[temp] = "Service #" + (temp+1) +":\nService Provider: "+  s.getName() + " " + s.getLastName() +"\nPhone Number: "+s.getPhoneNumber() + "\nAddress: " + s.getAddress();
            temp++;
        }

        temp = 0;
        for(Service s : MainActivity.hop.getHaveServiceArrayList()){
            prossingService[temp] += "\nService you booked: "+s.getName()+"\nHourly rate: "+"$"+s.getRate()+"/h\n";
            temp++;
        }

    }

    public void initView(){
        CBListView = (ListView)findViewById(R.id.CBListView);
        CBTextView = (TextView)findViewById(R.id.CBTextView);
        CBET = (EditText)findViewById(R.id.CBET);
        CB1 = (RadioButton)findViewById(R.id.CB1);
        CB2 = (RadioButton)findViewById(R.id.CB2);
        CB3 = (RadioButton)findViewById(R.id.CB3);
        CB4 = (RadioButton)findViewById(R.id.CB4);
        CB5 = (RadioButton)findViewById(R.id.CB5);

        ListAdapter listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, prossingService);
        CBListView.setAdapter(listAdapter);
        //what to do when user just clicked on
        CBListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {//position is the item be clicked's position
                        for(ServiceProviderProfile spp: MainActivity.serviceProviderProfileList){
                            if(spp.getUserName().equals(MainActivity.hop.getHaveServiceProviderArrayList().get(position).getUserName())){
                                choosenSP = spp;
                            }
                        }
                        choosenIndex=position;
                        CBTextView.setText("You choosed service #" + (position+1) + "\n\nPlease select a rate and write some comment before finishing the service.");
//                        Toast.makeText(CheckBooked.this, ""+choosenSP.getLastName(), Toast.LENGTH_LONG).show();

                    }
                }
        );
    }

    public void CBBack(View view){
        //Back to WelcomOwner
        Intent intent = new Intent(getApplicationContext(),Welcome_Owner.class);
        startActivity(intent);
    }

    public void CBSubmit(View view){
        //Submit
        valid = true;
        if(choosenSP==null){
            Toast.makeText(CheckBooked.this, "Please choose a service from the list.", Toast.LENGTH_LONG).show();
        }
        else if(CB1.isChecked()){
            givenRate=1.0;
        }else if(CB2.isChecked()){
            givenRate=2.0;
        }else if(CB3.isChecked()){
            givenRate=3.0;
        }else if(CB4.isChecked()){
            givenRate=4.0;
        }else if(CB5.isChecked()){
            givenRate=5.0;
        }else{
            Toast.makeText(CheckBooked.this, "Please choose a rate.", Toast.LENGTH_LONG).show();
            valid = false;
        }


        if(valid&&choosenSP!=null){
            Boolean isCommentOK = true;
            if(CBET.getText().toString().equals("")){
                CBET.setText("");
//                Toast.makeText(CheckBooked.this, "Please input a comment.", Toast.LENGTH_LONG).show();
            }else {
                String comment = CBET.getText().toString().trim();

                String str = comment.replace(" ", "");

                Boolean isAllSpecialCharacters = true;
                for (int i = str.length(); --i >= 0; ) {
                    char c = str.charAt(i);
                    if ((Character.isLetter(c))) {
                        isAllSpecialCharacters = false;
                    }
                }
                if (isAllSpecialCharacters) {
                    Toast.makeText(CheckBooked.this, "Invalid input, the comment must contain at least one English letter if it is not blank", Toast.LENGTH_SHORT).show();
                    isCommentOK = false;
                }
            }

            if (isCommentOK) {


                ArrayList<String> temp;
                temp = choosenSP.getComments();
                temp.add(CBET.getText().toString());
                choosenSP.setComments(temp);

                double tempRate = choosenSP.getCurrentRate();
                int tempNumber = choosenSP.getRateNumber();


//            choosenSP.setCurrentRate(tempRate);

                choosenSP.setCurrentRate((tempRate * tempNumber + givenRate) / (tempNumber + 1));
                choosenSP.setRateNumber(tempNumber + 1);


                int[][] mavail = choosenSP.stringToMatrix(choosenSP.getAvailabilityMatrixSelected());
                ArrayList<String> ab = MainActivity.hop.getBookedAvailabilityMatrix();
                String currentSelectedTimeSlots = ab.get(choosenIndex);
                int[][] currentSelectedTimeSlotsMatrix = choosenSP.stringToMatrix(currentSelectedTimeSlots);

                for (int i = 0; i < mavail.length; i++) {
                    for (int j = 0; j < mavail[i].length; j++) {
                        mavail[i][j] = mavail[i][j] - currentSelectedTimeSlotsMatrix[i][j];
                    }
                }

                choosenSP.setAvailabilityMatrixSelected(choosenSP.matrixToString(mavail));


                //remove processing service
                ArrayList<Service> as = MainActivity.hop.getHaveServiceArrayList();
                as.remove(choosenIndex);
                ArrayList<ServiceProviderProfile> ap = MainActivity.hop.getHaveServiceProviderArrayList();
                ap.remove(choosenIndex);

                ab.remove(choosenIndex);


                MainActivity.hop.setHaveServiceArrayList(as);
                MainActivity.hop.setHaveServiceProviderArrayList(ap);
                MainActivity.hop.setBookedAvailabilityMatrix(ab);


                DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
                DatabaseReference serviceProviderProfileRef = rootRef.child("serviceProviderProfile");
                serviceProviderProfileRef.child(choosenSP.getUserName()).setValue(choosenSP);
                DatabaseReference homeOwnerProfileRef = rootRef.child("homeOwnerProfile");
                homeOwnerProfileRef.child(MainActivity.hop.getUserName()).setValue(MainActivity.hop);


                Toast.makeText(CheckBooked.this, "Submit successfully.", Toast.LENGTH_LONG).show();


                Intent intent = new Intent(getApplicationContext(), Welcome_Owner.class);
                startActivity(intent);
            }

        }
    }
}
