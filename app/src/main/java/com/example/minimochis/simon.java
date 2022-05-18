package com.example.minimochis;


import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
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
    private TextView punts,nivell;

    private FloatingActionButton volver, play;
    private GifImageView minimochi;
    private ImageView cartel;

    public ArrayList<Integer> miArreglo = new ArrayList<Integer>();

    //Variables
    int pas= 0;
    int torn = 0;
    int jugacorclick;
    int puntstotal=0;
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
                newrandom();
                viu = true;
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (viu == true){
                jugacorclick = 1;
                comprobar();} else {
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
                if (viu == true){
                    jugacorclick = 2;
                    comprobar();} else {
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
                if (viu == true){
                    jugacorclick = 3;
                    comprobar();} else {
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
                if (viu == true){
                    jugacorclick = 4;
                    comprobar();} else {
                    Toast toast1 =
                            Toast.makeText(getApplicationContext(),
                                    "Per jugar donali al boto PLAY", Toast.LENGTH_SHORT);

                    toast1.show();
                }
            }
        });

    }

    public void lvl() {
        if (torn == pas) {
            pas++;
            newrandom();
        } else if(torn != pas){
            torn++;

        }
    }

    public void newrandom(){
        int n;
        Random random = new Random(); int i1 = random.nextInt(4 - 1)+1;;
        miArreglo.add(i1);
        nivell.setText(" "+ (pas));
        color();
    }

    public void color(){
        for(int secuencia = 0; secuencia == pas; secuencia++) {
            punch();
            if (miArreglo.get(secuencia) == 1) {
                cartel.setImageResource(R.drawable.cartelred);
            } else if (miArreglo.get(secuencia) == 2) {
                cartel.setImageResource(R.drawable.cartelblue);
            } else if (miArreglo.get(secuencia) == 3) {
                cartel.setImageResource(R.drawable.cartelyellow);
            } else if (miArreglo.get(secuencia) == 4) {
                cartel.setImageResource(R.drawable.cartelgreen);
            } else {
                cartel.setImageResource(R.drawable.cartelnormal);
            }
            new CountDownTimer(2000, 50) {

                public void onTick(long millisUntilFinished) {
                }

                public void onFinish() {
                    cartel.setImageResource(R.drawable.cartelnormal);
                }
            }.start();
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

            if (jugacorclick == miArreglo.get(torn)) {
                puntstotal++;
                punts.setText(" "+ puntstotal);
                lvl();
            } else if (jugacorclick != miArreglo.get(torn)){
                gameover();
            }

        pas++;
        newrandom();
    }

    public void gameover(){
        viu = false;
        nivell.setText("Fail");
    }

}