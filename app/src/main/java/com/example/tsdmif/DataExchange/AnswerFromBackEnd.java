package com.example.tsdmif.DataExchange;
import com.google.gson.JsonElement;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AnswerFromBackEnd {
    // ключ пользователя
    @SerializedName("guid1с")
    @Expose
    private String guid1с;
    // вид запускаемой активности
    @SerializedName("type")
    @Expose
    private String type;
    //имя пользователя
    @SerializedName("userName")
    @Expose
    private String userName;
    //данные для активности
    @SerializedName("data")
    @Expose
    private JsonElement data;

    public JsonElement getData(){ return data;}

    public String getGuid() {
        return guid1с;
    }

    public String getType() {
        return type;
    }

    public String getUserName() { return userName;}

    public void setGuid(String guid1с) {
        this.guid1с = guid1с;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setData(JsonElement data) {this.data = data;}

    public void setUserName(String userName){ this.userName=userName;}
}
