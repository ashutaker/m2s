package com.learn.ashutosh.bottomnav;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddProductActivity extends AppCompatActivity {

    private static final String TAG = "AddProductActivity";
    public static final String ADD_PRODUCT_REPLY = "com.example.android.addcust.REPLY";

    EditText mProdName, mProdId, mQuantity, mCostPrice, mSellingPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        Toolbar toolbar = findViewById(R.id.add_cust_toolbar);
        setSupportActionBar(toolbar);

        mProdName = findViewById(R.id.productName_add);
        mProdId = findViewById(R.id.productID_add);
        mQuantity = findViewById(R.id.quantity_add);
        mCostPrice = findViewById(R.id.prodCostPrice_add);
        mSellingPrice = findViewById(R.id.prodSellPrice_add);


        final Button addProductButton = findViewById(R.id.button_add_product);
        addProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                Bundle bundle = new Bundle();

                bundle.putStringArray(ADD_PRODUCT_REPLY,new String[] {mProdName.getText().toString(),
                mProdId.getText().toString(),
                mQuantity.getText().toString(),
                mCostPrice.getText().toString(),
                mSellingPrice.getText().toString()});

                replyIntent.putExtras(bundle);
                setResult(RESULT_OK,replyIntent);
            }
        });



    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
}
