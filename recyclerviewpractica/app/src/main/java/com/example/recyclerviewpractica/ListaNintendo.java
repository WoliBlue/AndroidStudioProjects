package com.example.recyclerviewpractica;

public class ListaNintendo {
    private int idImagen;
    private String textoEncima;
    private String textoAbajo;

    public ListaNintendo(int idImagen, String textoEncima, String textoAbajo) {
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
}
