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


public class Login extends AppCompatActivity {
    EditText etCorreuLogin, etContrassenyaLogin;
    Button btLogin;
    ImageView imageView;
    TextView textView;
    int count = 0;

    //urlApi = "http://minimochi.test/api/usuaris/";

    //Retrofit retrofit = new Retrofit.Builder()
      //      .baseUrl(urlApi)
        //    .addConverterFactory(GsonConverterFactory.create())
          //  .build();

   // serveiApi = retrofit.create(InterficieEndpoints.class);

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
        textView = findViewById(R.id.TextRegistret);
        btLogin = findViewById(R.id.BTLogin);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        imageView = findViewById(R.id.imageView);
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
                    //loginJugador(correu, contrassenya);
                }

            }
        });
    }

   /* public void loginJugador(String correu, String contrassenya){
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


    } */
}