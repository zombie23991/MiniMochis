package com.example.minimochis;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Login extends AppCompatActivity {
    EditText etNomUsuariLogin, etContrassenyaLogin;
    Button btLogin;
    ImageView imageView;
    TextView textView;
    String urlApi;
    InterficieEndpoints serveiApi;
    int count = 0;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);

        textView = findViewById(R.id.TextRegistret);
        btLogin = findViewById(R.id.BTLogin);
        imageView = findViewById(R.id.imageView);
        etNomUsuariLogin = (EditText) findViewById(R.id.NomUsuariLogin);
        etContrassenyaLogin = (EditText) findViewById(R.id.PasswordLogin);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        urlApi = "http://10.0.2.2:8000/api/";

        Retrofit retrofit = new Retrofit.Builder()
              .baseUrl(urlApi)
            .addConverterFactory(GsonConverterFactory.create())
          .build();

        serveiApi = retrofit.create(InterficieEndpoints.class);

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
        textView.setOnClickListener(new View.OnClickListener() {
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
                /* VALIDACIÓ CORREU ELECTRÒNIC */
                if(contrassenya.length() < 6) {
                    etContrassenyaLogin.setError("La contrassenya ha de ser de 6 caracters");
                    etContrassenyaLogin.setFocusable(true);
                } else {
                    loginJugador(nomUsuari, contrassenya);
                }

            }
        });
    }

   public void loginJugador(String nomUsuari, String contrassenya){
        Call<Usuari> call = serveiApi.getUser(nomUsuari);
        call.enqueue(new Callback<Usuari>() {
            @Override
            public void onResponse(Call<Usuari> call, Response<Usuari> response) {
                int statusCode = response.code();
                Usuari usuari = response.body();
                Intent ferLogin = new Intent(Login.this, MainActivity.class);
                startActivity(ferLogin);
                Toast.makeText(Login.this, "Benvingut" + usuari.getNom_usuari(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Usuari> call, Throwable t) {
                Toast.makeText(Login.this, "No es troba el servidor" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}