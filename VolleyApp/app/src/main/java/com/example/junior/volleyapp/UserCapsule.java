package com.example.junior.volleyapp;

import org.json.JSONArray;

/**
 * Created by junior on 06/04/15.
 */
public class UserCapsule {
    private  JSONArray response;

    public JSONArray getResponse() {
        return response;
    }

    public void setResponse(JSONArray reponse) {
        this.response = reponse;
    }
}
