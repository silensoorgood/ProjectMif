package com.example.tsdmif.DataExchange;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.webkit.URLUtil;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import com.example.tsdmif.ListActivity;
import com.example.tsdmif.LoginActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BackendManager {
    private Retrofit retrofit;
    private boolean statusRetrofit;

    public boolean getStatus() {
        return statusRetrofit;
    }

    public BackendManager(Context context) {
        String address = PreferenceManager.getDefaultSharedPreferences(context).getString("adressFromServer", "");

        statusRetrofit = URLUtil.isValidUrl(address);
        if (statusRetrofit) {
            retrofit = new Retrofit.Builder()
                    // .baseUrl(address)
                    .baseUrl(address)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
    }

    public void getDataFromBack(AnswerInBackEnd answerInBackEnd
            , AppCompatActivity activity
            , ServerConnector connector
    ) {
        if (statusRetrofit) {
            APIService apiService = retrofit.create(APIService.class);

            Call<AnswerFromBackEnd> call = apiService.getData(answerInBackEnd);

            call.enqueue(new Callback<AnswerFromBackEnd>() {
                @Override
                public void onResponse(Call<AnswerFromBackEnd> call, Response<AnswerFromBackEnd> response) {

                    AnswerFromBackEnd answer = response.body();
                    //Получить запись из настроек
                    SharedPreferences mSharedPref = activity.getSharedPreferences("DataBack", AppCompatActivity.MODE_PRIVATE);
                    String guidAPP = mSharedPref.getString("guid", "");
                    //--

                    if (guidAPP.equals("")) {
                        SharedPreferences.Editor editor = mSharedPref.edit();
                        editor.putString("guid", answer.getGuid());
                        editor.apply();
                        AnswerInBackEnd a = new AnswerInBackEnd();

                        String s = activity.getSharedPreferences("DataBack", AppCompatActivity.MODE_PRIVATE)
                                .getString("guid", "");
                        a.setGuid1с(s);
                        a.setType("start");
                        getDataFromBack(a, activity, connector);
                    }
                    if (answer.getType().equals("authorization")) {
                        Intent intent = new Intent(activity.getApplicationContext(), LoginActivity.class);
                        activity.startActivity(intent);
                        activity.finish();

                    } else if (answer.getType().equals("list")) {
                        Intent intent = new Intent(activity.getApplicationContext(), ListActivity.class);
                        intent.putExtra("data", answer.getData());
                        activity.startActivity(intent);
                        activity.finish();

                    } else {
                        connector.getData(answer);
                    }
                }

                @Override
                public void onFailure(Call<AnswerFromBackEnd> call, Throwable t) {
                    t.printStackTrace();
                }
            });
        }
    }
}
