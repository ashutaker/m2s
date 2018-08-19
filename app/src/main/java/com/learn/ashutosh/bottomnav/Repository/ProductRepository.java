package com.learn.ashutosh.bottomnav.Repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.learn.ashutosh.bottomnav.DataModel.Product;
import com.learn.ashutosh.bottomnav.DataModelDao.DatabaseRoom;
import com.learn.ashutosh.bottomnav.DataModelDao.ProductDao;

import java.util.List;

public class ProductRepository {

    private ProductDao mProductDao;
    private LiveData<List<Product>> mAllProducts;

    public ProductRepository(Application application) {
        DatabaseRoom db = DatabaseRoom.getDatabase(application);

        mProductDao = db.productDao();
        mAllProducts = mProductDao.getAllProducts();
    }

    public LiveData<List<Product>> getAllProducts() {
        return mAllProducts;
    }

    public void insert(Product product){
        new insertAsyncTask(mProductDao).execute(product);
    }

    public static class insertAsyncTask extends AsyncTask<Product, Void, Void> {

        private ProductDao mAsyncDao;

        public insertAsyncTask(ProductDao dao) {
            mAsyncDao = dao;
        }

        @Override
        protected Void doInBackground(Product... products) {
            mAsyncDao.insert(products[0]);
            return null;
        }
    }


}
