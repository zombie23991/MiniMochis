package com.example.minimochis;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MemoryGame extends AppCompatActivity {

    Drawable iconaDefecte;
    ImageView carta1, carta2, carta3, carta4, carta5, carta6, carta7, carta8, carta9, carta10, carta11, carta12, imatgeTocada1, imatgeTocada2;
    Integer imatgeTocada = 0;

    ArrayList<Integer> imatges = new ArrayList<Integer>();
    ArrayList<ImageView> cartes = new ArrayList<ImageView>();
    ArrayList<ImageView> amagarImatges = new ArrayList<ImageView>();

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_game);
        iconaDefecte = getResources().getDrawable(R.drawable.iconominimochi);

        cartes.add(carta1 = findViewById(R.id.carta1)); cartes.add(carta2 = findViewById(R.id.carta2));
        cartes.add(carta3 = findViewById(R.id.carta3)); cartes.add(carta4 = findViewById(R.id.carta4));
        cartes.add(carta5 = findViewById(R.id.carta5)); cartes.add(carta6 = findViewById(R.id.carta6));
        cartes.add(carta7 = findViewById(R.id.carta7)); cartes.add(carta8 = findViewById(R.id.carta8));
        cartes.add(carta9 = findViewById(R.id.carta9)); cartes.add(carta10 = findViewById(R.id.carta10));
        cartes.add(carta11 = findViewById(R.id.carta11)); cartes.add(carta12 = findViewById(R.id.carta12));

        // Es posa la mateixa imatge per defecte (Amb el mateix Id) a totes les cartes
        setImatgeDefecte();

        imatges.add(R.drawable.croqueta1); imatges.add(R.drawable.croqueta2); imatges.add(R.drawable.croqueta3);
        imatges.add(R.drawable.croqueta4); imatges.add(R.drawable.croqueta5); imatges.add(R.drawable.croqueta6);
        //Funció per agafar un numero entre un mínim i un màxim
        //random.nextInt(max - min + 1) + min

        establirImatgesRandom();
        setImatgeDefecte();

        for(ImageView carta : cartes) {
            carta.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    carta.setImageResource(Integer.parseInt(amagarImatges.get(cartes.indexOf(carta)).getTag().toString()));
                    imatgeTocada++;

                    if(imatgeTocada == 1){
                        imatgeTocada1 = carta;
                    } else if (imatgeTocada == 2){
                        imatgeTocada2 = carta;
                    }

                    if(imatgeTocada == 2) {
                        if(!compararImatges(imatgeTocada1.getDrawable(), imatgeTocada2.getDrawable())){
                            for(ImageView imatge : cartes) {
                                imatge.setClickable(false);
                            }

                            final Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    imatgeTocada1.setImageResource(R.drawable.iconominimochi);
                                    imatgeTocada2.setImageResource(R.drawable.iconominimochi);

                                    for(ImageView imatge : cartes) {
                                        imatge.setClickable(true);
                                    }
                                }
                            }, 1500);
                        }
                        imatgeTocada = 0;
                    }
                }
            });
        }


    }

    @SuppressLint("UseCompatLoadingForDrawables")
    public void establirImatgesRandom(){
        Random rn = new Random();
        int numAleatori;
        int posImatges = 0;

        while(arrayPle()){
            numAleatori = rn.nextInt(11 + 1);
            // Agafem el drawable de la imatge buida random a la que assignarem
            // la imatge
            Drawable imatgeRandom = cartes.get(numAleatori).getDrawable();

            // Només hi ha 6 imatges que s'han de repetir
            posImatges = rn.nextInt(5 + 1);
            // Comprovem si la imatge random té la imatge per defecte assignada (Està buida) i
            // si està repetida més de dos cops
            if(imatgeRandom == iconaDefecte && !comprovarRepetit(getResources().getDrawable(imatges.get(posImatges)))) {
                cartes.get(numAleatori).setImageResource(imatges.get(posImatges));
                cartes.get(numAleatori).setTag(imatges.get(posImatges));
                amagarImatges.add(cartes.get(numAleatori));
            }
            posImatges++;
        }
    }

    public boolean comprovarRepetit(Drawable imatgeComprovar){

        boolean repetida = false;
        int contador = 0;

        for (ImageView imatge : cartes) {
            if(compararImatges(imatge.getDrawable(), imatgeComprovar)) {
                contador++;
            }
        }

        if(contador > 1) {
            repetida = true;
        }
        return repetida;
    }

    public boolean arrayPle(){
        boolean arrayPle = false;

        for(int i = 0; i < cartes.size(); i++){
            Log.e("Prova drawable: ", "" + cartes.get(i).getDrawable() + "Icona defecte " + iconaDefecte);
            if(cartes.get(i).getDrawable() == iconaDefecte){
                arrayPle = true;
            }
        }

        return arrayPle;
    }

    public void setImatgeDefecte(){
        for(ImageView imgCarta : cartes) {
            imgCarta.setImageDrawable(iconaDefecte);
        }
    }

    public boolean compararImatges(Drawable imatgeComparar1, Drawable imatgeComparar2){
        boolean iguals = false;

        Bitmap bmImatgeComparar1 = ((BitmapDrawable)imatgeComparar1).getBitmap();
        Bitmap bmImatgeComparar2 = ((BitmapDrawable)imatgeComparar2).getBitmap();

        if(bmImatgeComparar1 == bmImatgeComparar2) {
            iguals = true;
        }

        return iguals;
    }

}