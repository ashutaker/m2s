package com.learn.ashutosh.bottomnav.Repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.RoomDatabase;
import android.os.AsyncTask;

import com.learn.ashutosh.bottomnav.DataModel.Customer;
import com.learn.ashutosh.bottomnav.DataModelDao.CustomerDao;
import com.learn.ashutosh.bottomnav.DataModelDao.DatabaseRoom;

import java.util.List;

public class CustomerRepository {

    private CustomerDao mCustomerDao;
    private LiveData<List<Customer>> mAllCustomers;

    public CustomerRepository(Application application){
        DatabaseRoom db = DatabaseRoom.getDatabase(application);

        mCustomerDao = db.customerDao();
        mAllCustomers = mCustomerDao.getAllCustomers();
    }

    public LiveData<List<Customer>> getAllCustomers(){
        return mAllCustomers;
    }

    public void insert (Customer customer){
        new insertAsyncTask(mCustomerDao).execute(customer);
    }

    private static class insertAsyncTask extends AsyncTask<Customer, Void,Void>{
        private CustomerDao mAsyncTaskDao;

        insertAsyncTask(CustomerDao dao){
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Customer... customers) {
            mAsyncTaskDao.insert(customers[0]);
            return null;
        }
    }
}
