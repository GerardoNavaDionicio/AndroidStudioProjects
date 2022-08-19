package com.example.obtener_image;

import android.content.Context;

import java.util.List;

public class Productos {


    private int id;
    private double precio;
    private String nombre;
    private String imagen;

    public Productos(int id, double precio, String nombre, String imagen)
    {
        this.id=id;
        this.precio=precio;
        this.nombre=nombre;
        this.imagen=imagen;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getImagen() {
        return imagen;
    }
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}

