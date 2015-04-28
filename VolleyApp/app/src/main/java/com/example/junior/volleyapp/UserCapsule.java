package com.example.junior.volleyapp;

<<<<<<< HEAD
import org.json.JSONArray;
=======
import com.google.gson.Gson;
>>>>>>> eaf2e1f7690a1b4f2f13003adba24344a13e08c3

/**
 * Created by junior on 06/04/15.
 */
public class UserCapsule {
<<<<<<< HEAD
    private  JSONArray response;

    public JSONArray getResponse() {
        return response;
    }

    public void setResponse(JSONArray reponse) {
        this.response = reponse;
=======
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
>>>>>>> eaf2e1f7690a1b4f2f13003adba24344a13e08c3
    }
}
