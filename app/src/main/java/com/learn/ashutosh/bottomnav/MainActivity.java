package com.learn.ashutosh.bottomnav;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {


    private CustomersFragment customersFragment;
    private ProductsFragment productsFragment;
    private SalesFragment salesFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FrameLayout mMainFrame = findViewById(R.id.main_frame);
        BottomNavigationView mMainNav = findViewById(R.id.bottom_nav);
        Toolbar mtoolbar =  findViewById(R.id.main_toolbar);



        customersFragment = new CustomersFragment();
        productsFragment = new ProductsFragment();
        salesFragment = new SalesFragment();

        setSupportActionBar(mtoolbar);
        setFragment(customersFragment);




        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.nav_cus:
                        setFragment(customersFragment);
                        return true;

                    case R.id.nav_prod:
                        setFragment(productsFragment);
                        return true;

                    case R.id.nav_sale:
                        setFragment(salesFragment);
                        return true;
                }

                return false;
            }


        });

    }



    private void setFragment(Fragment fragment) {
        String fragmentTag = fragment.getTag();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame,fragment);
        fragmentTransaction.addToBackStack(fragmentTag);
        fragmentTransaction.commit();
    }
}
