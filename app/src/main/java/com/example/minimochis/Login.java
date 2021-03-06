package com.example.minimochis;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Patterns;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Login extends AppCompatActivity {
    EditText etNomUsuariLogin, etContrassenyaLogin;
    Button btLogin;
    ImageView imageView;
    TextView portarRegistre;

    int count = 0;

    InterficieEndpoints serveiApi;

    public static Usuari usuariIniciat;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);

        portarRegistre = findViewById(R.id.TextRegistret);
        btLogin = findViewById(R.id.BTLogin);
        imageView = findViewById(R.id.imageView);
        etNomUsuariLogin = (EditText) findViewById(R.id.NomUsuariLogin);
        etContrassenyaLogin = (EditText) findViewById(R.id.PasswordLogin);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        imageView.setOnTouchListener(new OnSwipeTouchListener(getApplicationContext()) {
            public void onSwipeTop() {
            }

            public void onSwipeRight() {
                if (count == 0) {
                    imageView.setImageResource(R.drawable.good_night_img);
                    count = 1;
                } else {
                    imageView.setImageResource(R.drawable.good_morning_img);
                    count = 0;
                }
            }

            public void onSwipeLeft() {
                if (count == 0) {
                    imageView.setImageResource(R.drawable.good_night_img);
                    count = 1;
                } else {
                    imageView.setImageResource(R.drawable.good_morning_img);
                    count = 0;
                }
            }

            public void onSwipeBottom() {
            }

        });

        portarRegistre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login.this, Registre.class);
                startActivity(i);
            }
        });

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nomUsuari = etNomUsuariLogin.getText().toString();
                String contrassenya = etContrassenyaLogin.getText().toString();

                /* VALIDAR LES DADES */
                /* VALIDACI?? CONTRASSENYA */
                if(contrassenya.length() < 6) {
                    Toast.makeText(Login.this, "La contrassenya ha de ser de 6 caracters", Toast.LENGTH_LONG).show();
                    etContrassenyaLogin.setFocusable(true);
                } else {
                    loginJugador(nomUsuari, contrassenya);
                }

            }
        });
    }

   public void loginJugador(String nomUsuari, String contrassenya){
       Usuari login = new Usuari(nomUsuari, contrassenya);
       Call<Usuari> crida = clientApi.connectarApi().getUser(login);

       crida.enqueue(new Callback<Usuari>() {
           @Override
           public void onResponse(Call<Usuari> call, Response<Usuari> resposta) {
               Usuari usuariResposta = resposta.body();

               if (usuariResposta != null && usuariResposta.getNomUsuari() != null && usuariResposta.getContrassenya() != null) {
                   usuariIniciat = usuariResposta;
                   Intent iniciarLogin = new Intent(Login.this, MainActivity.class);
                   startActivity(iniciarLogin);
                   Toast.makeText(Login.this, "Benvingut " + usuariResposta.getNomUsuari(), Toast.LENGTH_LONG).show();
               } else {
                   Toast.makeText(Login.this, "El nom d'usuari o la contrassenya s??n incorrectes "
                           + usuariResposta.getNomUsuari(), Toast.LENGTH_LONG).show();
               }
           }

           @Override
           public void onFailure(Call<Usuari> call, Throwable t) {
               Toast.makeText(getApplicationContext(), "onFailure called ", Toast.LENGTH_SHORT).show();
               Log.e("Error:", ""+ t.getLocalizedMessage());
               call.cancel();
           }
       });

       /*Call<Usuari> cridaLogin = clientApi.connectarApi().getUser(nomUsuari);
        cridaLogin.enqueue(new Callback<Usuari>() {
            @Override
            public void onResponse(Call<Usuari> call, Response<Usuari> response) {
                if(response.isSuccessful()){
                    Usuari usuari = response.body();

                    if(usuari.getNomUsuari().equals(nomUsuari) && usuari.getContrassenya().equals(contrassenya)) {
                        Intent ferLogin = new Intent(Login.this, MainActivity.class);
                        startActivity(ferLogin);
                    } else {
                        Toast.makeText(Login.this, "El nom d'usuari o la contrassenya s??n incorrectes",
                                Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Login.this, "L'usuari no existeix", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Usuari> call, Throwable t) {
                Toast.makeText(Login.this, t.getLocalizedMessage() + " ", Toast.LENGTH_SHORT).show();
            }
        });*/


    }
}