package com.learn.ashutosh.bottomnav.DataModel;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.Date;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "sale",
        foreignKeys = {@ForeignKey(entity = Customer.class,
                parentColumns = "id",
                childColumns = "customerId",
                onDelete = CASCADE),
                @ForeignKey(entity = Product.class,
                        parentColumns = "id",
                        childColumns = "productId",
                        onDelete = CASCADE)})

public class Sale {

   @PrimaryKey(autoGenerate = true)
    private int id;

    private int customerId;

    private int productId;

    private String shippingType;

    //private String AWB;

    private Date saleDate;

    private int sellingPrice;

    public Sale() {
    }

    @Ignore
    public Sale(int customerId, int productId, String shippingType, Date saleDate, int sellingPrice) {
        this.customerId = customerId;
        this.productId = productId;
        this.shippingType = shippingType;
        this.saleDate = saleDate;
        this.sellingPrice = sellingPrice;
    }
}
