package com.example.junior.volleyapp.conexao;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Map;

/**
 * Created by junior on 09/04/15.
 */
public class UrlControler {

    private String rota;
    private int method;
    private JSONArray jsonArray;
    private JSONObject jsonObject;
    private Map<String, String> params;
    private String url = "http://192.168.56.1/nef/noivosemfesta/index.php";
    private RequestQueue rq;

    public UrlControler(String rota, int method, Map<String, String> params, Context context) throws Exception{
        setRota(rota);
        setMethod(method);
        this.params = params;
        
        rq = Volley.newRequestQueue(context);
    }


    public JSONObject viaJsonObjectPOST() throws  Exception{

        CustomJsonObjectRequest jor = new CustomJsonObjectRequest(
                getMethod(),getRota(),params,new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {

                setJsonObject(jsonObject);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

                Log.i("ERRO URLCONTROLER ",volleyError.toString());

            }
        });

        jor.setTag("LOGIN");
        rq.add(jor);

        return getJsonObject();
    }
    public JSONObject viaJsonObjectGET() throws  Exception{

        CustomJsonObjectRequest jor = new CustomJsonObjectRequest(
                Request.Method.GET,getRota(),params,new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {

                setJsonObject(jsonObject);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

                Log.i("ERRO URLCONTROLER ",volleyError.toString());

            }
        });

        return getJsonObject();
    }


    public String getRota() {
        return url + rota;
    }

    public void setRota(String rota) {
        this.rota = rota;
    }

    public int getMethod() {
        return method;
    }

    public void setMethod(int method) {
        this.method = method;
    }

    public JSONArray getJsonArray() {
        return jsonArray;
    }

    public void setJsonArray(JSONArray jsonArray) {
        this.jsonArray = jsonArray;
    }

    public JSONObject getJsonObject() {
        return jsonObject;
    }

    public void setJsonObject(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }
}
