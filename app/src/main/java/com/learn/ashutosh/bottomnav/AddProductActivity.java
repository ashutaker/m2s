package com.learn.ashutosh.bottomnav;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class AddProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        Toolbar toolbar = findViewById(R.id.add_cust_toolbar);
        setSupportActionBar(toolbar);



    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
}
