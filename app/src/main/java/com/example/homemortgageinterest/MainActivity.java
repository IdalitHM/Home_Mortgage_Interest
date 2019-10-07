package com.example.homemortgageinterest;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.preference.PreferenceManager;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    float decMonthly;
    int intYears;
    int intLoan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final EditText monthly = (EditText) findViewById(R.id.txtMonthly);
        final EditText years = (EditText) findViewById(R.id.txtYears);
        final EditText loan = (EditText) findViewById(R.id.txtLoan);
        Button button = (Button) findViewById(R.id.btnInterest);
        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decMonthly = Float.parseFloat(monthly.getText().toString());
                intYears = Integer.parseInt(years.getText().toString());
                intLoan = Integer.parseInt(loan.getText().toString());
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putFloat("key1", decMonthly);
                editor.putInt("key2",intYears);
                editor.putInt("key3",intLoan);
                editor.commit();
                startActivity(new Intent(MainActivity.this, Interest.class));
            }
        });

    }

}
