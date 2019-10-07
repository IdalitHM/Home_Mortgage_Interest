package com.example.homemortgageinterest;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Interest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interest);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView totalInterest = (TextView) findViewById(R.id.txttotalInterest);
        ImageView image = (ImageView) findViewById(R.id.imgYears);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        float decMonthly = sharedPref.getFloat("key1", 0);
        int intYears = sharedPref.getInt("key2", 0);
        int intLoan = sharedPref.getInt("key3", 0);
        float decTotalInterest;
        int intMonths;

        intMonths = intYears * 12;
        decTotalInterest = (decMonthly * intMonths) - intLoan;
        DecimalFormat currency = new DecimalFormat("$###,###.##");
        totalInterest.setText("Total interest paid " + currency.format(decTotalInterest));
        if (intYears == 30) {
            image.setImageResource(R.drawable.thirty);
        } else if (intYears == 20) {
            image.setImageResource(R.drawable.twenty);
        } else if (intYears == 10) {
            image.setImageResource(R.drawable.ten);
        } else {
            totalInterest.setText("Enter 10, 20, or 30 years");
        }

    }

}
