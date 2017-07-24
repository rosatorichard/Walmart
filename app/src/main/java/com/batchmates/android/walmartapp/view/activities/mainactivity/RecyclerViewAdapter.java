package com.batchmates.android.walmartapp.view.activities.mainactivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.batchmates.android.walmartapp.R;
import com.batchmates.android.walmartapp.model.WalmartHelper;
import com.batchmates.android.walmartapp.model.WalmartPojo;
import com.batchmates.android.walmartapp.view.activities.secondactivity.Main2Activity;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Android on 7/23/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "Recycler Adapter";
    List<WalmartPojo> walmartPojos= new ArrayList<>();


    public RecyclerViewAdapter(List<WalmartPojo> walmartPojos) {
        this.walmartPojos = walmartPojos;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_of_all,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        final WalmartPojo walmartHelper=walmartPojos.get(position);
        Log.d(TAG, "onBindViewHolder2: "+walmartHelper.getLargeImage());
        holder.name.setText(walmartHelper.getName());
        holder.price.setText("$"+String.valueOf(walmartHelper.getPrice()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: "+walmartHelper.getName());
                Intent intent=new Intent(view.getContext(), Main2Activity.class);
                intent.putExtra("ID",position);
                intent.putParcelableArrayListExtra("POJO", (ArrayList<? extends Parcelable>) walmartPojos);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return walmartPojos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView price;
        public ViewHolder(View itemView) {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.tvNameOfItem);
            price=(TextView)itemView.findViewById(R.id.tvPriceOfItem);
        }
    }
}
