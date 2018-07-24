package com.learn.ashutosh.bottomnav.DataModelDao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.learn.ashutosh.bottomnav.DataModel.Customer;

import java.util.List;

@Dao
public interface CustomerDao {

    @Insert
    void insert(Customer customer);

    @Query("SELECT * from customer ORDER BY ASC")
    LiveData<List<Customer>> getAllCustomers();


}
