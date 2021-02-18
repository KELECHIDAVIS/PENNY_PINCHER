package com.example.PENNY_PINCHER;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HomePage extends AppCompatActivity {

    protected static int monthlyIncome=0;
    protected static boolean fifty = false;
    protected static boolean sixty = false;
    protected static boolean seventy = false ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
    }


    public int getMonthlyIncome()
    {
        return monthlyIncome;

    }
    public void setMonthlyIncome(int income)
    {
        HomePage.monthlyIncome = income;
    }

    public static boolean isFifty() {
        return fifty;
    }

    public static void setFifty(boolean fifty) {
        HomePage.fifty = fifty;
    }



    public static boolean isSixty() {
        return sixty;
    }

    public static void setSixty(boolean sixty) {
        HomePage.sixty = sixty;
    }

    public static boolean isSeventy() {
        return seventy;
    }

    public static void setSeventy(boolean seventy) {
        HomePage.seventy = seventy;
    }




    //50 30 20
    public void fifty(View v)
    {
        TextView t = findViewById(R.id.income);
        int income = Integer.parseInt(t.getText().toString());
        setMonthlyIncome(income);
        setFifty(true);
        setSixty(false);
        setSeventy(false);
        Log.d("set", "its set");
        //opens the chart event
        Intent i = new Intent(this, Chart.class);
        startActivity(i);
        Log.d("success", String.valueOf(fifty));
    }

    //60 10 10 10
    public void sixty(View v)
    {
        TextView t = findViewById(R.id.income);
        int income = Integer.parseInt(t.getText().toString());
        setMonthlyIncome(income);
        setSixty(true);
        setFifty(false);
        setSeventy(false);
        //opens the chart event
        Intent i = new Intent(this, Chart.class);
        startActivity(i);

    }

    //70 20 10
    public void seventy(View v)
    {
        TextView t = findViewById(R.id.income);
        int income = Integer.parseInt(t.getText().toString());
        setMonthlyIncome(income);
        setSeventy(true);
        setFifty(false);
        setSixty(false);
        // opens the chart event
        Intent i = new Intent(this, Chart.class);
        startActivity(i);
    }


    //method for explain button
    public void explain(View v)
    {
        Button b = (Button)findViewById(R.id.explain);
        Toast.makeText(this,"50/30/20:Needs/Want/Debt Repayment or Savings\n" +
                "60/10/10/10/10:Needs/401k/Emergency Fund/Short-Term Saving/Fun\n" +
                "70/20/10:Living Expenses/Savings/Debt Payment  ", Toast.LENGTH_LONG).show();
        b.setEnabled(false);

        //Makes the button disabled for 2 seconds on click
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run()
            {
                b.setEnabled(true);
                Log.d("slept","Button Disabled");
            }

        }, 4000); //time in milliseconds

    }


}