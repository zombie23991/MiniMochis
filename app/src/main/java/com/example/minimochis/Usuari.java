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

    public void setPasos(int pasos) {
        this.pasos = pasos;
    }

    public void setNum_minimochi(int num_minimochi) {
        this.num_minimochi = num_minimochi;
    }

    public void setNom_usuari(String nom_usuari) {
        this.nom_usuari = nom_usuari;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLlistaUsuaris(List<Usuari> llistaUsuaris) {
        this.llistaUsuaris = llistaUsuaris;
    }
}
