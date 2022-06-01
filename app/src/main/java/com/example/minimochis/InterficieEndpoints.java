package com.example.minimochis;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface InterficieEndpoints {
    // Request method and URL specified in the annotation

    @GET("usuaris")
    Call<List<Usuari>> getLlistaUsuaris();

    @POST("login")
    Call<Usuari> getUser(@Body Usuari usuari);

    @POST("usuaris")
    Call<Usuari> createUser(@Body Usuari usuari);

    @PUT("usuaris/{id}")
    Call<Usuari> actualitzarInfo(@Path("id") int id, @Body Usuari usuari);

    @GET
    Call<MsgModal>getMessage(@Url String url);



}
