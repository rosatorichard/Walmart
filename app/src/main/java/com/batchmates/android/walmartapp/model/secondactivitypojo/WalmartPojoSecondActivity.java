package com.batchmates.android.walmartapp.model.secondactivitypojo;

/**
 * Created by Android on 7/23/2017.
 */

public class WalmartPojoSecondActivity {

    String largeImage;
    String name;
    String discription;
    double price;
    String rating;


    public WalmartPojoSecondActivity(String largeImage, String name, String discription, double price, String rating) {
        this.largeImage = largeImage;
        this.name = name;
        this.discription = discription;
        this.price = price;
        this.rating=rating;
    }

    public String getRating() {
        return rating;
    }

    public String getLargeImage() {
        return largeImage;
    }

    public String getName() {
        return name;
    }

    public String getDiscription() {
        return discription;
    }

    public double getPrice() {
        return price;
    }
}
