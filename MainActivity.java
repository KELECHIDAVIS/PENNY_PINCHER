package com.example.PENNY_PINCHER;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity
{
    private static int disabledTimer = 3000;
    Button b;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = (Button)findViewById(R.id.tip);


    }

    // launch settings

    public void goHome(View view)
    {

        Intent home = new Intent(this, HomePage.class);
         startActivity(home);
    }
    public void aboutProject(View v)
    {

    }


    public void giveTip( View v)
    {
        Random r = new Random();
        //this array holds the tips for the wise man once said button
        String[] tips = {"You Don't Stay Rich By Spending Money", "Track Every Expense", "Create A Budget A The Start Of The Month To Keep Track Of Your Money", "Establish Needs Versus Wants", "Prioritize Debt Repayment",
        "Plan For Large Purchases To Limit Stress On Your Budget", "Always Prepare An Emergency Fund Just In Case "};

        Toast.makeText(this, tips[r.nextInt(tips.length)], Toast.LENGTH_SHORT).show();
        b.setEnabled(false);

        //Makes the button disbled for 2 seconds on click
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run()
            {
                b.setEnabled(true);
                Log.d("slept","Button Disabled");
            }

        }, disabledTimer); //time
    }



}