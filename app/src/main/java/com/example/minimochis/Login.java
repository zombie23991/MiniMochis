package com.example.minimochis;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    EditText etCorreuLogin, etContrassenyaLogin;
    Button btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btLogin = findViewById(R.id.BTLogin);

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
            }
        });
    }

    public void loginJugador(String correu, String contrassenya){

    }
}