package com.example.minimochis;


import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Random;

import pl.droidsonroids.gif.GifImageView;

public class simon  extends AppCompatActivity {
    //Interfaz
    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private TextView punts, nivell;

    private FloatingActionButton volver, play;
    private GifImageView minimochi;
    private ImageView cartel;

    public ArrayList<Integer> miArreglo = new ArrayList<Integer>();
    public ArrayList<Integer> sequencia = new ArrayList<Integer>();

    //Variables
    int clickJugador, puntstotal = 0, posSequencia = 0, nNivell = 1;
    boolean viu = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simon);
        //recogida de botones
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);

        //gif i imatge
        minimochi = findViewById(R.id.minimochi);
        cartel = findViewById(R.id.cartel);

        //Floats
        volver = findViewById(R.id.volver);
        play = findViewById(R.id.play);

        //Text
        punts = findViewById(R.id.punts);
        nivell = findViewById(R.id.nivell);

        nivell.setText(String.valueOf(nNivell));

        minimochi.setImageResource(R.drawable.minimochirosa);

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(String.valueOf(Menu.class));
                startActivity(intent);
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viu = true;
                newrandom();
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (viu){
                    clickJugador = 1;
                    comprobar();
                } else {
                    Toast toast1 =
                            Toast.makeText(getApplicationContext(),
                                    "Per jugar donali al boto PLAY", Toast.LENGTH_SHORT);
                    toast1.show();
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (viu){
                    clickJugador = 2;
                    comprobar();
                } else {
                    Toast toast1 =
                            Toast.makeText(getApplicationContext(),
                                    "Per jugar donali al boto PLAY", Toast.LENGTH_SHORT);

                    toast1.show();
                }
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (viu){
                    clickJugador = 3;
                    comprobar();
                } else {
                    Toast toast1 =
                            Toast.makeText(getApplicationContext(),
                                    "Per jugar donali al boto PLAY", Toast.LENGTH_SHORT);

                    toast1.show();
                }
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (viu){
                    clickJugador = 4;
                    comprobar();
                } else {
                    Toast toast1 =
                            Toast.makeText(getApplicationContext(),
                                    "Per jugar donali al boto PLAY", Toast.LENGTH_SHORT);

                    toast1.show();
                }
            }
        });

    }

    public void newrandom(){
        sequencia.clear();
        Random random = new Random();

        nivell.setText(String.valueOf(nNivell));

        for (int i = 0; i < nNivell; i++){
            int i1 = random.nextInt(4 - 1 + 1) + 1;
            sequencia.add(i1);
        }

        color();
    }

    public void color(){
        for(int secuencia : sequencia) {
            punch();
            if (secuencia == 1) {
                cartel.setImageResource(R.drawable.cartelred);
            } else if (secuencia == 2) {
                cartel.setImageResource(R.drawable.cartelblue);
            } else if (secuencia == 3) {
                cartel.setImageResource(R.drawable.cartelyellow);
            } else if (secuencia == 4) {
                cartel.setImageResource(R.drawable.cartelgreen);
            }

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Do something after 1s = 1000ms
                    cartel.setImageResource(R.drawable.cartelnormal);
                }
            }, 1000);
        }
    }

    public void punch(){
        minimochi.setImageResource(R.drawable.minimochi_rosa_punch);
        new CountDownTimer( 1000, 50 ) {

            public void onTick(long millisUntilFinished) {
            }
            public void onFinish() {
                minimochi.setImageResource(R.drawable.minimochirosa);
            }
        }.start();
    }

    public void comprobar(){
        if(posSequencia < sequencia.size()) {
            if (clickJugador == sequencia.get(posSequencia)) {
                puntstotal++;
                punts.setText(String.valueOf(puntstotal));
                posSequencia++;
            } else {
                gameover();
            }
        }

        if(posSequencia >= sequencia.size()) {
            nNivell++;
            posSequencia = 0;
            newrandom();
        }

    }

    public void gameover(){
        viu = false;
        nivell.setText(String.valueOf(0));
        posSequencia = 0;
        sequencia.clear();
        clickJugador = 0;
        nNivell = 1;
        punts.setText(String.valueOf(0));;
    }

}
