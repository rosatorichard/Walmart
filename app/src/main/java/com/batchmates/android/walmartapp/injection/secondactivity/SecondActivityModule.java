package com.batchmates.android.walmartapp.injection.secondactivity;

import com.batchmates.android.walmartapp.view.activities.secondactivity.SecondActivityPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Android on 7/23/2017.
 */
@Module
public class SecondActivityModule {

    @Provides
    public SecondActivityPresenter secondActivityPresenter()
    {
        return new SecondActivityPresenter();
    }
}
