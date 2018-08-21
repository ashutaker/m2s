package com.learn.ashutosh.bottomnav;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.learn.ashutosh.bottomnav.DataModel.Product;

import java.util.List;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ProductViewHolder> {

    private final LayoutInflater mInflater;
    private List<Product> mAllProducts;
    private static final String TAG = "ProductListAdapter";

    public ProductListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.product_item, parent, false);
        return new ProductViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {

        if (mAllProducts != null) {
            Product selected = mAllProducts.get(position);
            holder.cost.setText(String.valueOf(selected.getCostPrice()));
            holder.quantity.setText(String.valueOf(selected.getQuantity()));
            holder.prodId.setText(selected.getProductId());
            holder.prodName.setText(selected.getProductName());

            Log.d(TAG, "onBindViewHolder: " + String.valueOf(selected.getId()));
        }
    }

    @Override
    public int getItemCount() {
        if (mAllProducts != null) {
            return mAllProducts.size();
        } else {
            return 0;
        }
    }

    public void setProducts(List<Product> mAllProducts) {
        this.mAllProducts = mAllProducts;
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {

        private TextView prodName, prodId, quantity, cost;

        public ProductViewHolder(View itemView) {
            super(itemView);
            prodName = itemView.findViewById(R.id.item_prod_name);
            prodId = itemView.findViewById(R.id.item_product_id);
            quantity = itemView.findViewById(R.id.item_product_quantity);
            cost = itemView.findViewById(R.id.item_product_cost);
        }
    }
}
