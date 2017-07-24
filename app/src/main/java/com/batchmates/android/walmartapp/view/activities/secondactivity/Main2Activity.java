package com.batchmates.android.walmartapp.view.activities.secondactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.batchmates.android.walmartapp.R;
import com.batchmates.android.walmartapp.injection.secondactivity.DaggerSecondActivityComponent;
import com.batchmates.android.walmartapp.model.WalmartPojo;
import com.batchmates.android.walmartapp.model.secondactivitypojo.WalmartPojoSecondActivity;
import com.batchmates.android.walmartapp.view.activities.mainactivity.RecyclerViewAdapter;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main2Activity extends AppCompatActivity implements SecondActivityContract.View{

    private static final String TAG = "Second Activity";
    private RecyclerViewAdapter2 recycleViewAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private DefaultItemAnimator itemAnimator=new DefaultItemAnimator();
    ArrayList<? extends WalmartPojo> walmartPojo=new ArrayList<>();
    @Inject SecondActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        setUpDagger();
        presenter.addview(this);
        ButterKnife.bind(this);
        Log.d(TAG, "onCreate: "+getIntent().getIntExtra("ID",0));
//        presenter.getItem(getIntent().getIntExtra("ID",0));
        walmartPojo= getIntent().getParcelableArrayListExtra("POJO");
//        Log.d(TAG, "onCreate: "+walmartPojo.get(getIntent().getIntExtra("ID",0)).getLargeImage());
        layoutManager= new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recycleViewAdapter=new RecyclerViewAdapter2((List<WalmartPojo>) walmartPojo);
        recycleViewSecond.setLayoutManager(layoutManager);
        recycleViewSecond.setItemAnimator(itemAnimator);
        recycleViewSecond.setAdapter(recycleViewAdapter);
        recycleViewSecond.getLayoutManager().scrollToPosition(getIntent().getIntExtra("ID",0));
        SnapHelper snap=new LinearSnapHelper();
        snap.attachToRecyclerView(recycleViewSecond);
    }

    @BindView(R.id.rvSelectedItem)
    RecyclerView recycleViewSecond;

    private void setUpDagger() {
        DaggerSecondActivityComponent.create().inject(this);
    }

    @Override
    public void showError(String error) {

    }

}
