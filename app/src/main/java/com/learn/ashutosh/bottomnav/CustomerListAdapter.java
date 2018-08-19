package com.learn.ashutosh.bottomnav;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.learn.ashutosh.bottomnav.DataModel.Customer;

import java.util.List;

class CustomerListAdapter extends RecyclerView.Adapter<CustomerListAdapter.ViewHolder> {

    private final LayoutInflater mInflater;
    private List<Customer> mCustomerList; // Cache copy of customer list

    public CustomerListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.customer_list_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        if (mCustomerList != null) {
            Customer selected = mCustomerList.get(position);
            holder.tvCustomerName.setText(selected.getCustomerName());
        }
    }

    @Override
    public int getItemCount() {
        if (mCustomerList != null) {
            return mCustomerList.size();
        } else return 0;
    }

    void setCustomer(List<Customer> customer) {
        mCustomerList = customer;
        notifyDataSetChanged();
    }

    //Binds View from the list item
    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvCustomerName;

        public ViewHolder(View itemView) {
            super(itemView);
            tvCustomerName = itemView.findViewById(R.id.item_cust_name);
        }
    }


}
