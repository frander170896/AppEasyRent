package com.example.frander.alquilersoft.Distric;

/**
 * Created by Frander on 13/11/2017.
 */

public class Distric {
    int id;
    String name;
    int is_active;
    int id_canton;

    public Distric() {

    }

    public Distric(int id, String name, int is_active, int id_canton) {
        this.id = id;
        this.name = name;
        this.is_active = is_active;
        this.id_canton = id_canton;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIs_active() {
        return is_active;
    }

    public void setIs_active(int is_active) {
        this.is_active = is_active;
    }

    public int getId_canton() {
        return id_canton;
    }

    public void setId_canton(int id_canton) {
        this.id_canton = id_canton;
    }
}
