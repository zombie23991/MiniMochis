package com.example.minimochis;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.util.Patterns;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Login extends AppCompatActivity {
    private EditText etCorreuLogin, etContrassenyaLogin;
    private Button btLogin;
    private String urlApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        /*setContentView(R.layout.activity_login);

        btLogin = findViewById(R.id.BTLogin);*/

        urlApi = "http://minimochi.test/api/usuaris/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(urlApi)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        InterficieEndpoints serveiApi = retrofit.create(InterficieEndpoints.class);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String correu = etCorreuLogin.getText().toString();
                String contrassenya = etContrassenyaLogin.getText().toString();

                /* VALIDAR LES DADES */
                /* VALIDACIÓ CORREU ELECTRÒNIC */
                if(!Patterns.EMAIL_ADDRESS.matcher(correu).matches()){
                    etCorreuLogin.setError("El correu introduït és invàlid");
                    etCorreuLogin.setFocusable(true);

                    /* VALIDACÓ CONTRASSENYA */
                } else if(contrassenya.length() < 6) {
                    etContrassenyaLogin.setError("La contrassenya ha de ser de 6 caracters");
                    etContrassenyaLogin.setFocusable(true);
                } else {
                    loginJugador(correu, contrassenya);
                }
                String username = "Holabones";
                Call<Usuari> call = serveiApi.getUser(username);
                call.enqueue(new Callback<Usuari>() {
                    @Override
                    public void onResponse(Call<Usuari> call, Response<Usuari> response) {
                        int statusCode = response.code();
                        Usuari usuari = response.body();
                        Toast.makeText(Login.this, usuari.getNom_usuari(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Usuari> call, Throwable t) {
                        Toast.makeText(Login.this, "No es troba el servidor", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    public void loginJugador(String correu, String contrassenya){

    }
}