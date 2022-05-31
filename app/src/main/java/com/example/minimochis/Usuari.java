package com.example.minimochis;

import java.util.List;

public class Usuari {
    int id, pasos, num_minimochi;

    String nom_usuari, email, password;

    List<Usuari> llistaUsuaris;

    Usuari(String nomUsuari, String correu, String contrassenya){
        this.nom_usuari = nomUsuari;
        this.email = correu;
        this.password = contrassenya;
    }

    Usuari(String nomUsuari, String contrassenya){
        this.nom_usuari = nomUsuari;
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

    public int getId() {
        return id;
    }

    public int getPasses() {
        return pasos;
    }

    public int getNum_minimochi() {
        return num_minimochi;
    }
}
