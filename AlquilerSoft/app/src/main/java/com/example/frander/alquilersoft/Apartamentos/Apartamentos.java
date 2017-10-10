package com.example.frander.alquilersoft.Apartamentos;

/**
 * Created by Frander on 05/05/2017.
 */

public class Apartamentos {

    private int id;
    private int idPropietario;
    private int idInquilino;
    private int numeroApartamento;
    private int precio;
    private String contacto;
    private String ubicacion;
    private int Capacidad;
    private int disponible;
    private int imagen;

    public Apartamentos(int id, int numeroApartamento, int precio, String ubicacion, int capacidad, int disponible,int imagen) {
        this.id = id;
        this.numeroApartamento = numeroApartamento;
        this.precio = precio;
        this.ubicacion = ubicacion;
        Capacidad = capacidad;
        this.disponible = disponible;
        this.imagen = imagen;
    }

    public Apartamentos(int precio, String contacto, String ubicacion, int capacidad, int imagen) {
        this.precio = precio;
        this.contacto = contacto;
        this.ubicacion = ubicacion;
        Capacidad = capacidad;
        this.imagen = imagen;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(int idPropietario) {
        this.idPropietario = idPropietario;
    }

    public int getIdInquilino() {
        return idInquilino;
    }

    public void setIdInquilino(int idInquilino) {
        this.idInquilino = idInquilino;
    }

    public int getNumeroApartamento() {
        return numeroApartamento;
    }

    public void setNumeroApartamento(int numeroApartamento) {
        this.numeroApartamento = numeroApartamento;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getCapacidad() {
        return Capacidad;
    }

    public void setCapacidad(int capacidad) {
        Capacidad = capacidad;
    }

    public int getDisponible() {
        return disponible;
    }

    public void setDisponible(int disponible) {
        this.disponible = disponible;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
