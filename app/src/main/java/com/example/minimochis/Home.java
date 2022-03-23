package com.example.minimochis;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import pl.droidsonroids.gif.GifImageView;

public class Home extends Fragment {
    FloatingActionButton eleccio_minimochi, options;
    GifImageView minimochji;

    int mini = 2;

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
        options = getView().findViewById(R.id.options);
        eleccio_minimochi = getView().findViewById(R.id.eleccio_minimochi);

        //GIF
        minimochji = getView().findViewById(R.id.minimochi);

        //iniciar dialog
        miDialog = new Dialog(getActivity());

        //posem minimochi preseleccionat
        minimochji.setImageResource(R.drawable.minimochirosa);

        //Quan presonas al minimochi
        minimochji.setOnClickListener(new  View.OnClickListener(){
            @Override
            public void onClick(View view){
                dance();
            }
        });

        //Intent de fragment de botons (Boto de opcions i eleccio de minimochi)
        options.setOnClickListener(new  View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getActivity(), Opcions.class);
                startActivity(intent);
            }
        });
        eleccio_minimochi.setOnClickListener(new  View.OnClickListener(){
            @Override
            public void onClick(View view){
                Options();
            }
        });

    }

    private void Options(){
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
        if(mini == 1){
            minimochiOne.setBackgroundResource(R.drawable.boto_personalitzat);
        } else if (mini == 2){
            minimochiTwo.setBackgroundResource(R.drawable.boto_personalitzat);
        } else if (mini == 3){
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
                mini = 1;
            }
        });

        minimochiTwo.setOnClickListener(new  View.OnClickListener(){
            @Override
            public void onClick(View view){
                minimochji.setImageResource(R.drawable.minimochirosa);
                minimochiOne.setBackgroundResource(0);
                minimochiTwo.setBackgroundResource(R.drawable.boto_personalitzat);
                minimochiThree.setBackgroundResource(0);
                mini = 2;
            }
        });

        minimochiThree.setOnClickListener(new  View.OnClickListener(){
            @Override
            public void onClick(View view){
                minimochji.setImageResource(R.drawable.minimochiblau);
                minimochiOne.setBackgroundResource(0);
                minimochiTwo.setBackgroundResource(0);
                minimochiThree.setBackgroundResource(R.drawable.boto_personalitzat);
                mini = 3;
            }
        });

        miDialog.show();
    }

    private void dance(){
        if(mini == 1){
            minimochji.setImageResource(R.drawable.minimochiblancdance);

            new CountDownTimer( 3000, 50 ) {

                public void onTick(long millisUntilFinished) {

                }
                public void onFinish() {
                    minimochji.setImageResource(R.drawable.minimochiblanc);
                }
            }.start();
        } else if (mini == 2){
            minimochji.setImageResource(R.drawable.minimochirosadance);

            new CountDownTimer( 3000, 50 ) {

                public void onTick(long millisUntilFinished) {

                }
                public void onFinish() {
                    minimochji.setImageResource(R.drawable.minimochirosa);
                }
            }.start();
        } else if (mini == 3){
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
