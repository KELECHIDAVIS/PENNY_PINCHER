package com.example.PENNY_PINCHER;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class Chart extends AppCompatActivity {

    private double fiftyPercent = HomePage.monthlyIncome*0.5;
    private double sixtyPercent = HomePage.monthlyIncome*0.6;
    private double seventyPercent = HomePage.monthlyIncome*0.7;
    private double thirtyPercent = HomePage.monthlyIncome*0.3;
    private double twentyPercent = HomePage.monthlyIncome*0.2;
    private double tenPercent = HomePage.monthlyIncome*0.1;





    private PieChart pieChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
        pieChart = findViewById(R.id.circle);
        setupPieChart();
        loadData();

    }

    private void setupPieChart()
    {
        pieChart.setDrawHoleEnabled(true);
        pieChart.setUsePercentValues(true);
        pieChart.setEntryLabelTextSize(13);
        pieChart.setEntryLabelColor(Color.BLACK);
        pieChart.setCenterText("YOUR BUDGET");
        pieChart.setCenterTextSize(24);
        pieChart.getDescription().setEnabled(false);

        Legend legend = pieChart.getLegend();

        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        legend.setTextSize(15);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        legend.setOrientation(Legend.LegendOrientation.VERTICAL);
        legend.setDrawInside(false);
        legend.setEnabled(true);



    }


    private void loadData()
    {
        // if they chose the 50 plan
        if(HomePage.isFifty())
        {
            ArrayList<PieEntry> entries = new ArrayList<>();
            entries.add(new PieEntry(.5f, "NEEDS"));
            entries.add(new PieEntry(.3f, "WANTS"));
            entries.add(new PieEntry(.2f, "SAVINGS**"));

            ArrayList<Integer> colors = new ArrayList<>();

            for(int color : ColorTemplate.MATERIAL_COLORS)
            {
                colors.add(color);
            }

            PieDataSet dataSet = new PieDataSet(entries,"");
            dataSet.setColors(colors);

            PieData data = new PieData(dataSet);
            data.setDrawValues(true);
            data.setValueFormatter(new PercentFormatter(pieChart));
            data.setValueTextSize(15f);
            data.setValueTextColor(Color.BLACK);

            pieChart.setData(data);

            pieChart.invalidate();
            pieChart.animateX(1500, Easing.EaseInOutQuad);


            //textview
            TextView overview = findViewById(R.id.overview);
            overview.setText("For this plan, \"NEEDS\" ("+Math.round(fiftyPercent*100.0)/100.0+") refers to living expenses such as mortgage, car payments, food, etc.\n" +
                    "\"WANTS\" ("+Math.round(thirtyPercent*100.0)/100.0+") are optional expenses that are not a necessity for the month.\n" +
                    "The asterisks on  \"SAVINGS\" ("+Math.round(twentyPercent*100.0)/100.0+") means that if you are debt-free it should go fully into savings or investments, otherwise if you have some debt it may be wise to put some if not all of this money toward that ");



        }else if(HomePage.isSixty()) // sixty  plan
        {
            ArrayList<PieEntry> entries = new ArrayList<>();
            entries.add(new PieEntry(.6f, "NEEDS"));
            entries.add(new PieEntry(.1f, "FUN"));
            entries.add(new PieEntry(.1f, "RETIREMENT"));
            entries.add(new PieEntry(.1f, "EMERGENCY"));
            entries.add(new PieEntry(.1f, "SAVING"));

            ArrayList<Integer> colors = new ArrayList<>();

            for(int color : ColorTemplate.MATERIAL_COLORS)
            {
                colors.add(color);
            }
            for(int color: ColorTemplate.COLORFUL_COLORS)
            {
                colors.add(color);
            }

            PieDataSet dataSet = new PieDataSet(entries,"");
            dataSet.setColors(colors);

            PieData data = new PieData(dataSet);
            data.setDrawValues(true);
            data.setValueFormatter(new PercentFormatter(pieChart));
            data.setValueTextSize(18f);
            data.setValueTextColor(Color.BLACK);

            pieChart.setData(data);

            pieChart.invalidate();
            pieChart.animateX(1700, Easing.EaseInOutQuad);


            //textview
            TextView overview = findViewById(R.id.overview);
            overview.setText("This plan separates your money into 5 categories: Needs ("+ Math.round(sixtyPercent*100.0)/100.0+"), Retirement ("+ Math.round(tenPercent*100.0)/100.0+"), Emergency Fund ("+ Math.round(tenPercent*100.0)/100.0+"), Savings ("+ Math.round(tenPercent*100.0)/100.0+"), and Fun ("+ Math.round(tenPercent*100.0)/100.0+"). Needs ares expenses that you are committed to and cannot continue living without. " +
                    "Retirement is a fund for when you stop working which might already be subtracted from your paycheck. " +
                    "Emergency Fund is something you would invest in long-term so that you can cover any big surprise expenses. " +
                    "Lastly, the Fun money could be used for anything that you might want.  ");

        }else // 70 plan
        {
            ArrayList<PieEntry> entries = new ArrayList<>();
            entries.add(new PieEntry(.7f, "NEEDS"));
            entries.add(new PieEntry(.2f, "SAVINGS"));
            entries.add(new PieEntry(.1f, "DEBT"));

            ArrayList<Integer> colors = new ArrayList<>();

            for(int color : ColorTemplate.MATERIAL_COLORS)
            {
                colors.add(color);
            }

            PieDataSet dataSet = new PieDataSet(entries,"");
            dataSet.setColors(colors);

            PieData data = new PieData(dataSet);
            data.setDrawValues(true);
            data.setValueFormatter(new PercentFormatter(pieChart));
            data.setValueTextSize(18f);
            data.setValueTextColor(Color.BLACK);

            pieChart.setData(data);

            pieChart.invalidate();
            pieChart.animateX(1700, Easing.EaseInOutQuad);


            //textview
            TextView overview = findViewById(R.id.overview);
            overview.setText("This plan separates your money into 3 categories: Living ("+ Math.round(seventyPercent*100.0)/100.0+"), Savings ("+ Math.round(twentyPercent*100.0)/100.0+"), and Debt Repayment ("+ Math.round(tenPercent*100.0)/100.0+"). Living expenses ares expenses that you are committed to and cannot continue living without. " +
                    "Savings could be split between a Retirement and an emergency fund. " +
                    "Lastly, the last "+Math.round(tenPercent*100.0)/100.0+" dollars should be put fully towards debt repayment ");

        }
        ArrayList<PieEntry> entries = new ArrayList<>();

    }



}