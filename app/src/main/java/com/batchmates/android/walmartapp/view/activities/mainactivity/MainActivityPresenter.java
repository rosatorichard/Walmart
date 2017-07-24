package com.batchmates.android.walmartapp.view.activities.mainactivity;

import android.util.Log;

import com.batchmates.android.walmartapp.model.WalmartHelper;
import com.batchmates.android.walmartapp.model.WalmartPojo;
import com.batchmates.android.walmartapp.model.type.WalmartTypeHelper;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Android on 7/22/2017.
 */

public class MainActivityPresenter implements MainActivityContract.Presenter {

    private static final String TAG = "MainActivity Presenter";
    MainActivityContract.View view;
    List<WalmartPojo> walmartPojos=new ArrayList<>();

    public void addview(MainActivityContract.View view) {
        this.view=view;
    }

    @Override
    public void removeView() {
        this.view=null;

    }

    //getting items based on specific items listed
    @Override
    public void getNextList() {
        retrofit2.Call<WalmartHelper> returnList=RetroFitHelper.getList();
        returnList.enqueue(new Callback<WalmartHelper>() {
            @Override
            public void onResponse(Call<WalmartHelper> call, Response<WalmartHelper> response) {
                Log.d(TAG, "onResponse: responded using WalmartHelper");
                for (int i = 0; i <response.body().getItems().size() ; i++) {
                    Log.d(TAG, "onResponse: "+response.body().getItems().get(i).getLargeImage());

                }
            }

            @Override
            public void onFailure(Call<WalmartHelper> call, Throwable t) {

            }
        });
    }

    //getting type using WalmartHelper
    @Override
    public void getType(String type) {
        retrofit2.Call<WalmartHelper> itemType=RetroFitHelper.getListType(type);
        itemType.enqueue(new Callback<WalmartHelper>() {
            @Override
            public void onResponse(Call<WalmartHelper> call, Response<WalmartHelper> response) {
                Log.d(TAG, "onResponse: responded using WalmartHelper");
                double price=0;
                for (int i = 0; i <response.body().getItems().size() ; i++) {
                    if (response.body().getItems().get(i).getSalePrice()==null)
                    {
                        price=0.0;
                    }
                    else
                    {
                        price=response.body().getItems().get(i).getSalePrice();
                    }
                    walmartPojos.add(new WalmartPojo(response.body().getItems().get(i).getName()
                            ,response.body().getItems().get(i).getBrandName()
                            ,response.body().getItems().get(i).getShortDescription()
                            ,price
                            ,response.body().getItems().get(i).getModelNumber()
                            ,response.body().getItems().get(i).getItemId()
                            ,response.body().getItems().get(i).getLargeImage()
                            ,response.body().getItems().get(i).getCustomerRating()));
                    Log.d(TAG, "onResponse: "+response.body().getItems().get(i).getLargeImage());

                }
                view.itemsForRecycler(walmartPojos);
            }

            @Override
            public void onFailure(Call<WalmartHelper> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t.toString());
            }
        });
    }

    @Override
    public void fillRecycler() {

    }

    @Override
    public void useWalmartTypeHelper() {
        retrofit2.Call<WalmartTypeHelper> typeHelp=RetroFitHelper.getListTypeHelper();
        typeHelp.enqueue(new Callback<WalmartTypeHelper>() {
            @Override
            public void onResponse(Call<WalmartTypeHelper> call, Response<WalmartTypeHelper> response) {
                Log.d(TAG, "onResponse: Responded to WalmartTypeHelper");
                for (int i = 0; i <response.body().getItems().size() ; i++) {
                    Log.d(TAG, "onResponse: "+response.body().getItems().get(i).getName());

                }
            }

            @Override
            public void onFailure(Call<WalmartTypeHelper> call, Throwable t) {

            }
        });
    }
}
