package com.example.tsdmif;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.tsdmif.BarCodeScanner.CameraFragment;

public class DataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        Button b = findViewById(R.id.button2);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Fragment camera = new CameraFragment();
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.fragment2,camera).commit();
            }
        });

    }
}