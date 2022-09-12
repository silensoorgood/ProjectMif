package com.example.tsdmif;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tsdmif.DataExchange.AnswerFromBackEnd;
import com.example.tsdmif.DataExchange.AnswerInBackEnd;
import com.example.tsdmif.DataExchange.BackendManager;
import com.example.tsdmif.DataExchange.ServerConnector;

public class LoginActivity extends AppCompatActivity {
    BackendManager backendManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        backendManager=new BackendManager(getApplicationContext());

        Button settingsButton= findViewById(R.id.buttonSettings);
        settingsButton.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
            startActivity(intent);
        });

    }

    public void onClockButton(View view) {

        EditText pass= findViewById(R.id.editTextTextPassword);
        if (!pass.getText().toString().equals("")) {

            View bt=findViewById(R.id.button);
            bt.setClickable(false);

            SharedPreferences mSharedPref = getSharedPreferences("DataBack", MODE_PRIVATE);
            String guidAPP = mSharedPref.getString("guid", "");

            //Создаем и заполняем объект ответа
            AnswerInBackEnd a = new AnswerInBackEnd();
            a.setType("password");
            a.setGuid1с(guidAPP);
            a.setData(pass.getText().toString());

            ServerConnector connector = new ServerConnector() {
                @Override
                //описываем поведение при нестандартном ответе
                public void getData(AnswerFromBackEnd answer) {
                    if (answer.getType().equals("wrongPassword")) {
                        TextView textView = findViewById(R.id.textView);
                        textView.setText("неверный пароль");
                        bt.setClickable(true);
                    }
                }

                @Override
                public void exception(AnswerInBackEnd answer) {

                }
            };

            backendManager.getDataFromBack(a, this, connector);
        }
    }

    @Override
    public void onBackPressed() {
    }
}