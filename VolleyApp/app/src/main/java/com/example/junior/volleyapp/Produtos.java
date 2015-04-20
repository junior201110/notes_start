package com.example.junior.volleyapp;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.example.junior.volleyapp.conexao.CustomJsonObjectRequest;

import org.json.JSONObject;

import java.util.Map;

/**
 * Created by junior on 15/04/15.
 */

public class Produtos {

    Map<String, String> params;
    RequestQueue rq;
    String url;

    private JSONObject produto;

    public Produtos(Context context, String url){

        rq = Volley.newRequestQueue(context);
        this.url = url;
        callByJsonObjecttRequest();
    }


    public void callByJsonObjecttRequest(){




        CustomJsonObjectRequest jor = new CustomJsonObjectRequest(Request.Method.GET,
                url,
                params,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        Log.i("Script", "Sucess=>" + response);
                        setProduto(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {



                    }
                });
        jor.setTag("tag");
        rq.add(jor);


    }


    public JSONObject getProduto() {
        return produto;
    }

    public void setProduto(JSONObject produto) {
        this.produto = produto;
    }
}

