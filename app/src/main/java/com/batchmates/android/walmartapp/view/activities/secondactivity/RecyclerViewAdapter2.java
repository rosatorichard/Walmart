package com.batchmates.android.walmartapp.view.activities.secondactivity;

import android.media.Image;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.batchmates.android.walmartapp.R;
import com.batchmates.android.walmartapp.model.WalmartPojo;
import com.batchmates.android.walmartapp.model.secondactivitypojo.WalmartPojoSecondActivity;
import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Android on 7/23/2017.
 */

public class RecyclerViewAdapter2 extends RecyclerView.Adapter<RecyclerViewAdapter2.ViewHolder>{

    List<WalmartPojo> walmartPojoSecondActivities= new ArrayList<>();

    public RecyclerViewAdapter2(List<WalmartPojo> walmartPojoSecondActivities) {
        this.walmartPojoSecondActivities = walmartPojoSecondActivities;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.selected_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        WalmartPojo walmartPojoSecondActivity=walmartPojoSecondActivities.get(position);
        Glide.with(holder.itemView.getContext()).load(walmartPojoSecondActivity.getLargeImage()).into(holder.imageView);
        holder.name.setText(walmartPojoSecondActivity.getName());
        holder.price.setText("$"+String.valueOf(walmartPojoSecondActivity.getPrice()));


        Log.d("Disc", "onBindViewHolder: "+walmartPojoSecondActivity.getDiscription());
        if(walmartPojoSecondActivity.getDiscription()==null)
        {
            holder.discription.setText("No Discription");
        }
        else {
            holder.discription.setText(walmartPojoSecondActivity.getDiscription());
            holder.discription.setMovementMethod(new ScrollingMovementMethod());
        }
        double stars=0;
        if(walmartPojoSecondActivity.getRating()!=null)
        {
            stars=Double.parseDouble(walmartPojoSecondActivity.getRating());
        }
        switch((int) stars)
        {
            case 1:
                Glide.with(holder.itemView.getContext()).load("https://upload.wikimedia.org/wikipedia/commons/d/dd/Star_rating_1_of_5.png").into(holder.stars);
                break;

            case 2:
                Glide.with(holder.itemView.getContext()).load("https://upload.wikimedia.org/wikipedia/commons/9/95/Star_rating_2_of_5.png").into(holder.stars);
                break;

            case 3:
                Glide.with(holder.itemView.getContext()).load("https://upload.wikimedia.org/wikipedia/commons/2/2f/Star_rating_3_of_5.png").into(holder.stars);
                break;

            case 4:
                Glide.with(holder.itemView.getContext()).load("https://upload.wikimedia.org/wikipedia/commons/f/fa/Star_rating_4_of_5.png").into(holder.stars);
                break;

            case 5:
                Glide.with(holder.itemView.getContext()).load("https://www.7boats.com/academy/wp-content/uploads/2017/02/Review-Stars.png").into(holder.stars);
                break;

            default:
                Glide.with(holder.itemView.getContext()).load("https://upload.wikimedia.org/wikipedia/commons/4/4a/Star_rating_0_of_5.png").into(holder.stars);
                break;
        }
    }
        //allows discription to scroll
//        holder.discription.setMovementMethod(new ScrollingMovementMethod());

    @Override
    public int getItemCount() {
        return walmartPojoSecondActivities.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name;
        TextView price;
        TextView discription;
        ImageView stars;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView=(ImageView)itemView.findViewById(R.id.ivItemImage);
            name=(TextView)itemView.findViewById(R.id.tvItemName);
            price=(TextView)itemView.findViewById(R.id.tvItemPrice);
            discription=(TextView)itemView.findViewById(R.id.tvItemDiscription);
            stars=(ImageView)itemView.findViewById(R.id.ivItemStarImage);
        }
    }
}
