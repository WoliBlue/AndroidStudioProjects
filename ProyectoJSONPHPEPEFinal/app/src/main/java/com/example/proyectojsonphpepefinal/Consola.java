package com.example.proyectojsonphpepefinal;

// Clase modelo que representa una consola
public class Consola {
    // Campos de la clase
    private int ID;
    private String nombre;
    private String descripcion;
    private int anio;

    // Constructor
    public Consola(int ID, String nombre, String descripcion, int anio) {
        this.ID = ID;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.anio = anio;
    }

    // Métodos getter para acceder a los campos
    public int getID() { return ID; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public int getAnio() { return anio; }
}