package com.example.frander.alquilersoft.Inquilino;

/**
 * Created by Frander on 23/05/2017.
 */

public class Inquilino {

    private String nombre;
    private String apellido;
    private String numeroCelular;
    private int imagen;

    public Inquilino(String nombre, String apellido, String numeroCelular, int imagen) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroCelular = numeroCelular;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
