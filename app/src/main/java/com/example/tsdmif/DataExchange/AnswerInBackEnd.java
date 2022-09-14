package com.example.tsdmif.DataExchange;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AnswerInBackEnd {
    @SerializedName("type")
    @Expose
    private String type="";

    @SerializedName("guid1с")
    @Expose
    private String guid1с="";

    @SerializedName("data")
    @Expose
    private AnswerInBackEndData data;

    public  AnswerInBackEndData getData(){
        return data;
    }
    public String getguid1с() {
        return guid1с;
    }

    public String getType() {
        return type;
    }

    public void setGuid1с(String guid1с) {
        this.guid1с = guid1с;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setData(AnswerInBackEndData data){
        this.data=data;
    }

}
