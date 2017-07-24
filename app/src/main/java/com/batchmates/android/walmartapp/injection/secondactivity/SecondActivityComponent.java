package com.batchmates.android.walmartapp.injection.secondactivity;

import com.batchmates.android.walmartapp.view.activities.secondactivity.Main2Activity;

import dagger.Component;

/**
 * Created by Android on 7/23/2017.
 */
@Component(modules = SecondActivityModule.class)
public interface SecondActivityComponent {

    void inject(Main2Activity main2Activity);
}
