package com.batchmates.android.walmartapp.view.activities.mainactivity;

import android.view.View;

import com.batchmates.android.walmartapp.BasePresenter;
import com.batchmates.android.walmartapp.BaseView;
import com.batchmates.android.walmartapp.model.WalmartPojo;

import java.util.List;

/**
 * Created by Android on 7/22/2017.
 */

public interface MainActivityContract {

    interface View extends BaseView
    {
        void itemsForRecycler(List<WalmartPojo> walmartPojos);
    }

    interface Presenter extends BasePresenter<View>
    {
        void getNextList();
        void getType(String type);
        void fillRecycler();
        void useWalmartTypeHelper();
    }
}
