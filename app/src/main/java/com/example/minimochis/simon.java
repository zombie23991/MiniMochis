package com.example.minimochis;


import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class simon  extends AppCompatActivity {
    //Interfaz
    private Button uno;
    private Button dos;
    private Button tres;
    private Button cuatro;
    private TextView punts,nivell;
    private FloatingActionButton

    //Variables

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simon);
        //recogida de botones
        uno = findViewById(R.id.b1);
        dos = findViewById(R.id.b2);
        tres = findViewById(R.id.b3);
        cuatro = findViewById(R.id.b4);
        //Text
        punts = findViewById(R.id.punts);
        nivell = findViewById(R.id.nivell);
        //recogida campos de texto
    }


}
