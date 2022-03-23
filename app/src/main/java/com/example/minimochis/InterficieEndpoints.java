package com.example.minimochis;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface InterficieEndpoints {
    // Request method and URL specified in the annotation

    @GET("usuaris")
    Call<List<Usuari>> getLlistaUsuaris();

    @GET("usuaris/{nom_usuari}")
    Call<Usuari> getUser(@Path("nom_usuari") String nom_usuari);

    @POST("usuaris")
    Call<Usuari> createUser(@Body Usuari usuari);
}
