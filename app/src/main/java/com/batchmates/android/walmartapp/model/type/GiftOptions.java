
package com.batchmates.android.walmartapp.model.type;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GiftOptions implements Serializable
{

    @SerializedName("allowGiftWrap")
    @Expose
    private Boolean allowGiftWrap;
    @SerializedName("allowGiftMessage")
    @Expose
    private Boolean allowGiftMessage;
    @SerializedName("allowGiftReceipt")
    @Expose
    private Boolean allowGiftReceipt;
    private final static long serialVersionUID = 8002592223960815287L;

    public Boolean getAllowGiftWrap() {
        return allowGiftWrap;
    }

    public void setAllowGiftWrap(Boolean allowGiftWrap) {
        this.allowGiftWrap = allowGiftWrap;
    }

    public Boolean getAllowGiftMessage() {
        return allowGiftMessage;
    }

    public void setAllowGiftMessage(Boolean allowGiftMessage) {
        this.allowGiftMessage = allowGiftMessage;
    }

    public Boolean getAllowGiftReceipt() {
        return allowGiftReceipt;
    }

    public void setAllowGiftReceipt(Boolean allowGiftReceipt) {
        this.allowGiftReceipt = allowGiftReceipt;
    }

}
