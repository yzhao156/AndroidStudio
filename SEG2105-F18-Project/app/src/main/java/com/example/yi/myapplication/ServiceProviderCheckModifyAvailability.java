package com.example.yi.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ServiceProviderCheckModifyAvailability extends AppCompatActivity {

    private int[][] mavail = new int[9][5];

    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference serviceProviderProfileRef = rootRef.child("serviceProviderProfile");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_provider_check_modify_availability);

        mavail = MainActivity.spp.stringToMatrix(MainActivity.spp.getAvailabilityMatrix());
        imageInitialization();
    }



    public void click (int r, int c, ImageView avatarImage) {
        if (mavail[r-8][c-1] == 0) {
            mavail[r-8][c-1] = 1;
            String drawableName = "p01";
            int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
            avatarImage.setImageResource(resID);
        }
        else if (mavail[r-8][c-1] == 1) {
            mavail[r-8][c-1] = 0;
            String drawableName = "p00";
            int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
            avatarImage.setImageResource(resID);
        }
    }

    public void initializeImage(int r, int c, ImageView avatarImage) {
        if (mavail[r-8][c-1] == 0) {
            String drawableName = "p00";
            int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
            avatarImage.setImageResource(resID);
        }
        else if (mavail[r-8][c-1] == 1) {
            String drawableName = "p01";
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
        int r = 10; int c = 1;
        if (mavail[r-8][c-1] == 0) {
            mavail[r-8][c-1] = 1;
            ImageView avatarImage = (ImageView) findViewById(R.id.i101);
            String drawableName = "p01";
            int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
            avatarImage.setImageResource(resID);
        }
        else if (mavail[r-8][c-1] == 1) {
            mavail[r-8][c-1] = 0;
            ImageView avatarImage = (ImageView) findViewById(R.id.i101);
            String drawableName = "p00";
            int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
            avatarImage.setImageResource(resID);
        }
    }

    public void c102(View view) {
        int r = 10; int c = 2;
        if (mavail[r-8][c-1] == 0) {
            mavail[r-8][c-1] = 1;
            ImageView avatarImage = (ImageView) findViewById(R.id.i102);
            String drawableName = "p01";
            int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
            avatarImage.setImageResource(resID);
        }
        else if (mavail[r-8][c-1] == 1) {
            mavail[r-8][c-1] = 0;
            ImageView avatarImage = (ImageView) findViewById(R.id.i102);
            String drawableName = "p00";
            int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
            avatarImage.setImageResource(resID);
        }
    }

    public void c103(View view) {
        int r = 10; int c = 3;
        if (mavail[r-8][c-1] == 0) {
            mavail[r-8][c-1] = 1;
            ImageView avatarImage = (ImageView) findViewById(R.id.i103);
            String drawableName = "p01";
            int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
            avatarImage.setImageResource(resID);
        }
        else if (mavail[r-8][c-1] == 1) {
            mavail[r-8][c-1] = 0;
            ImageView avatarImage = (ImageView) findViewById(R.id.i103);
            String drawableName = "p00";
            int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
            avatarImage.setImageResource(resID);
        }
    }

    public void c104(View view) {
        int r = 10; int c = 4;
        if (mavail[r-8][c-1] == 0) {
            mavail[r-8][c-1] = 1;
            ImageView avatarImage = (ImageView) findViewById(R.id.i104);
            String drawableName = "p01";
            int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
            avatarImage.setImageResource(resID);
        }
        else if (mavail[r-8][c-1] == 1) {
            mavail[r-8][c-1] = 0;
            ImageView avatarImage = (ImageView) findViewById(R.id.i104);
            String drawableName = "p00";
            int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
            avatarImage.setImageResource(resID);
        }
    }

    public void c105(View view) {
        int r = 10; int c = 5;
        if (mavail[r-8][c-1] == 0) {
            mavail[r-8][c-1] = 1;
            ImageView avatarImage = (ImageView) findViewById(R.id.i105);
            String drawableName = "p01";
            int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
            avatarImage.setImageResource(resID);
        }
        else if (mavail[r-8][c-1] == 1) {
            mavail[r-8][c-1] = 0;
            ImageView avatarImage = (ImageView) findViewById(R.id.i105);
            String drawableName = "p00";
            int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
            avatarImage.setImageResource(resID);
        }
    }

/////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////

    //    11:00
    public void c111(View view) {
        int r = 11; int c = 1;
        if (mavail[r-8][c-1] == 0) {
            mavail[r-8][c-1] = 1;
            ImageView avatarImage = (ImageView) findViewById(R.id.i111);
            String drawableName = "p01";
            int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
            avatarImage.setImageResource(resID);
        }
        else if (mavail[r-8][c-1] == 1) {
            mavail[r-8][c-1] = 0;
            ImageView avatarImage = (ImageView) findViewById(R.id.i111);
            String drawableName = "p00";
            int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
            avatarImage.setImageResource(resID);
        }
    }

    public void c112(View view) {
        int r = 11; int c = 2;
        if (mavail[r-8][c-1] == 0) {
            mavail[r-8][c-1] = 1;
            ImageView avatarImage = (ImageView) findViewById(R.id.i112);
            String drawableName = "p01";
            int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
            avatarImage.setImageResource(resID);
        }
        else if (mavail[r-8][c-1] == 1) {
            mavail[r-8][c-1] = 0;
            ImageView avatarImage = (ImageView) findViewById(R.id.i112);
            String drawableName = "p00";
            int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
            avatarImage.setImageResource(resID);
        }
    }

    public void c113(View view) {
        int r = 11; int c = 3;
        if (mavail[r-8][c-1] == 0) {
            mavail[r-8][c-1] = 1;
            ImageView avatarImage = (ImageView) findViewById(R.id.i113);
            String drawableName = "p01";
            int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
            avatarImage.setImageResource(resID);
        }
        else if (mavail[r-8][c-1] == 1) {
            mavail[r-8][c-1] = 0;
            ImageView avatarImage = (ImageView) findViewById(R.id.i113);
            String drawableName = "p00";
            int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
            avatarImage.setImageResource(resID);
        }
    }

    public void c114(View view) {
        int r = 11; int c = 4;
        if (mavail[r-8][c-1] == 0) {
            mavail[r-8][c-1] = 1;
            ImageView avatarImage = (ImageView) findViewById(R.id.i114);
            String drawableName = "p01";
            int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
            avatarImage.setImageResource(resID);
        }
        else if (mavail[r-8][c-1] == 1) {
            mavail[r-8][c-1] = 0;
            ImageView avatarImage = (ImageView) findViewById(R.id.i114);
            String drawableName = "p00";
            int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
            avatarImage.setImageResource(resID);
        }
    }

    public void c115(View view) {
        int r = 11; int c = 5;
        if (mavail[r-8][c-1] == 0) {
            mavail[r-8][c-1] = 1;
            ImageView avatarImage = (ImageView) findViewById(R.id.i115);
            String drawableName = "p01";
            int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
            avatarImage.setImageResource(resID);
        }
        else if (mavail[r-8][c-1] == 1) {
            mavail[r-8][c-1] = 0;
            ImageView avatarImage = (ImageView) findViewById(R.id.i115);
            String drawableName = "p00";
            int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
            avatarImage.setImageResource(resID);
        }
    }

/////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////

    //    12:00
    public void c121(View view) {
        int r = 12; int c = 1;
        if (mavail[r-8][c-1] == 0) {
            mavail[r-8][c-1] = 1;
            ImageView avatarImage = (ImageView) findViewById(R.id.i121);
            String drawableName = "p01";
            int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
            avatarImage.setImageResource(resID);
        }
        else if (mavail[r-8][c-1] == 1) {
            mavail[r-8][c-1] = 0;
            ImageView avatarImage = (ImageView) findViewById(R.id.i121);
            String drawableName = "p00";
            int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
            avatarImage.setImageResource(resID);
        }
    }

    public void c122(View view) {
        int r = 12; int c = 2;
        if (mavail[r-8][c-1] == 0) {
            mavail[r-8][c-1] = 1;
            ImageView avatarImage = (ImageView) findViewById(R.id.i122);
            String drawableName = "p01";
            int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
            avatarImage.setImageResource(resID);
        }
        else if (mavail[r-8][c-1] == 1) {
            mavail[r-8][c-1] = 0;
            ImageView avatarImage = (ImageView) findViewById(R.id.i122);
            String drawableName = "p00";
            int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
            avatarImage.setImageResource(resID);
        }
    }

    public void c123(View view) {
        int r = 12; int c = 3;
        if (mavail[r-8][c-1] == 0) {
            mavail[r-8][c-1] = 1;
            ImageView avatarImage = (ImageView) findViewById(R.id.i123);
            String drawableName = "p01";
            int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
            avatarImage.setImageResource(resID);
        }
        else if (mavail[r-8][c-1] == 1) {
            mavail[r-8][c-1] = 0;
            ImageView avatarImage = (ImageView) findViewById(R.id.i123);
            String drawableName = "p00";
            int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
            avatarImage.setImageResource(resID);
        }
    }

    public void c124(View view) {
        int r = 12; int c = 4;
        if (mavail[r-8][c-1] == 0) {
            mavail[r-8][c-1] = 1;
            ImageView avatarImage = (ImageView) findViewById(R.id.i124);
            String drawableName = "p01";
            int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
            avatarImage.setImageResource(resID);
        }
        else if (mavail[r-8][c-1] == 1) {
            mavail[r-8][c-1] = 0;
            ImageView avatarImage = (ImageView) findViewById(R.id.i124);
            String drawableName = "p00";
            int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
            avatarImage.setImageResource(resID);
        }
    }

    public void c125(View view) {
        int r = 12; int c = 5;
        if (mavail[r-8][c-1] == 0) {
            mavail[r-8][c-1] = 1;
            ImageView avatarImage = (ImageView) findViewById(R.id.i125);
            String drawableName = "p01";
            int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
            avatarImage.setImageResource(resID);
        }
        else if (mavail[r-8][c-1] == 1) {
            mavail[r-8][c-1] = 0;
            ImageView avatarImage = (ImageView) findViewById(R.id.i125);
            String drawableName = "p00";
            int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
            avatarImage.setImageResource(resID);
        }
    }

/////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////

    //    13:00
    public void c131(View view) {
        int r = 13; int c = 1;
        if (mavail[r-8][c-1] == 0) {
            mavail[r-8][c-1] = 1;
            ImageView avatarImage = (ImageView) findViewById(R.id.i131);
            String drawableName = "p01";
            int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
            avatarImage.setImageResource(resID);
        }
        else if (mavail[r-8][c-1] == 1) {
            mavail[r-8][c-1] = 0;
            ImageView avatarImage = (ImageView) findViewById(R.id.i131);
            String drawableName = "p00";
            int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
            avatarImage.setImageResource(resID);
        }
    }

    public void c132(View view) {
        int r = 13; int c = 2;
        if (mavail[r-8][c-1] == 0) {
            mavail[r-8][c-1] = 1;
            ImageView avatarImage = (ImageView) findViewById(R.id.i132);
            String drawableName = "p01";
            int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
            avatarImage.setImageResource(resID);
        }
        else if (mavail[r-8][c-1] == 1) {
            mavail[r-8][c-1] = 0;
            ImageView avatarImage = (ImageView) findViewById(R.id.i132);
            String drawableName = "p00";
            int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
            avatarImage.setImageResource(resID);
        }
    }

    public void c133(View view) {
        int r = 13; int c = 3;
        if (mavail[r-8][c-1] == 0) {
            mavail[r-8][c-1] = 1;
            ImageView avatarImage = (ImageView) findViewById(R.id.i133);
            String drawableName = "p01";
            int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
            avatarImage.setImageResource(resID);
        }
        else if (mavail[r-8][c-1] == 1) {
            mavail[r-8][c-1] = 0;
            ImageView avatarImage = (ImageView) findViewById(R.id.i133);
            String drawableName = "p00";
            int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
            avatarImage.setImageResource(resID);
        }
    }

    public void c134(View view) {
        int r = 13; int c = 4;
        if (mavail[r-8][c-1] == 0) {
            mavail[r-8][c-1] = 1;
            ImageView avatarImage = (ImageView) findViewById(R.id.i134);
            String drawableName = "p01";
            int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
            avatarImage.setImageResource(resID);
        }
        else if (mavail[r-8][c-1] == 1) {
            mavail[r-8][c-1] = 0;
            ImageView avatarImage = (ImageView) findViewById(R.id.i134);
            String drawableName = "p00";
            int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
            avatarImage.setImageResource(resID);
        }
    }

    public void c135(View view) {
        int r = 13; int c = 5;
        if (mavail[r-8][c-1] == 0) {
            mavail[r-8][c-1] = 1;
            ImageView avatarImage = (ImageView) findViewById(R.id.i135);
            String drawableName = "p01";
            int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
            avatarImage.setImageResource(resID);
        }
        else if (mavail[r-8][c-1] == 1) {
            mavail[r-8][c-1] = 0;
            ImageView avatarImage = (ImageView) findViewById(R.id.i135);
            String drawableName = "p00";
            int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
            avatarImage.setImageResource(resID);
        }
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
        if(checkAllZeros(mavail)){
            Toast.makeText(ServiceProviderCheckModifyAvailability.this, "Please specify at least one time slot.", Toast.LENGTH_LONG).show();
        } else {
            MainActivity.spp.setAvailabilityMatrix(MainActivity.spp.matrixToString(mavail));
            MainActivity.spp.setAvailabilityMatrixSelected(MainActivity.spp.matrixToString(mavail));//For selected
            serviceProviderProfileRef.child(MainActivity.spp.getUserName()).setValue(MainActivity.spp);

            Toast.makeText(ServiceProviderCheckModifyAvailability.this, "Availability saved" + " successfully.", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(getApplicationContext(), Welcome_Provider.class);
            startActivity(intent);
        }
    }

    public void btn_reset(View view) {

        Intent intent = new Intent(getApplicationContext(),ServiceProviderCheckModifyAvailability.class);
        startActivity(intent);

        Toast.makeText(ServiceProviderCheckModifyAvailability.this, "Reset", Toast.LENGTH_LONG).show();
    }
}
