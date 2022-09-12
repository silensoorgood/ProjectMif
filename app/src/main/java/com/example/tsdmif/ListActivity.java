package com.example.tsdmif;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tsdmif.list.ListAdapter;
import com.example.tsdmif.list.ListViewModel;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    ArrayList<ListViewModel> models = new ArrayList<ListViewModel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        //Получаем данные в переменной data данные для разбора в таблицу
        Bundle arguments = getIntent().getExtras();
        String data = arguments.get("data").toString();


        setInitialData();
        RecyclerView recyclerView = findViewById(R.id.list);
        // создаем адаптер
        ListAdapter adapter = new ListAdapter(this, models);
        // устанавливаем для списка адаптер
        recyclerView.setAdapter(adapter);
    }

    private void setInitialData() {


        models.add(new ListViewModel("0 из 2", "Компфыааыфыафыаф ", "3"));
        models.add(new ListViewModel("44 из 55", "Монитор, хуевый", "1"));
        models.add(new ListViewModel("0 из 2", "Моноблок, ебаный", "3"));
        models.add(new ListViewModel("0 из 2", "Компфыааыфыафыаф ", "3"));
        models.add(new ListViewModel("0 из 5", "Монитор, хуевый", "1"));
        models.add(new ListViewModel("0 из 2", "Моноблок, ебаный", "3"));
        models.add(new ListViewModel("0 из 2", "Компфыааыфыафыаф ", "3"));
        models.add(new ListViewModel("0 из 2", "Компфыааыфыафыаф ", "3"));
        models.add(new ListViewModel("0 из 5", "Монитор, хуевый", "1"));
        models.add(new ListViewModel("0 из 2", "Моноблок, ебаный", "3"));
        models.add(new ListViewModel("0 из 2", "Компфыааыфыафыаф ", "3"));
        models.add(new ListViewModel("0 из 5", "Монитор, хуевый", "1"));
        models.add(new ListViewModel("0 из 2", "Моноблок, ебаный", "3"));
        models.add(new ListViewModel("0 из 2", "Компфыааыфыафыаф ", "3"));
        models.add(new ListViewModel("0 из 5", "Монитор, хуевый", "1"));
        models.add(new ListViewModel("0 из 2", "Моноблок, ебаный", "3"));
        models.add(new ListViewModel("0 из 2", "Компфыааыфыафыаф ", "3"));
        models.add(new ListViewModel("0 из 5", "Монитор, хуевый", "1"));
        models.add(new ListViewModel("0 из 5", "Монитор, хуевый", "1"));
        models.add(new ListViewModel("0 из 2", "Моноблок, ебаный", "3"));
        models.add(new ListViewModel("0 из 2", "Компфыааыфыафыаф ", "3"));
        models.add(new ListViewModel("0 из 5", "Монитор, хуевый", "1"));
        models.add(new ListViewModel("0 из 2", "Моноблок, ебаный", "3"));
        models.add(new ListViewModel("0 из 2", "Компфыааыфыафыаф ", "3"));
        models.add(new ListViewModel("0 из 5", "Монитор, хуевый", "1"));
        models.add(new ListViewModel("0 из 2", "Моноблок, ебаный", "3"));
        models.add(new ListViewModel("0 из 2", "Компфыааыфыафыаф ", "3"));
        models.add(new ListViewModel("0 из 5", "Монитор, хуевый", "1"));
        models.add(new ListViewModel("0 из 2", "Моноблок, ебаный", "3"));


    }
}