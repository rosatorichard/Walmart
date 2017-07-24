package com.batchmates.android.walmartapp.view.activities.secondactivity;

import com.batchmates.android.walmartapp.BasePresenter;
import com.batchmates.android.walmartapp.BaseView;
import com.batchmates.android.walmartapp.model.WalmartPojo;
import com.batchmates.android.walmartapp.model.secondactivitypojo.WalmartPojoSecondActivity;

import java.util.List;

/**
 * Created by Android on 7/23/2017.
 */

public interface SecondActivityContract {

    interface View extends BaseView
    {
    }

    interface Presenter extends BasePresenter<View>
    {
    }


}
