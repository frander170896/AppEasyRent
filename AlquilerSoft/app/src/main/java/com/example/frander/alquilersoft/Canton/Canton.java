package com.example.frander.alquilersoft.Canton;

/**
 * Created by Frander on 13/11/2017.
 */

public class Canton {

    int id;
    String name;
    int is_active;
    int province_id;

    public Canton(int id, String name, int is_active, int province_id) {
        this.id = id;
        this.name = name;
        this.is_active = is_active;
        this.province_id = province_id;
    }
    public Canton() {

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

    public int getProvince_id() {
        return province_id;
    }

    public void setProvince_id(int province_id) {
        this.province_id = province_id;
    }
}
