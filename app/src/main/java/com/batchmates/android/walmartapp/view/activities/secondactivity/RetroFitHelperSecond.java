package com.batchmates.android.walmartapp.view.activities.secondactivity;

import com.batchmates.android.walmartapp.model.WalmartHelper;
import com.batchmates.android.walmartapp.model.type.WalmartTypeHelper;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Android on 7/22/2017.
 */

public class RetroFitHelperSecond {

    private static final String BASE_URL="http://api.walmartlabs.com/";
    private static final String API_KEY="m8j54cudua678by57brj7etn";
    private static String ITEMS="12417832,19336123";
    private static String TYPE="ipod";
    private static final String TAG = "RetrofitHelper";


    public static Retrofit Create()
    {
        Retrofit retro= new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retro;
    }


    public static Call<WalmartHelper> getList(int item)
    {
        ITEMS=String.valueOf(item);
        Retrofit retrofit = Create();
        items items=retrofit.create(RetroFitHelperSecond.items.class);
        return items.thisList(API_KEY,ITEMS);
//        Log.d(TAG, "getList: Started To get page");
//        return items.thispage(API_KEY);
    }


    public static Call<WalmartHelper> getListType(String type)
    {
        Retrofit retrofit = Create();
        TYPE=type;
        items items=retrofit.create(RetroFitHelperSecond.items.class);
        return items.thisType(API_KEY,TYPE);
    }

    public static Call<WalmartTypeHelper> getListTypeHelper()
    {
        Retrofit retrofit = Create();
        items items=retrofit.create(RetroFitHelperSecond.items.class);
        return items.thisTypeHelper(API_KEY,TYPE);
    }


    public interface items
    {
        @GET("v1/items")
        Call<WalmartHelper> thisList(@Query("apiKey") String key, @Query("ids") String ids);

        @GET("/v1/search?&format=json")
        Call<WalmartHelper> thisType(@Query("apiKey") String key, @Query("query") String type);

        //isnt working
        @GET("/v1/search?&format=json")
        Call<WalmartTypeHelper> thisTypeHelper(@Query("apiKey") String key, @Query("query") String type);


        //m8j54cudua678by57brj7etn
        //2vnzk7j6stx5phbe8s7kt755
        @GET("/v1/paginated/items?format=json")
        Call<WalmartHelper> thispage(@Query("apiKey") String key);


    }


}
