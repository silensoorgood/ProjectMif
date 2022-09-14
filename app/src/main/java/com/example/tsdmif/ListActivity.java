package com.example.tsdmif;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tsdmif.DataExchange.AnswerFromBackEnd;
import com.example.tsdmif.DataExchange.AnswerInBackEnd;
import com.example.tsdmif.DataExchange.AnswerInBackEndData;
import com.example.tsdmif.DataExchange.BackendManager;
import com.example.tsdmif.DataExchange.ServerConnector;
import com.example.tsdmif.JsonParse.Args;
import com.example.tsdmif.list.ListItemCallBack;
import com.example.tsdmif.list.ListAdapter;
import com.example.tsdmif.list.ListViewModel;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    BackendManager backendManager;
    ArrayList<ListViewModel> models = new ArrayList<>();

    String[][] row;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        backendManager= new BackendManager(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        //Получаем данные в переменной data данные для разбора в таблицу
        Bundle arguments = getIntent().getExtras();
        try {
            Args args = new Args(arguments.get("data").toString());
            row = args.column2();
        } catch (JSONException e) {
            System.err.println("Ошибка в JSON");
        }

        setInitialDataColumn2();

        RecyclerView recyclerView = findViewById(R.id.list);
        // создаем адаптер

        ListItemCallBack listItemCallBack = position -> {

            AnswerInBackEnd answer= new AnswerInBackEnd();
            answer.setType("event");
            JSONObject j = new JSONObject();
            AnswerInBackEndData answerData= new AnswerInBackEndData();
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
            backendManager.getDataFromBack(answer,getActivti(),connector);
            Toast.makeText(ListActivity.this,
                    position.toString(), Toast.LENGTH_LONG).show();

        };
        ListAdapter adapter1 = new ListAdapter(this, models, listItemCallBack);

        // устанавливаем для списка адаптер
        recyclerView.setAdapter(adapter1);
    }
    private  ListActivity getActivti( ){
        return this;
    }

    private void setInitialDataColumn2() {

        for (int i = 0; i < row.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            if (row[i].length > 1) {
                for (int j = 0; j < row[i].length; j++) {
                    stringBuilder.append(row[i][j] + " >");
                }
                String[] split = stringBuilder.toString().trim().split(">+");
                models.add(new ListViewModel(split[0], split[1]));
            } else {
                models.add(new ListViewModel(null, row[i][0]));

            }
        }
    }
}