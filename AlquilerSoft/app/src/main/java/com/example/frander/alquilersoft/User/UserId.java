package com.example.frander.alquilersoft.User;

/**
 * Created by Usuario on 16/11/2017.
 */

public class UserId {

    public int userId;

    public UserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "userId:" + userId;
    }
}
