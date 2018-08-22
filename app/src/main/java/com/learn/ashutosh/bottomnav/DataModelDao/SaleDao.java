package com.learn.ashutosh.bottomnav.DataModelDao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.learn.ashutosh.bottomnav.DataModel.Sale;

import java.util.List;

@Dao
public interface SaleDao {

    @Insert
    void insert(Sale sale);

    @Query("SELECT * from sale")
    LiveData<List<Sale>> getAllSale();


    @Query("DELETE FROM sale")
    void deleteAll();

}
