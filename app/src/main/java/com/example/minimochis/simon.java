package com.example.minimochis;


import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class simon  extends AppCompatActivity {
    //Interfaz
    private Button uno;
    private Button dos;
    private Button tres;
    private Button cuatro;
    private EditText simonInfo;
    private EditText jugadorInfo;

    //Variables
    public static int s = 3;
    public static int nivel = 1;
    int count = 0;
    int nivelActual = nivel-1;
    int inputCount = 0;
    int puntuacion = 0;
    int [] entradaCorrecta = new int[300];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simon);
        //recogida de botones
        uno = findViewById(R.id.b1);
        dos = findViewById(R.id.b2);
        tres = findViewById(R.id.b3);
        cuatro = findViewById(R.id.b4);
        //recogida campos de texto
        simonInfo = findViewById(R.id.simonInfo);
        jugadorInfo = findViewById(R.id.jugadorInfo);
    }


}
