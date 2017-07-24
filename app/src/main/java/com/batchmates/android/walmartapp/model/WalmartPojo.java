package com.batchmates.android.walmartapp.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Android on 7/23/2017.
 */

public class WalmartPojo implements Parcelable{

    String name;
    String brandName;
    String discription;
    double price;
    String modelNumber;
    int itemID;
    String largeImage;
    String rating;

    public WalmartPojo(String name, String brandName, String discription, double price, String modelNumber, int itemID,String largeImage,String rating) {
        this.name = name;
        this.brandName = brandName;
        this.discription = discription;
        this.price = price;
        this.modelNumber = modelNumber;
        this.itemID = itemID;
        this.largeImage=largeImage;
        this.rating=rating;
    }

    public String getLargeImage() {
        return largeImage;
    }

    public String getRating() {
        return rating;
    }

    protected WalmartPojo(Parcel in) {
        name = in.readString();
        brandName = in.readString();
        discription = in.readString();
        price = in.readDouble();
        modelNumber = in.readString();
        itemID = in.readInt();
        largeImage=in.readString();
        rating=in.readString();
    }

    public static final Creator<WalmartPojo> CREATOR = new Creator<WalmartPojo>() {
        @Override
        public WalmartPojo createFromParcel(Parcel in) {
            return new WalmartPojo(in);
        }

        @Override
        public WalmartPojo[] newArray(int size) {
            return new WalmartPojo[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getDiscription() {
        return discription;
    }

    public double getPrice() {
        return price;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public int getItemID() {
        return itemID;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(brandName);
        parcel.writeString(discription);
        parcel.writeDouble(price);
        parcel.writeString(modelNumber);
        parcel.writeInt(itemID);
        parcel.writeString(largeImage);
        parcel.writeString(rating);
    }

}
