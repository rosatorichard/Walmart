
package com.batchmates.android.walmartapp.model;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WalmartHelper implements Serializable
{

    @SerializedName("items")
    @Expose
    private List<Item> items = null;
    private final static long serialVersionUID = -8404113476921751794L;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

}
