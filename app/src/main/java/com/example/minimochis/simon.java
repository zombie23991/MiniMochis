package com.example.minimochis;


import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Random;

import pl.droidsonroids.gif.GifImageView;

public class simon  extends AppCompatActivity {
    //Interfaz
    private Button uno;
    private Button dos;
    private Button tres;
    private Button cuatro;
    private TextView punts,nivell;

    private FloatingActionButton volver, play;
    private GifImageView minimochi;
    private ImageView cartel;

    //Variables
    int nums[];
    int n= 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simon);
        //recogida de botones
        uno = findViewById(R.id.b1);
        dos = findViewById(R.id.b2);
        tres = findViewById(R.id.b3);
        cuatro = findViewById(R.id.b4);

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
                Intent intent = new Intent(String.valueOf(Jocs.class));
                startActivity(intent);
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newrandom();

            }
        });
    }

    public void newrandom(){
        Random random = new Random(); int i1 = (random.nextInt(4));
        nums[n] = 4;
        punts.setText(" "+ nums[n]);
        for(int i=0; i==n;i++){
            new CountDownTimer(3000, 1000) {

                public void onTick(long millisUntilFinished) {
                    color();
                }

                @Override
                public void onFinish() {
                    cartel.setImageResource(R.drawable.cartelnormal);
                }
            }.start();
        }
    }

    public void color(){
        minimochi.setImageResource(R.drawable.minimochi_rosa_punch);
        if (nums[n] == 1){
            cartel.setImageResource(R.drawable.cartelred);
        }else if (nums[n] == 2){
            cartel.setImageResource(R.drawable.cartelblue);
        }else if (nums[n] == 3){
            cartel.setImageResource(R.drawable.cartelyellow);
        }else if (nums[n] == 4){
            cartel.setImageResource(R.drawable.cartelgreen);
        }else {
            cartel.setImageResource(R.drawable.cartelnormal);
        }
    }


}
