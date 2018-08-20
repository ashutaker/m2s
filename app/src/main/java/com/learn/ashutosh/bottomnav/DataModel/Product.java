package com.learn.ashutosh.bottomnav.DataModel;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "product")
public class Product {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    private String productName;

    @NonNull
    private String productId;

    @NonNull
    private int quantity;

    @NonNull
    private int costPrice;

    @NonNull
    private int sellingPrice;

    public Product() {
    }

    //To manually initialize data
    @Ignore
    public Product(@NonNull String productName, @NonNull String productId, @NonNull int quantity, @NonNull int costPrice, @NonNull int sellingPrice) {
        this.productName = productName;
        this.productId = productId;
        this.quantity = quantity;
        this.costPrice = costPrice;
        this.sellingPrice = sellingPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getProductName() {
        return productName;
    }

    public void setProductName(@NonNull String productName) {
        this.productName = productName;
    }

    @NonNull
    public String getProductId() {
        return productId;
    }

    public void setProductId(@NonNull String productId) {
        this.productId = productId;
    }

    @NonNull
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(@NonNull int quantity) {
        this.quantity = quantity;
    }

    @NonNull
    public int getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(@NonNull int costPrice) {
        this.costPrice = costPrice;
    }

    @NonNull
    public int getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(@NonNull int sellingPrice) {
        this.sellingPrice = sellingPrice;
    }
}
