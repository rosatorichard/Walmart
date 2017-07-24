package com.batchmates.android.walmartapp.injection.mainactivity;

import com.batchmates.android.walmartapp.view.activities.mainactivity.MainActivity;
import com.batchmates.android.walmartapp.view.activities.mainactivity.MainActivityPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Android on 7/22/2017.
 */
@Module
public class MainActivityModule {

    @Provides
    public MainActivityPresenter provideMainActivityPresenter()
    {
        return new MainActivityPresenter();
    }
}
