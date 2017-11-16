package com.example.frander.alquilersoft.User;

/**
 * Created by Usuario on 29/10/2017.
 */

public class UserLogin {

    public String email;
    public String password;

    public UserLogin(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "email:" + email + ", password:" + password;
    }
}
