package com.example.tsdmif.DataExchange;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AnswerInBackEndData {
    @SerializedName("event")
    @Expose
    private String event="";

    @SerializedName("dataEvent")
    @Expose
    private String dataevent="";

    @SerializedName("idFrame")
    @Expose
    private String idFrame="";

    public String getDataevent() {
        return dataevent;
    }

    public String getEvent() {
        return event;
    }

    public String getIdFrame() {
        return idFrame;
    }

    public void setDataevent(String dataevent) {
        this.dataevent = dataevent;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public void setIdFrame(String idFrame) {
        this.idFrame = idFrame;
    }
}

