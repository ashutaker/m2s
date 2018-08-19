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

public class CustomerListAdapter extends RecyclerView.Adapter<CustomerListAdapter.CustomerViewHolder> {
    private final LayoutInflater mInflater;

    private List<Customer> mCustomerList;

    CustomerListAdapter(Context context){ mInflater = LayoutInflater.from(context); }

    @NonNull
    @Override
    public CustomerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.customer_list_item,parent,false);
        return new CustomerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerViewHolder holder, int position) {
        if(mCustomerList!= null){
            Customer current = mCustomerList.get(position);
            holder.customerName.setText(current.getCustomerName());
        }else {
            holder.customerName.setText("No customer added !!");
        }

    }

    @Override
    public int getItemCount() {
        if(mCustomerList != null){
            return mCustomerList.size();
        }else { return 0;}
    }

    void setCustomer(List<Customer> customer){
        mCustomerList = customer;
        notifyDataSetChanged();
    }

    //Bind View for the customer list item here
    class CustomerViewHolder extends RecyclerView.ViewHolder{

        private final TextView customerName;
        private CustomerViewHolder(View itemView){
            super(itemView);
            customerName = itemView.findViewById(R.id.item_cust_name);
        }

    }




}
