package com.example.phpjsonconsolas;


public class Consola {
    private String id, nombre, descripcion, anio;

    public Consola(String id, String nombre, String descripcion, String anio) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.anio = anio;
    }

    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public String getAnio() { return anio; }
}
