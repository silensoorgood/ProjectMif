package com.example.tsdmif;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tsdmif.JsonParse.Args;
import com.example.tsdmif.list.Adapter;
import com.example.tsdmif.list.ListAdapter;
import com.example.tsdmif.list.ListViewModel;

import org.json.JSONException;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    ArrayList<ListViewModel> models = new ArrayList<>();

    String[][] row;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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

        Adapter adapter = new Adapter() {
            @Override
            public void click() {

                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(intent);

            }
        };
        ListAdapter adapter1 = new ListAdapter(this, models,adapter);

        // устанавливаем для списка адаптер
        recyclerView.setAdapter(adapter1);
    }



    private void setInitialDataColumn2() {

        for (int i = 0; i < row.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            if (row[i].length > 1) {
                for (int j = 0; j < row[i].length; j++) {
                    stringBuilder.append(row[i][j] + " ");
                }
                String[] split = stringBuilder.toString().trim().split(" +");
                models.add(new ListViewModel(split[0], split[1]));
            } else {
                models.add(new ListViewModel("нуль", row[i][0]));

            }
        }
    }
}