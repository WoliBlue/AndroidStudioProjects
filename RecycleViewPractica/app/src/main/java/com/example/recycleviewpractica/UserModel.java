package com.example.recycleviewpractica;

import java.util.ArrayList;
import java.util.List;

public class UserModel {
    private String textoEncima, textoAbajo;
    private int idImagen;

    public UserModel(int idImagen, String textoEncima, String textoAbajo) {
        this.idImagen = idImagen;
        this.textoEncima = textoEncima;
        this.textoAbajo = textoAbajo;
    }


    public int getIdImagen() {

        return idImagen;
    }

    public String getTextoEncima() {

        return textoEncima;
    }

    public String getTextoAbajo() {

        return textoAbajo;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "textoEncima='" + textoEncima + '\'' +
                ", textoAbajo='" + textoAbajo + '\'' +
                ", idImagen=" + idImagen +
                '}';
    }
}


