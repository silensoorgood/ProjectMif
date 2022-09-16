package com.example.tsdmif;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tsdmif.DataExchange.AnswerFromBackEnd;
import com.example.tsdmif.DataExchange.AnswerInBackEnd;
import com.example.tsdmif.DataExchange.AnswerInBackEndData;
import com.example.tsdmif.DataExchange.BackendManager;
import com.example.tsdmif.DataExchange.DataActivityPOJO;
import com.example.tsdmif.DataExchange.ListFramePOJO;
import com.example.tsdmif.DataExchange.ServerConnector;
import com.example.tsdmif.JsonParse.Args;
import com.example.tsdmif.list.ListItemCallBack;
import com.example.tsdmif.list.ListAdapter;
import com.example.tsdmif.list.ListViewModel;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    BackendManager backendManager;
    ArrayList<ListViewModel> models = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        backendManager= new BackendManager(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        //Получаем данные в переменной data данные для разбора в таблицу
        Bundle arguments = getIntent().getExtras();
        DataActivityPOJO data= new Gson().fromJson(arguments.get("data").toString(), DataActivityPOJO.class);
        if (data.typeFrame1==null){

        }else{
        switch (data.typeFrame1){
            case "frameList":
                CreateList(data.frame1,1);
                break;
            case "frameType1":
                break;
            case "frameType2":

        }}

        if (data.typeFrame2==null){

        }else{
        switch (data.typeFrame2){
            case "frameList":
                CreateList(data.frame2,2);
                break;
            case "frameType1":
                break;
            case "frameType2":

        }}

        if (data.typeFrame3==null){

        }else{
        switch (data.typeFrame3){
            case "frameList":
                CreateList(data.frame3,3);
                break;
            case "frameType1":
                break;
            case "frameType2":

        }}


    }

    public void CreateList(JsonElement jsonList, int numberFrame){
        ListFramePOJO data= new Gson().fromJson(jsonList.toString(), ListFramePOJO.class);
        if (data.update) {
            RecyclerView recyclerView = findViewById(R.id.list);
            // создаем адаптер

            ListItemCallBack listItemCallBack = position -> {

                AnswerInBackEnd answer = new AnswerInBackEnd();
                answer.setType("event");
                JSONObject j = new JSONObject();
                AnswerInBackEndData answerData = new AnswerInBackEndData();
                answerData.setEvent("TablePositionClick");
                answerData.setDataevent(position.toString());
                answer.setData(answerData);
                ServerConnector connector = new ServerConnector() {
                    @Override
                    public void getData(AnswerFromBackEnd answer) {

                    }

                    @Override
                    public void exception(AnswerInBackEnd answer) {

                    }
                };
                backendManager.getDataFromBack(answer, getActivti(), connector);
                Toast.makeText(ListActivity.this,
                        position.toString(), Toast.LENGTH_LONG).show();

            };
            ListAdapter adapter1 = new ListAdapter(this, data, listItemCallBack);

            // устанавливаем для списка адаптер
            recyclerView.setAdapter(adapter1);
        }
    }

    private  ListActivity getActivti( ){
        return this;
    }

}