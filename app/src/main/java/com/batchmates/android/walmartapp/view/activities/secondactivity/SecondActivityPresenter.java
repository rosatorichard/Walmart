package com.batchmates.android.walmartapp.view.activities.secondactivity;

import android.util.Log;

import com.batchmates.android.walmartapp.BaseView;
import com.batchmates.android.walmartapp.model.WalmartHelper;
import com.batchmates.android.walmartapp.model.secondactivitypojo.WalmartPojoSecondActivity;
import com.batchmates.android.walmartapp.view.activities.mainactivity.RetroFitHelper;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Android on 7/23/2017.
 */

public class SecondActivityPresenter implements SecondActivityContract.Presenter {

    private static final String TAG = "SecondActivityPresenter";
    SecondActivityContract.View view;
    List<WalmartPojoSecondActivity> walmartPojo=new ArrayList<>();

    @Override
    public void addview(SecondActivityContract.View view) {
        this.view=view;
    }

    @Override
    public void removeView() {
        this.view=null;
    }

}
