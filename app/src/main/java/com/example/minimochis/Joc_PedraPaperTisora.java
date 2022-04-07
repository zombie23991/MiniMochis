package com.example.minimochis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Joc_PedraPaperTisora extends AppCompatActivity {

    String nom_jugador = "";
    int datoJugador = 0;
    int datoComputer = 0;
    private TextView tv_nom_jugador;
    int scoreJugador;
    int scoreComputer;

    private ImageView dataJugador;
    private ImageView dataComputer;
    private TextView tv_scoreJugador;
    private TextView tv_scoreComputer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joc_pedra_paper_tisora);
        try {
            //obtener nombre jugador del activity login
            nom_jugador = getIntent().getStringExtra("jugador");

            this.tv_nom_jugador = findViewById(R.id.NombreJugador);
            tv_nom_jugador.setText(nom_jugador);

            //casteo
            this.dataJugador = findViewById(R.id.DataJugador);
            this.dataComputer = findViewById(R.id.DataComputer);
            this.tv_scoreJugador = findViewById(R.id.ScoreJugador);
            this.tv_scoreComputer = findViewById(R.id.ScoreComputer);
        } catch (Exception e) {
            Toast.makeText(this, "Error 1 " + e, Toast.LENGTH_LONG).show();
        }

    }

    public void onClick(View view) {

        if (view.getId() == R.id.BtnSalir) {
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);
            finish();
        } else if (view.getId() == R.id.Piedra) {
            datoJugador = 1;
            AleatorioDataComputer();
        } else if (view.getId() == R.id.Papel) {
            datoJugador = 2;
            AleatorioDataComputer();
        } else if (view.getId() == R.id.Tijera) {
            datoJugador = 3;
            AleatorioDataComputer();
        }
    }

    //metodo dato jugador
    public void ResultatJugador() {
        if (datoJugador == 1) {
            dataJugador.setImageResource(R.drawable.piedra);
        } else if (datoJugador == 2) {
            dataJugador.setImageResource(R.drawable.papel);
        } else if (datoJugador == 3) {
            dataJugador.setImageResource(R.drawable.tijera);
        }

        Resultado();
    }

    public void AleatorioDataComputer() {
        //clase Aleatorio
        int num_aleatori = (int) (Math.random() * 3);
        num_aleatori = num_aleatori + 1;
        if (num_aleatori == 1) {
            dataComputer.setImageResource(R.drawable.piedra2);
            datoComputer = 1;
        } else if (num_aleatori == 2) {
            dataComputer.setImageResource(R.drawable.papel2);
            datoComputer = 2;
        } else if (num_aleatori == 3) {
            dataComputer.setImageResource(R.drawable.tijera2);
            datoComputer = 3;
        }
        ResultatJugador();
    }

    //compara quien gana
    public void Resultado() {
        try {

            if (datoJugador == datoComputer) {
                Toast.makeText(this, "Empate", Toast.LENGTH_SHORT).show();
            } else if (datoJugador == 1 && datoComputer == 2) {
                scoreComputer++;
                tv_scoreComputer.setText("Score: " + String.valueOf(scoreComputer));
            } else if (datoJugador == 1 && datoComputer == 3) {
                scoreJugador++;
                tv_scoreJugador.setText("Score: " + String.valueOf(scoreJugador));
            } else if (datoJugador == 2 && datoComputer == 3) {
                scoreComputer++;
                tv_scoreComputer.setText("Score: " + String.valueOf(scoreComputer));
            } else if (datoJugador == 2 && datoComputer == 1) {
                scoreJugador++;
                tv_scoreJugador.setText("Score: " + String.valueOf(scoreJugador));
            } else if (datoJugador == 3 && datoComputer == 1) {
                scoreComputer++;
                tv_scoreComputer.setText("Score: " + String.valueOf(scoreComputer));
            } else if (datoJugador == 3 && datoComputer == 2) {
                scoreJugador++;
                tv_scoreJugador.setText("Score: " + String.valueOf(scoreJugador));
            }

            Final_del_Joc();

        } catch (Exception e) {
            Toast.makeText(this, "Error en: " + e, Toast.LENGTH_LONG).show();
        }


    }

    public void Final_del_Joc() {
        if (scoreJugador == 10) {
            Toast.makeText(this, "Ganastes " + nom_jugador + ". Score: " + scoreJugador, Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);
            finish();
        } else if (scoreComputer == 10) {
            Toast.makeText(this, "¡Lo siento perdistes ! " + nom_jugador + ". gano tu MiniMochi!.  Score: " + scoreComputer, Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        //no hace nada
    }
}