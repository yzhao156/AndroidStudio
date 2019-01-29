package com.example.yi.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class BookNewServiceTimeSlot extends AppCompatActivity {

    private int[][] mavail = new int[9][5];

    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference serviceProviderProfileRef = rootRef.child("serviceProviderProfile");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_new_service_time_slot);

        mavail = BookNewService.providerChoosed.stringToMatrix(BookNewService.providerChoosed.getAvailabilityMatrixSelected());
        imageInitialization();
    }


    public void click (int r, int c, ImageView avatarImage) {
        if (mavail[r-8][c-1] == 1) {
            mavail[r-8][c-1] = 4;
            String drawableName = "p01";
            int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
            avatarImage.setImageResource(resID);
        } else if (mavail[r-8][c-1] == 4) {
            mavail[r-8][c-1] = 1;
            String drawableName = "p00";
            int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
            avatarImage.setImageResource(resID);
        } else {
            Toast.makeText(BookNewServiceTimeSlot.this, "The service provider is not available at this time slot", Toast.LENGTH_LONG).show();
        }
    }

    public void initializeImage(int r, int c, ImageView avatarImage) {
        if (mavail[r-8][c-1] == 0) {
            String drawableName = "p03";
            int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
            avatarImage.setImageResource(resID);
        }
        else if (mavail[r-8][c-1] == 1) {
            String drawableName = "p00";
            int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
            avatarImage.setImageResource(resID);
        }
        else if (mavail[r-8][c-1] == 2) {
            String drawableName = "p02";
            int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
            avatarImage.setImageResource(resID);
        }
    }


    public void imageInitialization() {
        ImageView avatarImage = (ImageView) findViewById(R.id.i081);
        initializeImage(8,1,avatarImage);
        avatarImage = (ImageView) findViewById(R.id.i082);
        initializeImage(8,2,avatarImage);
        avatarImage = (ImageView) findViewById(R.id.i083);
        initializeImage(8,3,avatarImage);
        avatarImage = (ImageView) findViewById(R.id.i084);
        initializeImage(8,4,avatarImage);
        avatarImage = (ImageView) findViewById(R.id.i085);
        initializeImage(8,5,avatarImage);


        avatarImage = (ImageView) findViewById(R.id.i091);
        initializeImage(9,1,avatarImage);
        avatarImage = (ImageView) findViewById(R.id.i092);
        initializeImage(9,2,avatarImage);
        avatarImage = (ImageView) findViewById(R.id.i093);
        initializeImage(9,3,avatarImage);
        avatarImage = (ImageView) findViewById(R.id.i094);
        initializeImage(9,4,avatarImage);
        avatarImage = (ImageView) findViewById(R.id.i095);
        initializeImage(9,5,avatarImage);

        avatarImage = (ImageView) findViewById(R.id.i101);
        initializeImage(10,1,avatarImage);
        avatarImage = (ImageView) findViewById(R.id.i102);
        initializeImage(10,2,avatarImage);
        avatarImage = (ImageView) findViewById(R.id.i103);
        initializeImage(10,3,avatarImage);
        avatarImage = (ImageView) findViewById(R.id.i104);
        initializeImage(10,4,avatarImage);
        avatarImage = (ImageView) findViewById(R.id.i105);
        initializeImage(10,5,avatarImage);

        avatarImage = (ImageView) findViewById(R.id.i111);
        initializeImage(11,1,avatarImage);
        avatarImage = (ImageView) findViewById(R.id.i112);
        initializeImage(11,2,avatarImage);
        avatarImage = (ImageView) findViewById(R.id.i113);
        initializeImage(11,3,avatarImage);
        avatarImage = (ImageView) findViewById(R.id.i114);
        initializeImage(11,4,avatarImage);
        avatarImage = (ImageView) findViewById(R.id.i115);
        initializeImage(11,5,avatarImage);

        avatarImage = (ImageView) findViewById(R.id.i121);
        initializeImage(12,1,avatarImage);
        avatarImage = (ImageView) findViewById(R.id.i122);
        initializeImage(12,2,avatarImage);
        avatarImage = (ImageView) findViewById(R.id.i123);
        initializeImage(12,3,avatarImage);
        avatarImage = (ImageView) findViewById(R.id.i124);
        initializeImage(12,4,avatarImage);
        avatarImage = (ImageView) findViewById(R.id.i125);
        initializeImage(12,5,avatarImage);

        avatarImage = (ImageView) findViewById(R.id.i131);
        initializeImage(13,1,avatarImage);
        avatarImage = (ImageView) findViewById(R.id.i132);
        initializeImage(13,2,avatarImage);
        avatarImage = (ImageView) findViewById(R.id.i133);
        initializeImage(13,3,avatarImage);
        avatarImage = (ImageView) findViewById(R.id.i134);
        initializeImage(13,4,avatarImage);
        avatarImage = (ImageView) findViewById(R.id.i135);
        initializeImage(13,5,avatarImage);

        avatarImage = (ImageView) findViewById(R.id.i141);
        initializeImage(14,1,avatarImage);
        avatarImage = (ImageView) findViewById(R.id.i142);
        initializeImage(14,2,avatarImage);
        avatarImage = (ImageView) findViewById(R.id.i143);
        initializeImage(14,3,avatarImage);
        avatarImage = (ImageView) findViewById(R.id.i144);
        initializeImage(14,4,avatarImage);
        avatarImage = (ImageView) findViewById(R.id.i145);
        initializeImage(14,5,avatarImage);

        avatarImage = (ImageView) findViewById(R.id.i151);
        initializeImage(15,1,avatarImage);
        avatarImage = (ImageView) findViewById(R.id.i152);
        initializeImage(15,2,avatarImage);
        avatarImage = (ImageView) findViewById(R.id.i153);
        initializeImage(15,3,avatarImage);
        avatarImage = (ImageView) findViewById(R.id.i154);
        initializeImage(15,4,avatarImage);
        avatarImage = (ImageView) findViewById(R.id.i155);
        initializeImage(15,5,avatarImage);

        avatarImage = (ImageView) findViewById(R.id.i161);
        initializeImage(16,1,avatarImage);
        avatarImage = (ImageView) findViewById(R.id.i162);
        initializeImage(16,2,avatarImage);
        avatarImage = (ImageView) findViewById(R.id.i163);
        initializeImage(16,3,avatarImage);
        avatarImage = (ImageView) findViewById(R.id.i164);
        initializeImage(16,4,avatarImage);
        avatarImage = (ImageView) findViewById(R.id.i165);
        initializeImage(16,5,avatarImage);
    }




    /////////////////////////////////////////////////////////////////////////////////////////////
//    8:00
    public void c081(View view) {
        ImageView avatarImage = (ImageView) findViewById(R.id.i081);
        click(8,1,avatarImage);
    }

    public void c082(View view) {
        ImageView avatarImage = (ImageView) findViewById(R.id.i082);
        click(8,2,avatarImage);
    }

    public void c083(View view) {
        ImageView avatarImage = (ImageView) findViewById(R.id.i083);
        click(8,3,avatarImage);
    }

    public void c084(View view) {
        ImageView avatarImage = (ImageView) findViewById(R.id.i084);
        click(8,4,avatarImage);
    }

    public void c085(View view) {
        ImageView avatarImage = (ImageView) findViewById(R.id.i085);
        click(8,5,avatarImage);
    }

/////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////

    //    9:00
    public void c091(View view) {
        ImageView avatarImage = (ImageView) findViewById(R.id.i091);
        click(9,1,avatarImage);
    }

    public void c092(View view) {
        ImageView avatarImage = (ImageView) findViewById(R.id.i092);
        click(9,2,avatarImage);
    }

    public void c093(View view) {
        ImageView avatarImage = (ImageView) findViewById(R.id.i093);
        click(9,3,avatarImage);
    }

    public void c094(View view) {
        ImageView avatarImage = (ImageView) findViewById(R.id.i094);
        click(9,4,avatarImage);
    }

    public void c095(View view) {
        ImageView avatarImage = (ImageView) findViewById(R.id.i095);
        click(9,5,avatarImage);
    }

/////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////

    //    10:00
    public void c101(View view) {
        ImageView avatarImage = (ImageView) findViewById(R.id.i101);
        click(10,1,avatarImage);
    }

    public void c102(View view) {
        ImageView avatarImage = (ImageView) findViewById(R.id.i102);
        click(10,2,avatarImage);
    }

    public void c103(View view) {
        ImageView avatarImage = (ImageView) findViewById(R.id.i103);
        click(10,3,avatarImage);
    }

    public void c104(View view) {
        ImageView avatarImage = (ImageView) findViewById(R.id.i104);
        click(10,4,avatarImage);
    }

    public void c105(View view) {
        ImageView avatarImage = (ImageView) findViewById(R.id.i105);
        click(10,5,avatarImage);
    }

/////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////

    //    11:00
    public void c111(View view) {
        ImageView avatarImage = (ImageView) findViewById(R.id.i111);
        click(11,1,avatarImage);
    }

    public void c112(View view) {
        ImageView avatarImage = (ImageView) findViewById(R.id.i112);
        click(11,2,avatarImage);
    }

    public void c113(View view) {
        ImageView avatarImage = (ImageView) findViewById(R.id.i113);
        click(11,3,avatarImage);
    }

    public void c114(View view) {
        ImageView avatarImage = (ImageView) findViewById(R.id.i114);
        click(11,4,avatarImage);
    }

    public void c115(View view) {
        ImageView avatarImage = (ImageView) findViewById(R.id.i115);
        click(11,5,avatarImage);
    }

/////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////

    //    12:00
    public void c121(View view) {
        ImageView avatarImage = (ImageView) findViewById(R.id.i121);
        click(12,1,avatarImage);
    }

    public void c122(View view) {
        ImageView avatarImage = (ImageView) findViewById(R.id.i122);
        click(12,2,avatarImage);
    }

    public void c123(View view) {
        ImageView avatarImage = (ImageView) findViewById(R.id.i123);
        click(12,3,avatarImage);
    }

    public void c124(View view) {
        ImageView avatarImage = (ImageView) findViewById(R.id.i124);
        click(12,4,avatarImage);
    }

    public void c125(View view) {
        ImageView avatarImage = (ImageView) findViewById(R.id.i125);
        click(12,5,avatarImage);
    }

/////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////

    //    13:00
    public void c131(View view) {
        ImageView avatarImage = (ImageView) findViewById(R.id.i131);
        click(13,1,avatarImage);
    }

    public void c132(View view) {
        ImageView avatarImage = (ImageView) findViewById(R.id.i132);
        click(13,2,avatarImage);
    }

    public void c133(View view) {
        ImageView avatarImage = (ImageView) findViewById(R.id.i133);
        click(13,3,avatarImage);
    }

    public void c134(View view) {
        ImageView avatarImage = (ImageView) findViewById(R.id.i134);
        click(13,4,avatarImage);
    }

    public void c135(View view) {
        ImageView avatarImage = (ImageView) findViewById(R.id.i135);
        click(13,5,avatarImage);
    }

/////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////

    //    14:00
    public void c141(View view) {
        ImageView avatarImage = (ImageView) findViewById(R.id.i141);
        click(14,1,avatarImage);
    }

    public void c142(View view) {
        ImageView avatarImage = (ImageView) findViewById(R.id.i142);
        click(14,2,avatarImage);
    }

    public void c143(View view) {
        ImageView avatarImage = (ImageView) findViewById(R.id.i143);
        click(14,3,avatarImage);
    }

    public void c144(View view) {
        ImageView avatarImage = (ImageView) findViewById(R.id.i144);
        click(14,4,avatarImage);
    }

    public void c145(View view) {
        ImageView avatarImage = (ImageView) findViewById(R.id.i145);
        click(14,5,avatarImage);
    }

/////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////

    //    15:00
    public void c151(View view) {
        ImageView avatarImage = (ImageView) findViewById(R.id.i151);
        click(15,1,avatarImage);
    }

    public void c152(View view) {
        ImageView avatarImage = (ImageView) findViewById(R.id.i152);
        click(15,2,avatarImage);
    }

    public void c153(View view) {
        ImageView avatarImage = (ImageView) findViewById(R.id.i153);
        click(15,3,avatarImage);
    }

    public void c154(View view) {
        ImageView avatarImage = (ImageView) findViewById(R.id.i154);
        click(15,4,avatarImage);
    }

    public void c155(View view) {
        ImageView avatarImage = (ImageView) findViewById(R.id.i155);
        click(15,5,avatarImage);
    }

/////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////

    //    16:00
    public void c161(View view) {
        ImageView avatarImage = (ImageView) findViewById(R.id.i161);
        click(16,1,avatarImage);
    }

    public void c162(View view) {
        ImageView avatarImage = (ImageView) findViewById(R.id.i162);
        click(16,2,avatarImage);
    }

    public void c163(View view) {
        ImageView avatarImage = (ImageView) findViewById(R.id.i163);
        click(16,3,avatarImage);
    }

    public void c164(View view) {
        ImageView avatarImage = (ImageView) findViewById(R.id.i164);
        click(16,4,avatarImage);
    }

    public void c165(View view) {
        ImageView avatarImage = (ImageView) findViewById(R.id.i165);
        click(16,5,avatarImage);
    }
/////////////////////////////////////////////////////////////////////////////////////////////

    public boolean checkAllZeros(int[][] mavail) {
        for(int i = 0; i < mavail.length; i++){
            for(int j = 0; j < mavail[i].length; j++){
                if(mavail[i][j] == 1){
                    return false;
                }
            }
        }

        return true;
    }


    public void btn_save(View view) {

        String currentSelectedTimeSlots = BookNewService.providerChoosed.matrixToString(mavail).replace("1", "0");
        currentSelectedTimeSlots = currentSelectedTimeSlots.replace("2", "0");
        currentSelectedTimeSlots = currentSelectedTimeSlots.replace("3", "0");
        currentSelectedTimeSlots = currentSelectedTimeSlots.replace("4", "1");

        if (checkAllZeros(BookNewService.providerChoosed.stringToMatrix(currentSelectedTimeSlots))) {

            Toast.makeText(BookNewServiceTimeSlot.this, "Please specify at least one time slot.", Toast.LENGTH_LONG).show();

        } else {
            //Save setAvailabilityMatrixSelected to sp's database
            BookNewService.providerChoosed.setAvailabilityMatrixSelected(BookNewService.providerChoosed.matrixToString(mavail).replace("4", "2"));//For selected
            serviceProviderProfileRef.child(BookNewService.providerChoosed.getUserName()).setValue(BookNewService.providerChoosed);


            ArrayList<Service> serviceArrayList = MainActivity.hop.getHaveServiceArrayList();
            ArrayList<ServiceProviderProfile> serviceProviderArrayList = MainActivity.hop.getHaveServiceProviderArrayList();
            ArrayList<String> bookedAvailabilityMatrix = MainActivity.hop.getBookedAvailabilityMatrix();

            serviceArrayList.add(BookNewService.serviceChoosed);
            serviceProviderArrayList.add(BookNewService.providerChoosed);



            bookedAvailabilityMatrix.add(currentSelectedTimeSlots);


            MainActivity.hop.setHaveServiceArrayList(serviceArrayList);
            MainActivity.hop.setHaveServiceProviderArrayList(serviceProviderArrayList);
            MainActivity.hop.setBookedAvailabilityMatrix(bookedAvailabilityMatrix);

            //Save hop to database
            DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
            DatabaseReference homeOwnerProfileRef = rootRef.child("homeOwnerProfile");
            homeOwnerProfileRef.child(MainActivity.hop.getUserName()).setValue(MainActivity.hop);


            Toast.makeText(BookNewServiceTimeSlot.this, "Time slot selected successfully", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(getApplicationContext(), Welcome_Owner.class);
            startActivity(intent);
        }
    }

    public void btn_reset(View view) {

        Intent intent = new Intent(getApplicationContext(),BookNewServiceTimeSlot.class);
        startActivity(intent);

        Toast.makeText(BookNewServiceTimeSlot.this, "Reset", Toast.LENGTH_LONG).show();
    }
}
