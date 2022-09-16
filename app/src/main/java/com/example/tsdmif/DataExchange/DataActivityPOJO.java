package com.example.tsdmif.DataExchange;

import com.google.gson.JsonElement;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataActivityPOJO {
    @SerializedName("frame1")
    @Expose
    public JsonElement frame1;

    @SerializedName("typeFrame1")
    @Expose
    public String typeFrame1;

    @SerializedName("frame2")
    @Expose
    public JsonElement frame2;

    @SerializedName("typeFrame2")
    @Expose
    public String typeFrame2;

    @SerializedName("frame3")
    @Expose
    public JsonElement frame3;

    @SerializedName("typeFrame3")
    @Expose
    public String typeFrame3;

    @SerializedName("scan")
    @Expose
    public boolean scan;
}
