package com.learn.ashutosh.bottomnav.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.learn.ashutosh.bottomnav.DataModel.Customer;
import com.learn.ashutosh.bottomnav.Repository.CustomerRepository;

import java.util.List;

public class CustomerViewModel extends AndroidViewModel {

    private CustomerRepository mRepository;


    //To cache list of customers
    private LiveData<List<Customer>> mAllCustomers;

    public CustomerViewModel(@NonNull Application application) {
        super(application);

        mRepository = new CustomerRepository(application);
        mAllCustomers = mRepository.getAllCustomers();

    }

    public LiveData<List<Customer>> getAllCustomers() {
        return mAllCustomers;
    }

    public void insert(Customer customer) {
        mRepository.insert(customer);
    }


}
