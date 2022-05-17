package com.example.minimochis;

import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import pl.droidsonroids.gif.GifImageView;

public class Home extends Fragment {
    FloatingActionButton eleccio_minimochi, options;
    GifImageView minimochji;
    MediaPlayer mp;
    boolean isChecked=true;
    ImageView music;


    FloatingActionButton buttonoptions;
    public personatge personatge = new personatge (0);

    //Dialog per obrir
    Dialog miDialog;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_layout,container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
        //Botons

        mp = MediaPlayer.create(getContext(), R.raw.fons);
        mp.start();

        options = getView().findViewById(R.id.options);
        eleccio_minimochi = getView().findViewById(R.id.eleccio_minimochi);
        buttonoptions = getView().findViewById(R.id.options);


        //GIF
        minimochji = getView().findViewById(R.id.minimochi);

        //iniciar dialog
        miDialog = new Dialog(getActivity());

        //posem minimochi preseleccionat
        //minimochji.setImageResource(R.drawable.minimochirosa);

        //Quan presonas al minimochi
        minimochji.setOnClickListener(new  View.OnClickListener(){
            @Override
            public void onClick(View view){
                dance();
            }
        });

        //Si el usuari no te seleccionat minimochi
        if (personatge.getEleccio() == 0){
            ElegirMinimochi();
        }

        //Intent de fragment de botons (Boto de opcions i eleccio de minimochi)

        eleccio_minimochi.setOnClickListener(new  View.OnClickListener(){
            @Override
            public void onClick(View view){
                ElegirMinimochi();
            }
        });

        buttonoptions.setOnClickListener(new  View.OnClickListener(){
            @Override
            public void onClick(View view){
                Settings();
            }
        });

    }


    private void Settings(){
        FloatingActionButton sortir;
        miDialog.setContentView(R.layout.settings);
        miDialog.setCanceledOnTouchOutside(false);
        miDialog.setCancelable(false);

        music = miDialog.findViewById(R.id.Song);


        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isChecked) {
                    isChecked = false;
                    if (!mp.isPlaying()) {
                        music.setImageResource(R.drawable.ic_baseline_music_note_24);
                        mp.start();
                    }
                } else {
                    isChecked = true;
                    if (mp.isPlaying()) {
                        music.setImageResource(R.drawable.musicof);
                        mp.pause();
                    }
                }
            }
        });

        //Botons
        sortir = miDialog.findViewById(R.id.sortir);

        sortir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                miDialog.dismiss();
            }
        });
        //Per poder veure quin minimochi tenim seleccionat

        miDialog.show();
    }

    private void ElegirMinimochi(){
        FloatingActionButton sortir;
        GifImageView minimochiOne, minimochiTwo, minimochiThree;

        miDialog.setContentView(R.layout.eleccio_minimochi);
        miDialog.setCanceledOnTouchOutside(false);
        miDialog.setCancelable(false);

        //Botons
        sortir = miDialog.findViewById(R.id.sortir);

        //GIF
        minimochiOne = miDialog.findViewById(R.id.minimochiOne);
        minimochiTwo = miDialog.findViewById(R.id.minimochiTwo);
        minimochiThree = miDialog.findViewById(R.id.minimochiThree);

        //posem imatges(GIF)
        minimochiOne.setImageResource(R.drawable.minimochiblanc);
        minimochiTwo.setImageResource(R.drawable.minimochirosa);
        minimochiThree.setImageResource(R.drawable.minimochiblau);

        //Per poder veure quin minimochi tenim seleccionat
        if(personatge.getEleccio() == 1){
            minimochiOne.setBackgroundResource(R.drawable.boto_personalitzat);
        } else if (personatge.getEleccio()== 2){
            minimochiTwo.setBackgroundResource(R.drawable.boto_personalitzat);
        } else if (personatge.getEleccio() == 3){
            minimochiThree.setBackgroundResource(R.drawable.boto_personalitzat);
        }
        //Boto per sortir del dialog
        sortir.setOnClickListener(new  View.OnClickListener(){
            @Override
            public void onClick(View view){
                miDialog.dismiss();
            }
        });

        //Al selecionar un minimochi
        minimochiOne.setOnClickListener(new  View.OnClickListener(){
            @Override
            public void onClick(View view){
                minimochji.setImageResource(R.drawable.minimochiblanc);
                minimochiOne.setBackgroundResource(R.drawable.boto_personalitzat);
                minimochiTwo.setBackgroundResource(0);
                minimochiThree.setBackgroundResource(0);
                personatge.setEleccio(1);
            }
        });

        minimochiTwo.setOnClickListener(new  View.OnClickListener(){
            @Override
            public void onClick(View view){
                minimochji.setImageResource(R.drawable.minimochirosa);
                minimochiOne.setBackgroundResource(0);
                minimochiTwo.setBackgroundResource(R.drawable.boto_personalitzat);
                minimochiThree.setBackgroundResource(0);
                personatge.setEleccio(2);
            }
        });

        minimochiThree.setOnClickListener(new  View.OnClickListener(){
            @Override
            public void onClick(View view){
                minimochji.setImageResource(R.drawable.minimochiblau);
                minimochiOne.setBackgroundResource(0);
                minimochiTwo.setBackgroundResource(0);
                minimochiThree.setBackgroundResource(R.drawable.boto_personalitzat);
                personatge.setEleccio(3);
            }
        });

        miDialog.show();
    }

    private void dance(){
        
        if(personatge.getEleccio() == 1){
            minimochji.setImageResource(R.drawable.minimochiblancdance);

            new CountDownTimer( 3000, 50 ) {

                public void onTick(long millisUntilFinished) {
                }
                public void onFinish() {
                    minimochji.setImageResource(R.drawable.minimochiblanc);
                }
            }.start();
            
        } else if (personatge.getEleccio() == 2){
            minimochji.setImageResource(R.drawable.minimochirosadance);

            new CountDownTimer( 3000, 50 ) {

                public void onTick(long millisUntilFinished) {

                }
                public void onFinish() {
                    minimochji.setImageResource(R.drawable.minimochirosa);
                }
            }.start();
        } else if (personatge.getEleccio() == 3){
            minimochji.setImageResource(R.drawable.minimochiblaudance);

            new CountDownTimer( 3000, 50 ) {

                public void onTick(long millisUntilFinished) {

                }
                public void onFinish() {
                    minimochji.setImageResource(R.drawable.minimochiblau);
                }
            }.start();
        }
    }

}
