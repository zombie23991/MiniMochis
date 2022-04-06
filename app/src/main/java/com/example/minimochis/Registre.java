package com.example.minimochis;

import static android.content.ContentValues.TAG;

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

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Registre extends AppCompatActivity {
    EditText etNomUsuariRegistre, etCorreuRegistre, etContrassenyaRegistre;
    Button btRegistre;
    ImageView imageView;
    TextView portarLogin;

    int count = 0;

    InterficieEndpoints serveiApi;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_registre);

        portarLogin = findViewById(R.id.TextLogin);
        btRegistre = findViewById(R.id.BTRegistre);
        imageView = findViewById(R.id.imageView);

        etNomUsuariRegistre = (EditText) findViewById(R.id.NomUsuariRegistre);
        etCorreuRegistre = (EditText) findViewById(R.id.MailRegistre);
        etContrassenyaRegistre = (EditText) findViewById(R.id.PasswordRegistre);

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

        portarLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Registre.this, Login.class);
                startActivity(i);
            }
        });

        btRegistre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nomUsuari = etNomUsuariRegistre.getText().toString();
                String correu = etCorreuRegistre.getText().toString();
                String contrassenya = etContrassenyaRegistre.getText().toString();

                /* VALIDAR LES DADES */
                if (!validarFormatEmail(correu)) {
                    Toast.makeText(Registre.this, "El correu introduït és invàlid", Toast.LENGTH_LONG).show();
                    etCorreuRegistre.setFocusable(true);
                } else if(contrassenya.length() < 6) {
                    Toast.makeText(Registre.this, "La contrassenya ha de ser de 6 caràcters", Toast.LENGTH_LONG).show();
                    etContrassenyaRegistre.setFocusable(true);
                } else {
                    comprovarInfoJugador(nomUsuari, correu, contrassenya);
                }
            }
        });
    }

    public boolean validarFormatEmail(String correu) {
        final String EMAIL_PATTERN =
                "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        final Pattern format = Pattern.compile(EMAIL_PATTERN);
        final Matcher igualador = format.matcher(correu);
        return igualador.matches();
    }

    public void registrarJugador(String nomUsuari, String correu, String contrassenya){
        Usuari usuariNou = new Usuari(nomUsuari, correu, contrassenya);

        Call<Usuari> cridaRegistre = clientApi.connectarApi().createUser(usuariNou);
        cridaRegistre.enqueue(new Callback<Usuari>() {
            @Override
            public void onResponse(Call<Usuari> call, Response<Usuari> response) {
                Usuari usuari = response.body();
                if(usuari != null){
                    Toast.makeText(Registre.this, "L'usuari " + usuari.getNomUsuari() + " s'ha creat correctament. Benvingut!", Toast.LENGTH_LONG).show();
                    Intent ferRegistre = new Intent(Registre.this, Login.class);
                    startActivity(ferRegistre);
                }
            }

            @Override
            public void onFailure(Call<Usuari> call, Throwable t) {
                Toast.makeText(Registre.this, "No es troba el servidor" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void comprovarInfoJugador(String nomUsuari, String correu, String contrassenya){
        Call<List<Usuari>> cridaComprovarInfoJugador = clientApi.connectarApi().getLlistaUsuaris();

        cridaComprovarInfoJugador.enqueue(new Callback<List<Usuari>>() {
            @Override
            public void onResponse(Call<List<Usuari>> call, Response<List<Usuari>> response) {
                List<Usuari> usuaris = response.body();

                for(int pos = 0; pos < usuaris.size(); pos++) {
                    String nomUsuariExistent = usuaris.get(pos).getNomUsuari();
                    String correuExistent = usuaris.get(pos).getCorreu();
                    String contrassenyaExistent = usuaris.get(pos).getContrassenya();
                    boolean existeix = false;
                    Log.d(TAG, "1" + existeix);
                    if(nomUsuari.equals(nomUsuariExistent)){
                        existeix = true;
                        Toast.makeText(Registre.this, "El nom d'usuari introduït ja existeix", Toast.LENGTH_LONG).show();
                    } else if (correu.equals(correuExistent)) {
                        existeix = true;
                        Toast.makeText(Registre.this, "El correu introduït ja existeix", Toast.LENGTH_LONG).show();
                    } else if (contrassenya.equals(contrassenyaExistent)){
                        existeix = true;
                        Toast.makeText(Registre.this, "La contrassenya introduïda ja existeix", Toast.LENGTH_LONG).show();
                    }

                    if(existeix) {
                        etNomUsuariRegistre.setText(null);
                        etCorreuRegistre.setText(null);
                        etContrassenyaRegistre.setText(null);
                    } else {
                        registrarJugador(nomUsuari, correu, contrassenya);
                    }
                    //Exemple snackbar
                    /*Snackbar.make(findViewById(R.id.textView),
                            "El nom d'usuari introduït ja existeix",
                            BaseTransientBottomBar.LENGTH_LONG).show(); */
                }


            }

            @Override
            public void onFailure(Call<List<Usuari>> call, Throwable t) {
                Toast.makeText(Registre.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}