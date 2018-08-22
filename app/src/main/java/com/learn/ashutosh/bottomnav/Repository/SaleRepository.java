package com.learn.ashutosh.bottomnav.Repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.content.Context;

import com.learn.ashutosh.bottomnav.DataModel.Sale;
import com.learn.ashutosh.bottomnav.DataModelDao.DatabaseRoom;
import com.learn.ashutosh.bottomnav.DataModelDao.SaleDao;

import java.util.List;

public class SaleRepository {

    private SaleDao mSaleDao;
    private LiveData<List<Sale>> mAllSales; //cache of all sales so far

    public SaleRepository(Application application) {
        DatabaseRoom db = DatabaseRoom.getDatabase(application);

        mSaleDao = db.saleDao();
        mAllSales = mSaleDao.getAllSale();
    }
}
