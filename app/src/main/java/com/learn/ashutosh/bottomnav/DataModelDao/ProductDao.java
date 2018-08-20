package com.learn.ashutosh.bottomnav.DataModelDao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.learn.ashutosh.bottomnav.DataModel.Product;

import java.util.List;

@Dao
public interface ProductDao {

    @Insert
    void insert(Product product);

    @Query("SELECT * FROM product")
    LiveData<List<Product>> getAllProducts();

    @Query("DELETE FROM product")
    void deleteAll();
}
