package com.example.yi.lbsystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ViewTrans extends AppCompatActivity {

    private String[] transInfo;
    private int counter;
    private int mark=-1;
    private Button back,change;
    private TextView hint;
    private ListView listView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_trans);
        initView();
    }

    public void initView(){
        listView = (ListView) findViewById(R.id.listView);
        back = (Button) findViewById(R.id.vBack_bt);
        change = (Button) findViewById(R.id.vChange_bt);
        hint = (TextView) findViewById(R.id.vHint_tv);
        hint.setCursorVisible(false);
        initListView();

    }

    public void initListView(){
        transInfo = new String[MainActivity.transactionsList.size()];
        counter = 0;
        for(Transaction transaction : MainActivity.transactionsList){
            String temp = "";
            temp += "Date: "+transaction.getTimestamp()+"\n";       //line 1

//            temp += "Currency: "+(transaction.isCAD()?"CAD":"CNY ")+"  Exchange Rate: "
//                    +(transaction.isCAD()?"1":transaction.getExchangeRate())+"\n";                  //line 4
            temp += "Balance: "+((transaction.getBalance()>=0)?MainActivity.MIN+" own "+MainActivity.JI+" "+transaction.getBalance():
                    MainActivity.JI+" own "+MainActivity.MIN+" "+(0-transaction.getBalance()))+"\n";//line 5
            temp += "Borrower: "+transaction.getBorrower()+"    ";    //line 2
            temp += "Loaner: "+transaction.getLoaner()+"\n";        //line 3
            temp += "Amount: "+transaction.getAmount()+"\n";        //line 6
            temp += "Comments: "+transaction.getComments();
            temp += "\nfor test clour: "+transaction.getClr()+"\n";

            transInfo[counter] = temp;
            counter++;
        }
        ListAdapter listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, transInfo);
        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {//position is the item be clicked's position
                        mark = position;
                        hint.setCursorVisible(false);
                        hint.setText("Selected: "+MainActivity.transactionsList.get(position).getTimestamp());
                    }
                }
        );
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mark==-1){
                    Toast.makeText(ViewTrans.this, "Please chose on from the list to change status.", Toast.LENGTH_SHORT).show();
                }else {
                    if(MainActivity.isAdmin){
                        Transaction tr = MainActivity.transactionsList.get(mark);
                        double corBalance = tr.getAmount();
                        if(tr.getBorrower().equals(MainActivity.MIN)){
                            MainActivity.myValueRef.setValue(""+(Double.valueOf(MainActivity.balances)-corBalance));
                        }else {
                            MainActivity.myValueRef.setValue(""+(Double.valueOf(MainActivity.balances)+corBalance));

                        }
                        MainActivity.myTransRef.child(tr.getTimestamp()).removeValue();
                        Toast.makeText(ViewTrans.this, "Deleted successfully.", Toast.LENGTH_SHORT).show();
                        initListView();
                        Intent intent = new Intent(getApplicationContext(),ViewTrans.class);
                        startActivity(intent);
                    }else {
                        Transaction tr = MainActivity.transactionsList.get(mark);
                        if (tr.getClr().equals("green")) {
                            tr.setClr("yellow");
                        } else {
                            tr.setClr("green");
                        }
                        MainActivity.myTransRef.child(tr.getTimestamp()).setValue(tr);

                        Transaction transaction = MainActivity.transactionsList.get(mark);
                        String temp = "";
                        temp += "Date: " + transaction.getTimestamp() + "\n";       //line 1

//                    temp += "Currency: " + (transaction.isCAD() ? "CAD" : "CNY ") + "  Exchange Rate: "
//                            + (transaction.isCAD() ? "1" : transaction.getExchangeRate()) + "\n";                  //line 4
                        temp += "Balance: " + ((transaction.getBalance() >= 0) ? MainActivity.MIN + " own " + MainActivity.JI + " " + transaction.getBalance() :
                                MainActivity.JI + " own " + MainActivity.MIN + " " + (0 - transaction.getBalance())) + "\n";//line 5
                        temp += "Borrower: " + transaction.getBorrower() + "    ";    //line 2
                        temp += "Loaner: " + transaction.getLoaner() + "\n";        //line 3
                        temp += "Amount: " + transaction.getAmount() + "\n";        //line 6
                        temp += "Comments: " + transaction.getComments();
                        temp += "\nfor test clour: " + (transaction.getClr().equals("green") ? "yellow\n" : "green\n");

                        transInfo[mark] = temp;
                        initListView();
                        Toast.makeText(ViewTrans.this, "Changed validity successfully.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });



    }

}
