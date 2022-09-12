package com.example.tsdmif;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tsdmif.DataExchange.AnswerFromBackEnd;
import com.example.tsdmif.DataExchange.AnswerInBackEnd;
import com.example.tsdmif.DataExchange.BackendManager;
import com.example.tsdmif.DataExchange.ServerConnector;


public class MainActivity extends AppCompatActivity {
    BackendManager backendManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button settingsButton = findViewById(R.id.buttonSettings);
        settingsButton.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
            startActivity(intent);
        });

        //Intent intentData = new Intent(getApplicationContext(), DataActivity.class);
        //startActivity(intentData);
        connectToServer();
    }

    private void connectToServer() {

        String s = getSharedPreferences("DataBack", MODE_PRIVATE)
                .getString("guid", "");
        AnswerInBackEnd a = new AnswerInBackEnd();
        a.setGuid1с(s);
        a.setType("start");

        //обработчик ответа от сервера
        ServerConnector connector = new ServerConnector() {
            @Override
            //описываем поведение при нестандартном ответе
            public void getData(AnswerFromBackEnd answer) {
                if (answer.getType().equals("wrongPassword")) {

                }
            }

            @Override
            public void exception(AnswerInBackEnd answer) {

            }
        };
        //--

        backendManager = new BackendManager(getApplicationContext()); //создаем новое подключение к серверу
        backendManager.getDataFromBack(a, this, connector);
    }
}
