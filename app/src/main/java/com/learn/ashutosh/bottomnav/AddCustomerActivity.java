package com.learn.ashutosh.bottomnav;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddCustomerActivity extends AppCompatActivity {

    public static final String ADD_CUST_REPLY = "com.example.android.addcust.REPLY";
    private static final String TAG = "AddCustomerActivity";

    private EditText mCustomerName;
    private EditText mCustomerPhone;
    private EditText mCustomerAddr;
    private EditText mCustomerEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);

        Toolbar toolbar = findViewById(R.id.add_cust_toolbar);
        setSupportActionBar(toolbar);
        mCustomerName = findViewById(R.id.custName);
        mCustomerPhone = findViewById(R.id.custPhone);
        mCustomerAddr = findViewById(R.id.custPostalAddress);
        mCustomerEmail = findViewById(R.id.custEmail);

        final Button addCust = findViewById(R.id.button_add_cust);
        addCust.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                Bundle bundle = new Bundle();
                if (TextUtils.isEmpty(mCustomerName.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    bundle.putStringArray(ADD_CUST_REPLY, new String[]{mCustomerName.getText().toString(),
                            mCustomerPhone.getText().toString(),
                            mCustomerAddr.getText().toString(),
                            mCustomerEmail.getText().toString()});
                    Log.i(TAG, "onActivityResult: " + bundle);

                    replyIntent.putExtras(bundle);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_add_customer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.getContact:
                Toast.makeText(this, "Added from phone contact", Toast.LENGTH_SHORT).show();
                return true;


        }


        return super.onOptionsItemSelected(item);
    }
}
