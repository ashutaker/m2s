package com.learn.ashutosh.bottomnav.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.learn.ashutosh.bottomnav.DataModel.Product;
import com.learn.ashutosh.bottomnav.Repository.ProductRepository;

import java.util.List;

public class ProductViewModel extends AndroidViewModel {

    private LiveData<List<Product>> mAllProducts;
    private ProductRepository mRepository;


    public ProductViewModel(@NonNull Application application) {
        super(application);
        mRepository = new ProductRepository(application);
        mAllProducts = mRepository.getAllProducts();
    }

    public void insert(Product product){
        mRepository.insert(product);
    }

    public LiveData<List<Product>> getAllProducts() {
        return mAllProducts;
    }
}
