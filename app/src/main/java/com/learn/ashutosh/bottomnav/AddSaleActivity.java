package com.learn.ashutosh.bottomnav;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import java.util.Calendar;

public class AddSaleActivity extends AppCompatActivity {

    private Calendar calendar = Calendar.getInstance();
    private EditText saleDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sale);
        Toolbar toolbar = findViewById(R.id.add_sale_toolbar);
        setSupportActionBar(toolbar);

        saleDate = findViewById(R.id.saleDate);





    }


}
