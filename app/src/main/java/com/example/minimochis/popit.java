package com.example.minimochis;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Random;

import pl.droidsonroids.gif.GifImageView;

public class popit extends AppCompatActivity {

    //tots el colors del popit
    FloatingActionButton red1, red2, red3,
            orange1, orange2,
            yellow1, yellow2, yellow3,
            green1, green2,
            blue1, blue2, blue3;
    //Puntuacio
    TextView punts;
    //minimochis
    GifImageView minimochiOne, minimochiTwo, minimochiThree, fons;
    //Audio
    MediaPlayer mp;

    int n = 1;

    int random;

    Random aleatorio = new Random(System.currentTimeMillis());


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popit);

        //Definim tots els botons del popit
        //Vermell
        red1 = findViewById(R.id.red1);
        red2 = findViewById(R.id.red2);
        red3 = findViewById(R.id.red3);
        //Naranja
        orange1 = findViewById(R.id.orange1);
        orange2 = findViewById(R.id.orange2);
        //Groc
        yellow1 = findViewById(R.id.yellow1);
        yellow2 = findViewById(R.id.yellow2);
        yellow3 = findViewById(R.id.yellow3);
        //Verd
        green1 = findViewById(R.id.green1);
        green2 = findViewById(R.id.green2);
        //Blau
        blue1 = findViewById(R.id.blue1);
        blue2 = findViewById(R.id.blue2);
        blue3 = findViewById(R.id.blue3);

        //Puntuacio
        punts = findViewById(R.id.punts);

        //Gif Minimochi
        minimochiOne = findViewById(R.id.minimochiOne);
        minimochiTwo = findViewById(R.id.minimochiTwo);
        minimochiThree = findViewById(R.id.minimochiThree);
        //Gif fons
        fons = findViewById(R.id.fons);

        // Producir nuevo int aleatorio entre 0 y 12
        random = aleatorio.nextInt(13);

        minimochiOne.setImageResource(R.drawable.minimochirosa);
        minimochiTwo.setImageResource(R.drawable.minimochiblau);
        minimochiThree.setImageResource(R.drawable.minimochiblanc);




        //posem audio a la variable
        mp = MediaPlayer.create(this, R.raw.popit);
        //podem aleatori al boto
        topo();

        red1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dance();
                punts.setText(""+n);
                n++;
            }
        });

        red2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dance();
                punts.setText(""+n);
                n++;
            }
        });

        red3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dance();
                punts.setText(""+n);
                n++;
            }
        });

        orange1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dance();
                punts.setText(""+n);
                n++;
            }
        });

        orange2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dance();
                punts.setText(""+n);
                n++;
            }
        });

        yellow1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dance();
                punts.setText(""+n);
                n++;
            }
        });

        yellow2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dance();
                punts.setText(""+n);
                n++;
            }
        });

        yellow3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dance();
                punts.setText(""+n);
                n++;
            }
        });

        green1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dance();
                punts.setText(""+n);
                n++;
            }
        });

        green2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dance();
                punts.setText(""+n);
                n++;
            }
        });

        blue1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dance();
                punts.setText(""+n);
                n++;
            }
        });

        blue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dance();
                punts.setText(""+n);
                n++;
            }
        });

        blue3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dance();
                punts.setText(""+n);
                n++;
            }
        });

    }

    public void dance (){

        //Iniciem el audio
        mp.start();

        fons.setImageResource(R.drawable.fons);

        new CountDownTimer( 3000, 50 ) {

            public void onTick(long millisUntilFinished) {
            }
            public void onFinish() {
                fons.setImageResource(0);
            }
        }.start();

        minimochiOne.setImageResource(R.drawable.minimochirosadance);

        new CountDownTimer( 3000, 50 ) {

            public void onTick(long millisUntilFinished) {
            }
            public void onFinish() {
                minimochiOne.setImageResource(R.drawable.minimochirosa);
            }
        }.start();

        minimochiTwo.setImageResource(R.drawable.minimochiblaudance);

        new CountDownTimer( 3000, 50 ) {

            public void onTick(long millisUntilFinished) {
            }
            public void onFinish() {
                minimochiTwo.setImageResource(R.drawable.minimochiblau);
            }
        }.start();

        minimochiThree.setImageResource(R.drawable.minimochiblancdance);

        new CountDownTimer( 3000, 50 ) {

            public void onTick(long millisUntilFinished) {
            }
            public void onFinish() {
                minimochiThree.setImageResource(R.drawable.minimochiblanc);
            }
        }.start();


    }

    public void topo() {
        if (random == 0) {
            red1.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_close_24));
        } else if (random == 1){
            red2.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_close_24));
        }else if (random == 2){
            red2.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_close_24));
        } else if (random == 3){
            orange1.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_close_24));
        } else if (random == 4){
            orange2.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_close_24));
        } else if (random == 5){
            yellow1.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_close_24));
        }else if (random == 6){
            yellow2.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_close_24));
        }else if (random == 7){
            yellow3.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_close_24);
        }else if (random == 8){
            green1.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_close_24));
        }else if (random == 9){
            green2.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_close_24));
        }else if (random == 10){
            blue1.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_close_24));
        }else if (random == 11){
            blue2.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_close_24));
        }else if (random == 12){
            blue3.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_close_24));
        } else {
            punts.setText("ERR");
        }

        // Producir nuevo int aleatorio entre 0 y 12
        random = aleatorio.nextInt(13);
    }

    public void cert(){
        if ( red1.getBackground() != null) {
            dance();
            punts.setText(""+n);
            n++;
        }
    }
}
