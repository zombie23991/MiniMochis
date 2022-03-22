package com.example.minimochis;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import pl.droidsonroids.gif.GifImageView;

public class Home extends Fragment {
    Button eleccio_minimochi, options;
    GifImageView minimochji;


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

        //Intent de fragment de botons
        options.setOnClickListener(new  View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getActivity(), Opcions.class);
                startActivity(intent);
            }
        });


    }


}
