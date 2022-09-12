package com.example.tsdmif.DataExchange;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIService {
    @POST("TSD/hs/TSD")
    Call<AnswerFromBackEnd> getData(@Body AnswerInBackEnd answerInBack);
}