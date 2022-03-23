package com.example.minimochis;

import java.util.List;

public class Usuari {
    int id;
    String nom_usuari;
    String email;
    String password;
    List<Usuari> llistaUsuaris;

    Usuari(String nomUsuari, String correu, String contrassenya){
        this.nom_usuari = nomUsuari;
        this.email = correu;
        this.password = contrassenya;
    }

    public String getNomUsuari() {
        return nom_usuari;
    }

    public String getCorreu() {
        return email;
    }

    public String getContrassenya() {
        return password;
    }
}
