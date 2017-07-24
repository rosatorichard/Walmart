package com.batchmates.android.walmartapp.injection.mainactivity;

import com.batchmates.android.walmartapp.view.activities.mainactivity.MainActivity;

import dagger.Component;

/**
 * Created by Android on 7/22/2017.
 */
@Component(modules = MainActivityModule.class)
public interface MainActivityComponent {
    void inject(MainActivity mainActivity);
}
