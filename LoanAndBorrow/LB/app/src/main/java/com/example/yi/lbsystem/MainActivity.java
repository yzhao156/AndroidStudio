package com.example.yi.lbsystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

//import java.text.SimpleDateFormat;
//import java.util.Date;


public class MainActivity extends AppCompatActivity {

    private String TAG="JI";
    private RadioButton bj,bm,lj,lm,cad,cny;
    private EditText comment,amount,curreny;
    private Button mSubmitBt,mViewBt;
    private TextView mMainTv,currency1,currency2,coc;
    public static String balances;
    private  String borrower,loaner,amounts,comments;
    private String rate,date;
    private String cun;
    public static String MIN= "珉";
    public static String JI="鸡";
    private static String BALANCE="#balance";
    private static String ADMIN="#admin";
    private static String CLEAR="#clear";
    public static String COM = "No comments.";
    public static boolean isAdmin = false;
    public static LinkedList<Transaction> transactionsList = new LinkedList<>();



    static FirebaseDatabase database = FirebaseDatabase.getInstance();
    static DatabaseReference myRateRef = database.getReference("/LBSystem/Vars/Rate");
    static DatabaseReference myDatelRef = database.getReference("/LBSystem/Vars/Date");
    static DatabaseReference myValueRef = database.getReference("/LBSystem/Value/Balance");
    static DatabaseReference myTransRef = database.getReference("/LBSystem/Transactions");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        //for tests

    }

    @Override
    protected  void  onStart(){
        super.onStart();
        //初始化要用到，否则不需要用到
        /*FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myVarRef = database.getReference("/LBSystem/Vars");
        DatabaseReference myRateRef = myVarRef.child("Rate");
        DatabaseReference myDatelRef = myVarRef.child("Date");
        myRateRef.setValue("5.31");
        myDatelRef.setValue("2018.11.09");
        ////////////////////myValueRef.setValue("0");//init important value!!!*/
        //set value
        myValueRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot dataSnapshot) {
                balances = dataSnapshot.getValue(String.class);
                if (balances==null){
                    balances="0";
                }
                String tem = "Balance: "+((Double.parseDouble(balances)>=0)?MainActivity.MIN+" own "+MainActivity.JI+" "+Double.parseDouble(balances):
                        MainActivity.JI+" own "+MainActivity.MIN+" "+(0-Double.parseDouble(balances)));
                mMainTv.setText(tem);
                if (Double.valueOf(balances)==0){
                    for(Transaction transaction : transactionsList){
                        transaction.setClr("grey");
                    }
                }
            }

            @Override
            public void onCancelled( DatabaseError databaseError) {

            }
        });
        //set rate
        myRateRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot dataSnapshot) {
                rate = dataSnapshot.getValue(String.class);
            }

            @Override
            public void onCancelled( DatabaseError databaseError) {

            }
        });
        //set date
        myDatelRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                date = dataSnapshot.getValue(String.class);
            }

            @Override
            public void onCancelled( DatabaseError databaseError) {

            }
        });
        //set transactions
        myTransRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Transaction transaction;
                transactionsList.clear();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //getting transaction
                    transaction = postSnapshot.getValue(Transaction.class);
                    //adding transaction to the list
                    transactionsList.addFirst(transaction);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void initView(){
        //init views
        comment = (EditText)findViewById(R.id.comments_et);
        amount = (EditText)findViewById(R.id.amount_et);
        curreny = (EditText)findViewById(R.id.currency_et);
        mSubmitBt = (Button)findViewById(R.id.submit_bt);
        mViewBt = (Button)findViewById(R.id.view_bt);
        mMainTv = (TextView)findViewById(R.id.main_tv);
        currency1 = (TextView)findViewById(R.id.currency1_tv);
        currency2 = (TextView)findViewById(R.id.currency2_tv);
        coc = (TextView)findViewById(R.id.coc_tv);
        //set value

        //set visibility
        curreny.setVisibility(View.INVISIBLE);
        currency1.setVisibility(View.INVISIBLE);
        currency2.setVisibility(View.INVISIBLE);
        //add listener of btns
        mSubmitBt.setOnClickListener(new View.OnClickListener() {
            String  cc;
            @Override
            public void onClick(View v) {
                //for admin
                if(comment.getText().toString().equals("")){
                    cc = "null";
                    Toast.makeText(MainActivity.this, "At leat leave a comment = =", Toast.LENGTH_SHORT).show();

                }else{
                    cc=comment.getText().toString();
                }
                if (cc.substring(0,1).equals("#")&&cc!=null){
                    isAdmin = true;
                    if(comment.getText().toString().equals(BALANCE)){
                        if(amount.getText().toString().equals("")){
                            myValueRef.setValue("0");
                            Toast.makeText(MainActivity.this, "Cannot reset balance to null, instead set to 0", Toast.LENGTH_SHORT).show();
                        }else{
                            myValueRef.setValue(amount.getText().toString());
                            mMainTv.setText(amount.getText().toString());
                            Toast.makeText(MainActivity.this, "Changed balance to "+amount.getText().toString()+" successfully.", Toast.LENGTH_SHORT).show();

                        }
                    }else if(comment.getText().toString().equals(ADMIN)){
                        Toast.makeText(MainActivity.this, "Welcome Admin, special activity.", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),ViewTrans.class);
                        startActivity(intent);
                    }else if(comment.getText().toString().equals(CLEAR)){
                        Toast.makeText(MainActivity.this, "Rebooting firebase...", Toast.LENGTH_SHORT).show();
                        myValueRef.setValue("0");
                        myTransRef.removeValue();
                        transactionsList.clear();
                        mMainTv.setText("Reset successful!\nInit everything.");
                        Toast.makeText(MainActivity.this, "Finish reset base values in database!", Toast.LENGTH_SHORT).show();



                    }else{
                        Toast.makeText(MainActivity.this, "Invalid command.", Toast.LENGTH_SHORT).show();

                    }


                }else{

                    //for user

                    //set isAdmin
                    isAdmin=false;
                    //check valid
                    if (checkCondition()) {
                        //find name
                        if (bm.isChecked()) {
                            borrower = MIN;
                            loaner = JI;
                        } else {
                            borrower = JI;
                            loaner = MIN;
                        }
                        //find amounts&comments
                        amounts = amount.getText().toString();
                        double dd = Double.valueOf(amounts);
                        dd = (double)Math.round(dd*100)/100;
                        amounts = ""+dd;
                        comments = comment.getText().toString();
                        //check if null
                        if (amount.equals("")) {
                            amounts = "0";//avoid error
                        }
                        if (comments.equals("")) {
                            comments = COM;
                        }
                        //make instance
                        Transaction transaction = new Transaction(Double.parseDouble(amounts), loaner, borrower, comments);
                        //check isCAD and change currency to CAD
                        if (cny.isChecked()) {
                            transaction.setCAD(false);
                            String c = curreny.getText().toString();
                            transaction.setExchangeRate(Double.parseDouble(curreny.getText().toString()));
                            Double temp = (Double.parseDouble(amounts) / Double.parseDouble(curreny.getText().toString()));
                            temp = (double)Math.round(temp*100)/100;
                            transaction.setAmount(temp);
                        } else {
                            transaction.setCAD(true);
                        }
                        //calculate balance(min own ji)
                        double t = transaction.getAmount();
                        t = (double)Math.round(t*100)/100;
                        if (loaner.equals(MIN)) {
                            balances = "" + (Double.parseDouble(balances) - t);
                        } else {
                            balances = "" + (Double.parseDouble(balances) + t);
                        }
                        transaction.setBalance(Double.parseDouble(balances));
                        //set timestamp
                        long temp = System.currentTimeMillis();
                        Date date = new Date(temp);
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String timestamp = format.format(date);
                        transaction.setTimestamp(timestamp);
                        //set colour
                        transaction.setClr("green");
                        //set mM
                        String te = "Balance: " + ((Double.parseDouble(balances) >= 0) ? MainActivity.MIN + " own " + MainActivity.JI + " " + Double.parseDouble(balances) :
                                MainActivity.JI + " own " + MainActivity.MIN + " " + (0 - Double.parseDouble(balances)));

                        //mMainTv
                        mMainTv.setText(te);
                        //add to fire base
                        myTransRef.child(timestamp).setValue(transaction);
                        myValueRef.setValue(balances);
                        Toast.makeText(MainActivity.this, "Added to database successfully.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        //init RadioButton
        bj = (RadioButton)findViewById(R.id.brrowerJi_rb);
        bm = (RadioButton)findViewById(R.id.brrowerMin_rb);
        lj = (RadioButton)findViewById(R.id.loanerJi_rb);
        lm = (RadioButton)findViewById(R.id.loanerMin_rb);
        cad = (RadioButton)findViewById(R.id.currencyCAD_rb);
        cny = (RadioButton)findViewById(R.id.currencyCNY_rb);

        //set listen
        cad.setChecked(true);
        bj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lm.setChecked(true);
                lj.setChecked(false);
            }
        });
        bm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lj.setChecked(true);
                lm.setChecked(false);
            }
        });
        lm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bj.setChecked(true);
                bm.setChecked(false);
            }
        });
        lj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bm.setChecked(true);
                bj.setChecked(false);
            }
        });
        cny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currency1.setText("currency rate is");
                curreny.setText(rate);
                currency2.setText("¥/$, updated on "+date);
                curreny.setVisibility(View.VISIBLE);
                currency1.setVisibility(View.VISIBLE);
                currency2.setVisibility(View.VISIBLE);
                coc.setText("¥");
            }
        });
        cad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curreny.setVisibility(View.INVISIBLE);
                currency1.setVisibility(View.INVISIBLE);
                currency2.setVisibility(View.INVISIBLE);
                coc.setText("$");
            }
        });
        mViewBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ViewTrans.class);
                startActivity(intent);
            }
        });
    }
    public boolean checkCondition(){
        if (!(bj.isChecked()||bm.isChecked())) {
            Toast.makeText(MainActivity.this, "Will not add to database, you have to choose borrower and loaner", Toast.LENGTH_SHORT).show();
            return false;
        }else  if(curreny.getText().toString().equals("")||curreny.getText().toString().equals("0")) {
            Toast.makeText(MainActivity.this, "Will not add to database, currency can not be 0", Toast.LENGTH_SHORT).show();
            return false;
        }else if(amount.getText().toString().equals("")){
            Toast.makeText(MainActivity.this, "Will not add to database, amount can not be 0", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }


}
