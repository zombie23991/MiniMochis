package com.example.minimochis;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class clientApi {
    // Classe del client que retorna una interfície per a connectar-se amb la api i fer les crides
    public static Retrofit retornarRetrofit() {
        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8000/api/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit;
    }

    public static InterficieEndpoints connectarApi() {
        InterficieEndpoints serveiApi = retornarRetrofit().create(InterficieEndpoints.class);
        return serveiApi;
    }
}
