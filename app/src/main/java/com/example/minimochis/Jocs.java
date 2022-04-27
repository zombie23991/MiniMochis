package com.example.minimochis;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class Jocs extends Fragment {

    CardView joc1, joc2,joc3,joc4;
    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.jocs_layout,container, false);
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        joc1 = getView().findViewById(R.id.joc1);
        joc2 = getView().findViewById(R.id.joc2);
        joc3 = getView().findViewById(R.id.joc3);
        joc4 = getView().findViewById(R.id.joc4);


        joc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Joc_PedraPaperTisora.class);
                startActivity(intent);
            }
        });

        joc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Memory_game.class);
                startActivity(intent);
            }
        });

        /*joc3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Joc_PedraPaperTisora.class);
                startActivity(intent);
            }
        });*/

        /*joc4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Joc_PedraPaperTisora.class);
                startActivity(intent);
            }
        });*/

    }
}
