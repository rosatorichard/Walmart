package com.batchmates.android.walmartapp;

/**
 * Created by Android on 7/22/2017.
 */

public interface BasePresenter <V extends BaseView>{

    void addview(V view);

    void removeView();

}
