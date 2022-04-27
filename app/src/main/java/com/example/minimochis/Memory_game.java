package com.example.minimochis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class Memory_game extends AppCompatActivity {

    ImageView carta1, carta2, carta3, carta4, carta5, carta6, carta7, carta8, carta9, carta10, carta11, carta12;
    ImageView croqueta1, croqueta2, croqueta3, croqueta4, croqueta5, croqueta6;
    ArrayList<Integer> imatges = new ArrayList<Integer>();
    ArrayList<ImageView> cartes = new ArrayList<ImageView>();
    ImageView memoryCards[] = new ImageView[12];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_game);

        cartes.add(carta1 = findViewById(R.id.carta1)); cartes.add(carta2 = findViewById(R.id.carta2));
        cartes.add(carta3 = findViewById(R.id.carta3)); cartes.add(carta4 = findViewById(R.id.carta4));
        cartes.add(carta5 = findViewById(R.id.carta5)); cartes.add(carta6 = findViewById(R.id.carta6));
        cartes.add(carta7 = findViewById(R.id.carta7)); cartes.add(carta8 = findViewById(R.id.carta8));
        cartes.add(carta9 = findViewById(R.id.carta9)); cartes.add(carta10 = findViewById(R.id.carta10));
        cartes.add(carta11 = findViewById(R.id.carta11)); cartes.add(carta12 = findViewById(R.id.carta12));

        imatges.add(R.drawable.croqueta1); imatges.add(R.drawable.croqueta2); imatges.add(R.drawable.croqueta3);
        imatges.add(R.drawable.croqueta4); imatges.add(R.drawable.croqueta5); imatges.add(R.drawable.croqueta6);
        //Funció per agafar un numero entre un mínim i un màxim
        //random.nextInt(max - min + 1) + min

        Toast.makeText(this, "" + cartes.size(), Toast.LENGTH_SHORT).show();
        Random rn = new Random();
        int numAleatori;
        int pos = 0;

        Log.e("Prova memory", "" + arrayPle() + " " + memoryCards.length);

        while(arrayPle()){
            Log.e("Prova memory bucle", "" + arrayPle() + " " + memoryCards.length);
            numAleatori = rn.nextInt(12 - 1);
            Log.e("Prova pos bucle: ", "" + memoryCards[numAleatori]);
            if(memoryCards[pos] == null) {
                if(pos > 12) {
                    pos = 0;
                }
                memoryCards[pos] = cartes.get(numAleatori);
            }
            pos++;
        }

        omplirArray();
    }

    public boolean arrayPle(){
        boolean arrayPle = false;

        for(int i = 0; i < memoryCards.length; i++){
            if(memoryCards[i] == null){
                arrayPle = true;
            }
        }

        return arrayPle;
    }

    public void omplirArray() {
        int posMemory = 0;
        int posImatges = 0;

        while(arrayPle()) {
            memoryCards[posMemory].setImageResource(imatges.get(posImatges));
            posMemory++;
            posImatges++;
            if (posImatges > 6) {
                posImatges = 0;
            }
        }
    }
}