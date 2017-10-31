package com.example.frander.alquilersoft.User;

/**
 * Created by Usuario on 22/10/2017.
 */

public class User {

    private int id;
    private String name;
    private String last_name;
    private String identification_card;
    private String phone_number;
    private String second_number;
    private String email;
    private String password;
    private String account_number;
    private String address;
    private String type;
    private int user_type_id;
    private int is_active;

    public User(int id, String name,
                String last_name, String identification_card,
                String phone_number, String second_number, String email,
                String password, String account_number, String address, String type) {
        this.id = id;
        this.name = name;
        this.last_name = last_name;
        this.identification_card = identification_card;
        this.phone_number = phone_number;
        this.second_number = second_number;
        this.email = email;
        this.password = password;
        this.account_number = account_number;
        this.address = address;
        this.type = type;
    }

    public User(String name, String last_name, String identification_card,
                String phone_number, String second_number, String email,
                String password, String account_number, String address,
                int user_type_id) {
        this.name = name;
        this.last_name = last_name;
        this.identification_card = identification_card;
        this.phone_number = phone_number;
        this.second_number = second_number;
        this.email = email;
        this.password = password;
        this.account_number = account_number;
        this.address = address;
        this.user_type_id = user_type_id;
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

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getIdentification_card() {
        return identification_card;
    }

    public void setIdentification_card(String identification_card) {
        this.identification_card = identification_card;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getSecond_number() {
        return second_number;
    }

    public void setSecond_number(String second_number) {
        this.second_number = second_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getUser_type_id() {
        return user_type_id;
    }

    public void setUser_type_id(int user_type_id) {
        this.user_type_id = user_type_id;
    }

    public int getIs_active() {
        return is_active;
    }

    public void setIs_active(int is_active) {
        this.is_active = is_active;
    }

    @Override
    public String toString() {
        return "name:" + name + ", last_name:" + last_name + ", identification_card:" +
                identification_card + ", phone_number:" + phone_number +
                ", second_number:" + second_number + ", email:" + email + ", password:" + password +
                ", account_number:" + account_number + ", address:" + address +
                ", user_type_id:" + user_type_id;
    }
}
