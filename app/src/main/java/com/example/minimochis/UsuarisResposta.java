package com.example.minimochis;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class UsuarisResposta {
    GsonBuilder gsonBuilder = new GsonBuilder();
    Gson Gson = gsonBuilder.create();

    @SerializedName("usuaris")
    List<Usuari> usuaris;

    public UsuarisResposta(){
        usuaris = new ArrayList<Usuari>();
    }

    public static UsuarisResposta parseJSON(String response) {
        Gson gson = new GsonBuilder().create();
        UsuarisResposta UsuarisResposta = gson.fromJson(response, UsuarisResposta.class);
        return UsuarisResposta;
    }
}
