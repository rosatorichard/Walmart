package com.batchmates.android.walmartapp.view.activities.mainactivity;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.batchmates.android.walmartapp.R;
import com.batchmates.android.walmartapp.injection.mainactivity.DaggerMainActivityComponent;
import com.batchmates.android.walmartapp.model.WalmartPojo;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View{

    @Inject MainActivityPresenter presenter;

    private RecyclerView.LayoutManager layoutManager;
    private DefaultItemAnimator itemAnimator=new DefaultItemAnimator();
    private RecyclerViewAdapter recyclerViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ButterKnife.bind(this);
        setUpDagger();
        presenter.addview(this);

//        presenter.getNextList();
//        presenter.getType();
//        presenter.useWalmartTypeHelper();
    }

    @BindView(R.id.tietWhatYouWant)
    TextInputEditText searchFor;

    @BindView(R.id.rvRecyclerList)
    RecyclerView recyclerView;


    private void setUpDagger() {
        DaggerMainActivityComponent.create().inject(this);
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void itemsForRecycler(List<WalmartPojo> walmartPojos) {

        recyclerViewAdapter=new RecyclerViewAdapter(walmartPojos);
        layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(itemAnimator);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    public void clickforType(View view) {
        presenter.getType(searchFor.getText().toString());
    }
}
