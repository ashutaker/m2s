package com.learn.ashutosh.bottomnav;


import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.learn.ashutosh.bottomnav.DataModel.Customer;
import com.learn.ashutosh.bottomnav.ViewModel.CustomerViewModel;

import java.util.List;

import static android.app.Activity.RESULT_OK;


/**
 * A simple {@link Fragment} subclass.
 */
public class CustomersFragment extends Fragment {

    private static final String TAG = "CustomersFragment";
    private CustomerViewModel mCustomerViewModel;
    public static final int NEW_CUSTOMER_ACTIVITY_REQUEST_CODE = 1;

    public CustomersFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);

        mCustomerViewModel = ViewModelProviders.of((FragmentActivity) getActivity()).get(CustomerViewModel.class);
        View rootView = inflater.inflate(R.layout.fragment_customers, container, false);
        RecyclerView recyclerView = rootView.findViewById(R.id.cust_recycler);

        final CustomerListAdapter adapter = new CustomerListAdapter(getActivity());
        mCustomerViewModel.getAllCustomers().observe((LifecycleOwner) getActivity(), new Observer<List<Customer>>() {
            @Override
            public void onChanged(@Nullable List<Customer> customers) {
                adapter.setCustomer(customers);
            }
        });

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return rootView;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == NEW_CUSTOMER_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            String[] newCustomer = data.getStringArrayExtra(AddCustomerActivity.ADD_CUST_REPLY);
            if (newCustomer != null) {
                Customer customer = new Customer(newCustomer[0], newCustomer[1], newCustomer[2], newCustomer[3]);
                Log.i(TAG, "onActivityResult: " + newCustomer);
                mCustomerViewModel.insert(customer);
            } else {
                Log.i(TAG, "No data received");
            }
        } else {
            Toast.makeText(
                    getActivity(),
                    "Customer not saved !!",
                    Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_cust, menu);

        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.add_cust) {
            startActivityForResult(new Intent(getActivity(), AddCustomerActivity.class),
                    NEW_CUSTOMER_ACTIVITY_REQUEST_CODE);
        }
        return super.onOptionsItemSelected(item);
    }
}
