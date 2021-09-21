package com.practica6_ecosistemas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button bnCenter, bnLeft, bnRight, bnUp, bnDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bnCenter = findViewById(R.id.bnCenter);
        bnLeft = findViewById(R.id.bnLeft);
        bnRight = findViewById(R.id.bnRight);
        bnUp = findViewById(R.id.bnUp);
        bnDown = findViewById(R.id.bnDown);
    }
}