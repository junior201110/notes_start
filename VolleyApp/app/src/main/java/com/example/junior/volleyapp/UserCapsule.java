package com.example.junior.volleyapp;

import com.google.gson.Gson;

/**
 * Created by junior on 06/04/15.
 */
public class UserCapsule {
    private String id;
    private String user;
    private String senha;

    public UserCapsule loadUserFromJSONGson(String jsonString) {
        Gson gson = new Gson();
        UserCapsule user = gson.fromJson(jsonString, UserCapsule.class);
        return user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
