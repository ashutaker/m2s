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
import com.learn.ashutosh.bottomnav.DataModel.Product;
import com.learn.ashutosh.bottomnav.ViewModel.ProductViewModel;

import java.util.List;

import static android.app.Activity.RESULT_OK;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProductsFragment extends Fragment {

    public static final int NEW_PRODUCT_ACTIVITY_REQUEST_CODE = 1;
    private static final String TAG = "ProductsFragment";
    private ProductViewModel mProductViewModel;

    public ProductsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "Product Fragment created !!");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);

        mProductViewModel = ViewModelProviders.of((FragmentActivity) getActivity()).get(ProductViewModel.class);
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_products, container, false);
        RecyclerView recyclerView = rootView.findViewById(R.id.product_recycler);

        final ProductListAdapter productListAdapter = new ProductListAdapter(getActivity());
        mProductViewModel.getAllProducts().observe((LifecycleOwner) getActivity(), new Observer<List<Product>>() {
            @Override
            public void onChanged(@Nullable List<Product> products) {
                productListAdapter.setProducts(products);
            }
        });

        recyclerView.setAdapter(productListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        Log.i(TAG, "On create view");
        return rootView ;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_product,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.add_product){
            startActivityForResult(new Intent(getActivity(), AddProductActivity.class)
            ,NEW_PRODUCT_ACTIVITY_REQUEST_CODE);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == NEW_PRODUCT_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            String[] newProduct = data.getStringArrayExtra(AddCustomerActivity.ADD_CUST_REPLY);
            if (newProduct != null) {
                Product product = new Product(newProduct[0], newProduct[1], Integer.valueOf(newProduct[2]),
                        Integer.valueOf(newProduct[3]),
                        Integer.valueOf(newProduct[4]));
                Log.i(TAG, "onActivityResult: " + newProduct);
                mProductViewModel.insert(product);
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
}
