package com.example.frander.alquilersoft.Apartamentos;

/**
 * Created by Frander on 05/05/2017.
 */

public class Apartamentos {

    int id;
    int capacity;
    int lessee_id;
    int status_id;
    int district_id;
    int is_active;
    float price;

    String name;
    String description;
    String adress;
    String Image;

    public Apartamentos(int id, int capacity, int lessee_id, int status_id, int district_id, int is_active, float price, String name, String description, String adress,String Image) {
        this.id = id;
        this.capacity = capacity;
        this.lessee_id = lessee_id;
        this.status_id = status_id;
        this.district_id = district_id;
        this.is_active = is_active;
        this.price = price;
        this.name = name;
        this.description = description;
        this.adress = adress;
        this.Image = Image;
    }

    public Apartamentos(int capacity, int lessee_id, int status_id, int district_id, int is_active, float price, String name, String description, String adress,String Image) {
        this.capacity = capacity;
        this.lessee_id = lessee_id;
        this.status_id = status_id;
        this.district_id = district_id;
        this.is_active = is_active;
        this.price = price;
        this.name = name;
        this.description = description;
        this.adress = adress;
        this.Image = Image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getLessee_id() {
        return lessee_id;
    }

    public void setLessee_id(int lessee_id) {
        this.lessee_id = lessee_id;
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public int getDistrict_id() {
        return district_id;
    }

    public void setDistrict_id(int district_id) {
        this.district_id = district_id;
    }

    public int getIs_active() {
        return is_active;
    }

    public void setIs_active(int is_active) {
        this.is_active = is_active;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return  "capacity:" + capacity + ", lessee_id:" + lessee_id + ", status_id:" + status_id + ", district_id:" + district_id +
                ", is_active:" + is_active + ", price:" + price + ", name:" + name + ", description:" + description+ ", adress:" + adress+
                ", Image:" + Image;
    }
}
