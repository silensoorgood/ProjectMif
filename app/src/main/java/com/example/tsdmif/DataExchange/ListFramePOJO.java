package com.example.tsdmif.DataExchange;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ListFramePOJO {
    @SerializedName("fontSize1")
    @Expose
    public int fontSize1;
    @SerializedName("fontSize2")
    @Expose
    public int fontSize2;
    @SerializedName("update")
    @Expose
    public boolean update;
    @SerializedName("data")
    @Expose
    public ArrayList<ArrayList<String>> data;

}
